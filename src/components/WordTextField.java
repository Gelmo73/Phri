package components;

import javax.swing.JTextField;
import java.awt.event.*;

public class WordTextField extends JTextField{
	
	private static final long serialVersionUID = 1L;
	private String defaultText;
	private boolean defaultTextUsed;
	
	public WordTextField(String defaultText) {
		this.defaultText = defaultText;
		this.setText(defaultText);
		this.defaultTextUsed = true;
		this.addKeyListener(new Adapter(this));
	}
	

	@Override
	public String getText() {
		if (defaultTextUsed) return "";
		
		return super.getText();
	}
	
	public boolean isDefaultTextUsed() {
		return this.defaultTextUsed;
	}
	
	public boolean hasText() {
		if(this.getText().trim().equals("")) return false;
		return true;
	}
	
	public void setDefaultText() {
		this.setText(defaultText);
	}
	
	protected void setDefaultTextUsed(boolean status) {
		this.defaultTextUsed = status;
	}
	
	public void clear() {
		setDefaultText();
		setDefaultTextUsed(true);		
	}
	
	class Adapter extends KeyAdapter {
		
		WordTextField textField;
		boolean isBackspaceTyped;
		boolean isDeleteTyped ;
		
		public Adapter(WordTextField textField) {
			this.textField = textField;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			isBackspaceTyped = KeyEvent.VK_BACK_SPACE == e.getKeyCode(); 
			isDeleteTyped = KeyEvent.VK_DELETE == e.getKeyCode();
		}
		
		@Override
		public void keyTyped(KeyEvent e) {

			if (textField.isDefaultTextUsed() && !(isBackspaceTyped || isDeleteTyped )) {
				textField.setText("");
				textField.setDefaultTextUsed(false);
			} 
			else {
				
				if (!textField.hasText()) {
					textField.setDefaultText();
					textField.setDefaultTextUsed(true);
				} 
			}
			
		}
	}
}
