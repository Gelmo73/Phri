package view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import components.WordTextField;
import components.WordPasswordField;
import controller.*;
import init.Application;
import resources.*;

public class LoginView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	WordTextField wtfUsername;
	WordPasswordField wtfPassword;
	public JButton btnSignIn, btnSignUp;
	JLabel lblPasswordForgot;
	FontAwesome fontAwesome = null;
	
	public LoginView() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		setTitle("Phri Login");
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		wtfUsername = new WordTextField("Usuario");
		getContentPane().add(wtfUsername);
		
		wtfPassword = new WordPasswordField("Contraseña");
		getContentPane().add(wtfPassword);
		
		btnSignIn = new JButton("Iniciar Sesión");
		getContentPane().add(btnSignIn);
		
		btnSignUp = new JButton("Crear Cuenta");
		getContentPane().add(btnSignUp);
		
		lblPasswordForgot = new JLabel("¿Olvidaste tu contraseña?");
		getContentPane().add(lblPasswordForgot);
		lblPasswordForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lbl = new JLabel();
		try {
			FontAwesome font = new FontAwesome(FontAwesome.RESOURCES_BOLD);
			lbl.setFont(font.getFont());
			lbl.setText(FontAwesome.HEART_ICON);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getContentPane().add(lbl);
		
		//Buttons events
		btnSignIn.addActionListener(Application.ACCESOR);
		btnSignUp.addActionListener(this);
	}
	
	public void access() {
		AppView app = new AppView();
		app.setVisible(true);
		this.dispose();
	}
	
	public boolean fieldsFilled() {
		if(!wtfUsername.hasText()) return false;
		if(!wtfPassword.hasText()) return false;
		return true;
	}
	
	public String getUsername() {
		return wtfUsername.getText();
	}
	
	public String getPassword() {
		return wtfPassword.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
