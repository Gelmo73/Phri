package view.page;

import java.awt.Dimension;
import javax.swing.*;
import model.*;
import controller.*;
import components.PanelBlock;
import components.WordTextField;
import java.util.List;

public class HomePage extends Page{
	
	JPanel publicationPanel;
	JPanel phrisPanel;
	List<PanelBlock> phris;
	WordTextField wtfThinking;
	JButton btnShare;
	

	public HomePage() {
		dropTitleBar();
		initialize();
		loadPhris();
	}

	private void initialize() {
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		publicationPanel = new JPanel();
		publicationPanel.setLayout(new BoxLayout(publicationPanel, BoxLayout.Y_AXIS));
		
		wtfThinking = new WordTextField("¿Qué estás pensando?");
		publicationPanel.add(wtfThinking);
		
		btnShare = new JButton("Publicar");
		publicationPanel.add(btnShare);
		
		phrisPanel = new JPanel();
		phrisPanel.setLayout(new BoxLayout(phrisPanel, BoxLayout.Y_AXIS));
		
		publicationPanel.setPreferredSize(new Dimension(500, 50));
		// phrisPanel.setPreferredSize(new Dimension(500, 450));
		
		JScrollPane scroll = new JScrollPane(phrisPanel, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(500, 400));
		
		
		getContentPane().add(publicationPanel);
		getContentPane().add(scroll);
	}
	
	void loadPhris() {
		PhrisLoadList list = new PhrisLoadList();
		phris = list.getList();
		System.out.println(String.valueOf(phris.size()));
		phris.forEach(panel -> {
			this.phrisPanel.add(panel);
			phrisPanel.revalidate();
		});
			
	}

}
