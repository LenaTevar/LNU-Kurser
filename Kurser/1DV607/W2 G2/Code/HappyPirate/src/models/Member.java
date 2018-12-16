package models;

import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Member")
@XmlType(propOrder = {"memberId", "firstName", "surname", "personId", "phone", "memberBoats"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Member {

	@XmlElement(name = "memberId")
	private int memberId;
	@XmlElement(name = "firstName")
	private String firstName;
	@XmlElement(name = "surname")
	private String surname; 
	@XmlElement(name = "personId")
	private String personId;	
	@XmlElement(name = "phone")
	private String phone;
	@XmlElement(name = "memberBoats")
	private List <Boat> memberBoats = new ArrayList <Boat>();

	public Member () {}
	public Member (String aName, String aSurname, String apersonId, String aPhone) {	
		
		firstName = aName;
		surname = aSurname;
		personId = apersonId;
		phone = aPhone;
	}
	
	public Member (Member aMember, int anMemberId) {
		this.Set(aMember);
		memberId = anMemberId;
	}

	/*Member Related*/
	public String getFirstName() {
		return firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public String getPersonId() {
		return personId;
	}
	
	public boolean boatsIsEmpty() {
		return memberBoats.isEmpty();
	}
	
	public Stream<Boat> getMemberBoats() {
		return memberBoats.stream();
	}
	
	/*This doesn't looks like teachers' answer
	 * ... it is... */
	public void Set(Member a_copy)
    {
		firstName = a_copy.firstName;
		surname = a_copy.surname;
		phone = a_copy.phone;
		personId= a_copy.personId;
		
    }
	
	/*Boat Related CRUD*/
	
	public void addBoat(Boat aBoat) {
		memberBoats.add(aBoat);
	}
	
	public Boat retrieveBoat(String boatId) {
		for (Boat boat : memberBoats) {
			if (boat.getMMSI() == boatId)
				return boat;
		}
		return null;
	}	
	
	public void updateBoat(Boat oldBoat, Boat currentBoat) {
		oldBoat.update(currentBoat);
	}
	
	public void deleteBoat(Boat boat) {
		memberBoats.remove(boat);
	}
	
	
	

}
