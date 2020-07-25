package components;

import java.awt.Cursor;

import javax.swing.JLabel;

public class LabelIcon extends JLabel{

	private static final long serialVersionUID = 1L;
	String icon;
	String text;
	
	public LabelIcon(String icon) {
		this(icon, "");
	}
	
	public LabelIcon(String icon, String text) {
		this.icon = icon;
		this.text = text;
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setExtendedText();
	}
	
	public void setExtendedText() {
		this.setText(icon + " " + text);
	}
	
	public void setMinimizedText() {
		this.setText(icon);
	}
}
