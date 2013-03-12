package server.filehandler;

import java.io.File;
import java.io.IOException;

import server.Server;

public class FileCreate {
	public FileCreate() {
		// Chat history
		try {
			File fileHistory = new File(Server.rootDir + "history");
			fileHistory.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// Users
		try {
			File fileUsers = new File(Server.rootDir + "users");
			fileUsers.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// OPs
		try {
			File fileOP = new File(Server.rootDir + "ops");
			fileOP.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
