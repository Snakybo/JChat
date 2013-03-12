package server.filehandler;

import java.io.File;
import java.io.IOException;

import server.Server;
import server.gui.GUIMain;

public class FileCreate {
	public FileCreate() {
		GUIMain.jta.append("Checking if needed files exist..\n");
		GUIMain.jta.append("Root: " + Server.rootDir + "\n");
		
		// Directory
		try {
			String rootDir = Server.rootDir;
			if (new File(rootDir).mkdir()) {
				GUIMain.jta.append("    - server/ directory made.\n");
			} else {
				GUIMain.jta.append("    - server/ directory exists.\n");
			}
		} catch(Exception e) { }
		
		// Chat history
		try {
			File fileHistory = new File(Server.rootDir + "history" + Server.fileExt);
			if (fileHistory.createNewFile()) {
				GUIMain.jta.append("    - history" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - history" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
		
		// Users
		try {
			File fileUsers = new File(Server.rootDir + "users" + Server.fileExt);
			if (fileUsers.createNewFile()) {
				GUIMain.jta.append("    - users" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - users" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
		
		// OPs
		try {
			File fileOP = new File(Server.rootDir + "ops" + Server.fileExt);
			if (fileOP.createNewFile()) {
				GUIMain.jta.append("    - ops" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - ops" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
		
		// Settings
		try {
			File fileSettings = new File(Server.rootDir + "settings" + Server.fileExt);
			if (fileSettings.createNewFile()) {
				GUIMain.jta.append("    - settings" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - settings" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
	}
}
