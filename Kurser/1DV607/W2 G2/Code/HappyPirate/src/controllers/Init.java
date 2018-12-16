package controllers;


import models.Boat;
import models.Catalogue;
import models.Member;
import views.ConsoleView;

public class Init {
	
	private Catalogue catalogue; 
	private int currentid = 0;
	
	private final int NO_MEMBER = -1;
	private final String NO_BOAT = "";
	
	private int selectedMemberID = NO_MEMBER;
	private String selectedBoatID = NO_BOAT;
	
	
	/*
	 * Init:
	 * Try loading a new catalogue from persistence. 
	 * If there is no one, create a new catalogue and save the information. 
	 * */
	public Init(DAO persistence) throws Exception {
		
		try {
			catalogue = persistence.loadCatalogue();
			Member lastMember = catalogue.getCatalogue().reduce((first,second) -> second ).get();
			currentid = lastMember.getMemberId();
			
		} catch (Exception e) {
			catalogue = new Catalogue();
			persistence.saveCatalogue(catalogue);
		}
	}
	
	
	
	
	public boolean start(ConsoleView view, DAO dao) throws Exception {
		boolean running = true;
		do {
			
			switch (view.doMenu()) {
				case EXIT:					
					running = this.doExitMainMenu(view, dao);
					break;		
				case ADD_MEMBER: 					
					this.doAddMember(view);
					break;
				case MANAGE_MEMBER: 									
					this.doManageMember(view);					
					break;
				case VERBOSE: 
					doVerbosePrint(view);
					break;
				case LITE: 
					doLitePrint(view);
					break;
				case ERROR: 
					view.error("Incorrect Option.");
					break;
				default:
					view.error("Selection error");
					break;
			}
		} while(running);
		return running;
	}
	
	/*start helpers
	 * I would rather have small methods that large ones. 
	 * Menu above are broke down into smaller methods to 
	 * make the code more understandable.
	 * */
	private void doLitePrint(ConsoleView view) {
		catalogue.getCatalogue()
			.forEach(member -> view.memberView.printLite(member));
		
	}
	
	private void doVerbosePrint(ConsoleView view) {
		catalogue.getCatalogue()
			.forEach(member -> view.memberView.printMember(member));
		
	}
	
	private void doAddMember(ConsoleView view) {
		Member m = new Member(view.memberView.addMember(), ++currentid);
		catalogue.addMember(m);
	}
	
	private boolean doExitMainMenu(ConsoleView view, DAO dao) throws Exception {
		view.bye();
		dao.saveCatalogue(catalogue);
		return false;
	}
	
	/*Manage Member Menu*/	
	public void ManageMember(ConsoleView view) {
		do {
			switch (view.memberView.doManageMember()) {
			case EXIT:
				selectedMemberID = NO_MEMBER;
				break;
			case EDIT:
				doMemberEdit(view);
				break;
			case DELETE:
				doDeleteMember(view);
				break;
			case ADD_BOAT:
				doAddBoat(view);
				break;
				
			case MANAGE_BOAT:
				doManageBoat(view);				
				break;
			case ERROR:
				view.error("Incorrect option.");
				break;
			default:
				break;
			}
			
		}while(selectedMemberID != NO_MEMBER);		
			
	}
	
/*Manage Member Helpers*/
	private void doManageBoat(ConsoleView view) {
		selectedBoatID = view.memberView.doSelectBoat(this.selectedMember());
		
		if (this.selectedBoat() != null) {
			manageBoat(view);					
		}
		else {
			view.error("Boat not found.");
		}
	}
	
	private void doAddBoat(ConsoleView view) {
		Boat boat = view.memberView.boatView.doAddBoat();
		this.selectedMember().addBoat(boat);
	}
	
	private void doDeleteMember(ConsoleView view) {
		catalogue.deleteMember(this.selectedMember());
		selectedMemberID = NO_MEMBER;
	}
	
	private void doMemberEdit(ConsoleView view) {
		Member member = view.memberView.editMember();
		catalogue.updateMember(this.selectedMember(), member);
	}
	
/*Manage Boat Menu*/
	public void manageBoat(ConsoleView view) {
		do {
			switch (view.memberView.boatView.doBoatMenu()) {
			case EXIT:
				selectedBoatID = NO_BOAT;
				break;
			case EDIT:
				doEditBoat(view);
				break;
			case DELETE:
				doDeleteBoat(view);
				break;
			case ERROR:
				view.error("Incorrect option");
				break;
			default:
				break;
			}
		} while (selectedBoatID != NO_BOAT);
		
	}
	
/*Manage Boat helpers*/
	public void doEditBoat(ConsoleView view) {
		Boat aBoat = view.memberView.boatView.doEditBoat();
		this.selectedMember().updateBoat(this.selectedBoat(), aBoat);
	} 
	
	public void doDeleteBoat(ConsoleView view) {
		this.selectedMember().deleteBoat(this.selectedBoat());
	}

/*Select Member and Boat helpers*/
	public Member selectedMember() {
		return catalogue.getCatalogue()
				.filter(m -> m.getMemberId() == selectedMemberID)
				.findFirst()
				.orElse(null);
	}
	
	public Boat selectedBoat() {
		return this.selectedMember()
				.getMemberBoats()
				.filter(b -> b.getMMSI().equals(selectedBoatID))
				.findFirst()
				.orElse(null);
	}
	
	
	private void doManageMember(ConsoleView view) {
		if(catalogue.isEmpty()) {
			view.catalogueIsEmpty();
		} else {

			view.printLite(catalogue.getCatalogue());
			
			selectedMemberID = view.doSelectMember();
			
			if (this.selectedMember()!= null) {
				view.memberView.printLite(this.selectedMember());
				ManageMember(view);
			} else {
				view.error("Member not Found");
			}
		}
	}
}
