package init;

import view.*;
import controller.UserAccessController;
import model.*;
public class Application {
	
	public static final UserAccessController ACCESOR = new UserAccessController();

	public static void main(String[] args) {
		
		AppView app = new AppView();
		LoginView login = new LoginView();
		ACCESOR.setLogin(login);
		ACCESOR.setApp(app);
		login.setVisible(true);

	}

}
