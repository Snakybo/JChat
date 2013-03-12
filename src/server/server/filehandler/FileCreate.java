package server.filehandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import server.Server;
import server.gui.GUIMain;

public class FileCreate {
	public FileCreate() {
		String defaultText = "# JChat Server File\n# Copyright Ted80, Snakybo 2013";
		
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
				FileWriter fstream = new FileWriter(fileHistory);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write(defaultText);
				out.close();
				GUIMain.jta.append("    - history" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - history" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
		
		// Users
		try {
			File fileUsers = new File(Server.rootDir + "users" + Server.fileExt);
			if (fileUsers.createNewFile()) {
				FileWriter fstream = new FileWriter(fileUsers);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write(defaultText);
				out.close();
				GUIMain.jta.append("    - users" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - users" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
		
		// OPs
		try {
			File fileOP = new File(Server.rootDir + "ops" + Server.fileExt);
			if (fileOP.createNewFile()) {
				FileWriter fstream = new FileWriter(fileOP);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write(defaultText);
				out.close();
				GUIMain.jta.append("    - ops" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - ops" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
		
		// Config
		try {
			File fileConfig = new File(Server.rootDir + "config" + Server.fileExt);
			if (fileConfig.createNewFile()) {
				FileWriter fstream = new FileWriter(fileConfig);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write(defaultText);
				out.close();
				GUIMain.jta.append("    - config" + Server.fileExt + " made.\n");
			} else {
				GUIMain.jta.append("    - config" + Server.fileExt + " exists.\n");
			}
		} catch(IOException e) { }
	}
}
