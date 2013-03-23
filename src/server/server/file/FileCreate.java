package server.file;

import java.io.File;
import java.io.IOException;

import server.JServer;

public class FileCreate {
	public static String[] files = {"history", "config", "users", "ops"};
	
	public static Boolean Check() {
		// Folder
		File folder = new File(JServer.rootDir);
		if (!folder.exists()) {
			return false;	
		}
		
		// Files
		for (int i = 0; i < files.length; i++) {
			File file = new File(JServer.rootDir + files[i]);
			if (!file.exists()) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean Create() {
		if (!CreateFolder("server")) return false; 	// Root directory
		if (!CreateFile("history")) return false;	// History
		if (!CreateFile("config")) return false;	// Config
		if (!CreateFile("users")) return false;		// Users
		if (!CreateFile("ops")) return false;		// OPs
		
		if (!Check()) return false;
		return true;
	}
	
	// Create a folder
	private static boolean CreateFolder(String f) {
		try {
			File file = new File(JServer.rootDir);
			if (file.mkdir()) return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	// Create a file
	private static boolean CreateFile(String f) {
		try {
			File file = new File(JServer.rootDir + f);
			if (file.createNewFile())
				return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
