package server.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import server.Server;

public class FileCreate {
	public static String[] files = {"history", "config", "users", "ops"};
	private static String defText = "# JChat Server File\n# Copyright Ted80 and Snakybo\n#";
	
	public static Boolean Check() {
		// Folder
		File folder = new File(Server.rootDir);
		if (!folder.exists()) return false;
		
		// Files
		for (int i = 0; i < files.length; i++) {
			File file = new File(Server.rootDir + files[i]);
			if (!file.exists()) return false;
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
			File file = new File(Server.rootDir);
			if (!file.mkdir()) return false;
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	// Create a file
	private static boolean CreateFile(String f) {
		try {
			File file = new File(Server.rootDir + f);
			if (file.createNewFile()) {
				FileWriter fWriter = new FileWriter(file);
				BufferedWriter bWriter = new BufferedWriter(fWriter);
				bWriter.write(defText);
				bWriter.newLine();
				bWriter.flush();
				bWriter.close();
				return true;
			} else{
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}
}
