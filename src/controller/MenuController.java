package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import init.Application;
import view.AppView;
import view.Menu;
import view.page.*;

public class MenuController extends MouseAdapter{
	
	private Menu menu;
	
	
	public MenuController(Menu menu) {
		this.menu = menu;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
		if(e.getSource() == menu.getInicio()) AppView.changePage(new HomePage()); 
		else if(e.getSource() == menu.getProfile()) AppView.changePage(new ProfilePage()); 
		else if(e.getSource() == menu.getCommunity()) AppView.changePage(new CommunityPage()); 
		else if(e.getSource() == menu.getEvents()) AppView.changePage(new EventPage()); 
		else if(e.getSource() == menu.getSettings()) AppView.changePage(new SettingsPage()); 	}
}
