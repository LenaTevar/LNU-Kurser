
import controllers.DAO;
import controllers.Init;
import views.ConsoleView;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ConsoleView view = new ConsoleView();
		DAO persistence = new DAO();
		Init init = new Init(persistence);
		
		while(init.start(view, persistence));
	}

}
