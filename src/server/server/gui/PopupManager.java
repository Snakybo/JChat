package server.gui;

import javax.swing.JOptionPane;

public class PopupManager {
	// Close application with error
	public static void CloseWithError(String err) {
		JOptionPane.showMessageDialog(null, err, "Server Error", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	
	// Close application with message
	public static void CloseWithMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		System.exit(0);
	}
	
	// Continue the application with warning
	public static void GiveWarning(String war) {
		JOptionPane.showMessageDialog(null, war, "Server Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	// Ask for close
	public static int AskClose(String que, String queT) {
		int pane = JOptionPane.showConfirmDialog (null, que, queT, JOptionPane.YES_NO_OPTION);
		
		if (pane == JOptionPane.YES_OPTION) {
			return 0;
		} else {
			return 1;
		}
	}
	
	// Input dialog
	public static String ShowInput(String inp, String inpT) {
		String s = (String)JOptionPane.showInputDialog(null, inp, inpT, JOptionPane.PLAIN_MESSAGE);
		if (s == null || s.length() <= 0) {
			GiveWarning("Server name invalid!");
			ShowInput(inp, inpT);
		}
		return s;
	}
}
