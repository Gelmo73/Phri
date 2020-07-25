package components;

import java.awt.*;
import javax.swing.*;

public class PanelBlock extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel primaryText;
	private JLabel secondaryText;
	private JPanel textPanel; 
	private JPanel buttonPanel;
	

	public PanelBlock(String primaryText, String secondaryText) {
		this.primaryText = new JLabel(primaryText);
		this.secondaryText = new JLabel(secondaryText);
		initialize();
	}
	
	void initialize() {

		primaryText.setFont(new Font("Tahoma", Font.BOLD, 14));
		secondaryText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.add(primaryText);
		textPanel.add(secondaryText);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(5, 5, 5));
		
		this.setLayout(new FlowLayout(5, 5, 5));
		this.add(textPanel);
		this.add(buttonPanel);
		
	}
	
	public JPanel getButtonPanel() {
		return this.buttonPanel;
	}

}
