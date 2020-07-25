package resources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontAwesome {
	
	private Font font;
	private String resource;
	private int style;
	private float size;
	
	public FontAwesome(String resource) throws FontFormatException, IOException {
		this(resource, Font.PLAIN, 20f);
	}
	
	public FontAwesome(String resource, int style) throws FontFormatException, IOException {
		this(resource, style, 20f);
	}
	
	public FontAwesome(String resource, float size) throws FontFormatException, IOException {
		this(resource, Font.PLAIN, size);
	}
	
	public FontAwesome(String resource, int style, float size) throws FontFormatException, IOException {
		this.resource = resource;
		this.style = style;
		this.size = size;
		setFont(this.resource, this.style, this.size);
	}
	
	public Font getFont() {
		return font;
	}
	
	public void setFont(String resource, int style, float size) throws FontFormatException, IOException{
		InputStream in_stream = getClass().getResourceAsStream(resource);
		font = Font.createFont(Font.TRUETYPE_FONT, in_stream);
		font = font.deriveFont(style, size);
	}
	
	public void setResource(String resource) throws FontFormatException, IOException {
		this.resource = resource;
		setFont(this.resource, this.style, this.size);
	}
	
	public void setSize(float size) throws FontFormatException, IOException {
		this.size = size;
		setFont(this.resource, this.style, this.size);
	}
	
	public void setStyle(int style) throws FontFormatException, IOException {
		this.style = style;
		setFont(this.resource, this.style, this.size);
	}

	public static final String RESOURCES_BOLD = "/resources/Font Awesome 5 Free-Solid-900.otf";
	public static final String RESOURCES_REGULAR = "/resources/Font Awesome 5 Free-Regular-400.otf";
	public static final String RESOURCES_BRANDS = "/resources/Font Awesome 5 Brands-Regular-400.otf";
	
	//If some of these icons does not work on your text, you may have to change the resource
	public static final String HOME_ICON = "\uf015";
	public static final String CONFIG_ICON = "\uf013";
	public static final String CALENDAR_ICON = "\uf274";
	public static final String ADD_USER_ICON = "\uf234";
	public static final String COMMUNITY_ICON = "\uf0c0";
	public static final String USER_ICON = "\uf007";
	public static final String USER_CIRCLE_ICON = "\uf2bd";
	public static final String THUMB_UP_ICON = "\uf164";
	public static final String HEART_ICON = "\uf004";
	public static final String X_ICON = "\uf00d";
	public static final String PLUS_ICON = "\uf0fe";
	
	//Not allowed either Free-Regular-400 or Free-Bold-900
	public static final String SHARE_ICON = "\uf064";
	public static final String REPLY_ICON = "\uf112";
	public static final String SIGN_OUT_ICON = "\uf08b";
	public static final String SIGN_IN_ICON = "\uf090";
	public static final String LEVEL_UP_ICON = "\uf148";
	public static final String LEVEL_DOWN_ICON = "\uf149";
	public static final String HEART_O_ICON = "\uf08a";
		
}
