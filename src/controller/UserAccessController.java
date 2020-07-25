package controller;

import java.awt.event.*;

import javax.swing.JOptionPane;

import view.LoginView;
import view.AppView;
import model.User;
import model.UserModel;

public class UserAccessController implements ActionListener{
	
	LoginView login;
	AppView app;
	User user;
	
	public void setLogin(LoginView login) {
		this.login = login;
	}

	public void setApp(AppView app) {
		this.app = app;		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login.btnSignIn) accessing();
		else if (e.getSource() == app.getSignOutButton());
	}
	
	public void accessing() {
		
		if (!login.fieldsFilled()) {
			JOptionPane.showMessageDialog(null, "Campos vacios");
			return;
		}
		
		String username = login.getUsername();
		String password = login.getPassword();
		user = UserModel.getUserByUsername(username);
					
		if (user == null) {
			JOptionPane.showMessageDialog(null, "Usuario no existe");
			return;
		}
		
		if (!(user.getPassword().equals(password))) {
			JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
			return;
		}
		
		User.currentUser = user;
		this.signIn();
	}
	
	public void signIn() {
		app.setVisible(true);
		login.dispose();
	}
	
	public void signOut() {
		login.setVisible(true);
		app.dispose();
	}

}
