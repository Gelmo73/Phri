package view.page;

import javax.swing.JInternalFrame;
import javax.swing.JRootPane;

public class Page extends JInternalFrame implements IPage {

	private static final long serialVersionUID = 1L;

	public void dropTitleBar() {
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
	    getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	    ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBorder(null);
	}
}
