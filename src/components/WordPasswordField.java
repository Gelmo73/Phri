package components;

import javax.swing.JPasswordField;
import java.awt.event.*;

public class WordPasswordField extends JPasswordField{
	
	private static final long serialVersionUID = 1L;
	private String defaultText;
	private boolean defaultTextUsed;
	private char echoChar;
	
	public WordPasswordField(String defaultText) {
		this.defaultText = defaultText;
		this.setText(defaultText);
		this.defaultTextUsed = true;
		this.addKeyListener(new Adapter(this));
		this.echoChar = this.getEchoChar();
		this.setEchoChar((char)0);
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public String getText() {
		if (defaultTextUsed) return "";
		
		return super.getText();
	}
	
	public boolean isDefaultTextUsed() {
		return this.defaultTextUsed;
	}
	
	public boolean hasText() {
		if(this.getPassword().length == 0) return false;
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
		
		WordPasswordField textField;
		boolean isBackspaceTyped;
		boolean isDeleteTyped ;
		
		public Adapter(WordPasswordField wordPasswordField) {
			this.textField = wordPasswordField;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			isBackspaceTyped = KeyEvent.VK_BACK_SPACE == e.getKeyCode(); 
			isDeleteTyped = KeyEvent.VK_DELETE == e.getKeyCode();
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			
			// Default text is not visible
			if (textField.isDefaultTextUsed() && !(isBackspaceTyped || isDeleteTyped )) {
				textField.setText("");
				textField.setDefaultTextUsed(false);
				textField.setEchoChar(echoChar);
			} 
			else {
				// Default text is visible
				if (!textField.hasText()) {
					textField.setDefaultText();
					textField.setDefaultTextUsed(true);
					textField.setEchoChar((char)0);
				} 
			}
			
		}
	}
}

