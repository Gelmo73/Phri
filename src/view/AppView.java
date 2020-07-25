package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.awt.*;
import javax.swing.*;

import components.LabelIcon;
import view.page.*;

public class AppView extends JFrame{
	
	private Menu menu;
	private static Page currentPage;
	private static JDesktopPane menuPane, pagePane;

	public AppView() {
		initialize();
		pack();
		this.setLocationRelativeTo(null);
	}

	private void initialize() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuPane = new JDesktopPane();
		getContentPane().add(menuPane, BorderLayout.WEST);
		menuPane.setLayout(new BorderLayout());
		
		pagePane = new JDesktopPane();
		getContentPane().add(pagePane, BorderLayout.CENTER);
		pagePane.setLayout(new BorderLayout());
		
		
		// MENU
		menu = new Menu();
		try {
			menu.setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		menuPane.add(menu, BorderLayout.CENTER);
		menu.setVisible(true);
		
		currentPage = new HomePage();
		currentPage.dropTitleBar();
		pagePane.add(currentPage, BorderLayout.CENTER);
		try {
			currentPage.setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		currentPage.setVisible(true);
	}
	
	public static void changePage(Page newPage) {
		if (newPage != currentPage) {
			pagePane.add(newPage);
			newPage.dropTitleBar();
			try {
				newPage.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			newPage.setVisible(true);
			currentPage.dispose();
			currentPage = newPage;
		}
	}
	
	public void getOut() {
		AppView app = new AppView();
		app.setVisible(true);
		this.dispose();
	}
	
	public LabelIcon getSignOutButton() {
		
		return menu.signOut;
		
	}

}
