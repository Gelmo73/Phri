package view.page;

import java.awt.*;

import javax.swing.*;

public class ProfilePage extends Page{
	
	private static final long serialVersionUID = 1L;
	JButton btnShare;

	public ProfilePage() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new FlowLayout(5, 5, 5));
		btnShare = new JButton("Profile");
		this.add(btnShare);
	}

}
