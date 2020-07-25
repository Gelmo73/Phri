package view;

import javax.swing.JPanel;

import components.LabelIcon;
import resources.*;
import javax.swing.*;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.BorderLayout;
import controller.MenuController;
import init.Application;
public class Menu extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	LabelIcon inicio;
	LabelIcon profile;
	LabelIcon community;
	LabelIcon events;
	LabelIcon settings;
	LabelIcon signOut;
	JPanel panel;
	MenuController controller;
	
	public Menu() {
		dropTitleBar();
		initialize();
	}
	
	void dropTitleBar() {
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
	    getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	    ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBorder(null);
	}
	
	void initialize() {
		
		controller = new MenuController(this);
		
		panel = new JPanel();
		inicio = new LabelIcon(FontAwesome.HOME_ICON, "Inicio");
		inicio.setHorizontalAlignment(SwingConstants.CENTER);
		profile = new LabelIcon(FontAwesome.USER_ICON, "Perfil");
		community = new LabelIcon(FontAwesome.COMMUNITY_ICON, "Comunidad");
		events = new LabelIcon(FontAwesome.CALENDAR_ICON, "Eventos");
		settings = new LabelIcon(FontAwesome.CONFIG_ICON, "Configuracion");
		signOut = new LabelIcon(FontAwesome.X_ICON, "Cerrar Sesion");
		
		try {
			FontAwesome font = new FontAwesome(FontAwesome.RESOURCES_BOLD);
			inicio.setFont(font.getFont());
			profile.setFont(font.getFont());
			community.setFont(font.getFont());
			events.setFont(font.getFont());
			settings.setFont(font.getFont());
			signOut.setFont(font.getFont());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(inicio);
		panel.add(profile);
		panel.add(community);
		panel.add(events);
		panel.add(settings);
		panel.add(signOut);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		setBig();
		
		inicio.addMouseListener(controller);
		profile.addMouseListener(controller);
		community.addMouseListener(controller);
		events.addMouseListener(controller);
		settings.addMouseListener(controller);
		signOut.addMouseListener(Application.ACCESOR);
		
	}
	
	public void setBig() {
		inicio.setExtendedText();
		profile.setExtendedText();
		community.setExtendedText();
		events.setExtendedText();
		settings.setExtendedText();
		signOut.setExtendedText();
		pack();
	}
	
	public void setSmall() {
		inicio.setMinimizedText();
		profile.setMinimizedText();
		community.setMinimizedText();
		events.setMinimizedText();
		settings.setMinimizedText();
		signOut.setMinimizedText();
		pack();
	}

	public LabelIcon getInicio() {
		return inicio;
	}

	public LabelIcon getProfile() {
		return profile;
	}

	public LabelIcon getCommunity() {
		return community;
	}

	public LabelIcon getEvents() {
		return events;
	}

	public LabelIcon getSettings() {
		return settings;
	}

	public LabelIcon getSignOut() {
		return signOut;
	}

}
