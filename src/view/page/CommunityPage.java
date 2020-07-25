package view.page;

import java.awt.*;

import javax.swing.*;

public class CommunityPage extends Page{
	
	private static final long serialVersionUID = 1L;
	JButton btnShare;

	public CommunityPage() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new FlowLayout(5, 5, 5));
		btnShare = new JButton("Community");
		this.add(btnShare);
	}

}
