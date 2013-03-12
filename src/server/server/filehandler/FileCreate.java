package server.filehandler;

import java.io.File;
import java.io.IOException;

import server.Server;

public class FileCreate {
	public FileCreate() {
		// Directory
		try {
			String rootDir = Server.rootDir;
			new File(rootDir).mkdir(); 
		} catch(Exception e) { }
		
		// Chat history
		try {
			File fileHistory = new File(Server.rootDir + "history" + Server.fileExt);
			fileHistory.createNewFile();
		} catch(IOException e) { }
		
		// Users
		try {
			File fileUsers = new File(Server.rootDir + "users" + Server.fileExt);
			fileUsers.createNewFile();
		} catch(IOException e) { }
		
		// OPs
		try {
			File fileOP = new File(Server.rootDir + "ops" + Server.fileExt);
			fileOP.createNewFile();
		} catch(IOException e) { }
	}
}
