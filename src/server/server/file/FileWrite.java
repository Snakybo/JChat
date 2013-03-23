package server.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import server.JServer;

public class FileWrite {
	public static void WriteHistory(String s, String msg) {		
		String file = JServer.rootDir + "history";
		
		try {
			FileWriter fWriter = new FileWriter(file, true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			
			bWriter.write("[" + JServer.getTime() + "] " + s + ": " + msg);
			bWriter.newLine();
			bWriter.flush();
			bWriter.close();
		} catch (IOException e) { }
	}
	
	public static void WriteConfig() {
		String file = JServer.rootDir + "config";
		String[] settings = {
				"Port: " + JServer.serverPort,
				"Server Name: " + JServer.serverName,
				"Max Users: " + JServer.serverMaxusers,
		};
		
		try {
			new FileClear("config");
			FileWriter fWriter = new FileWriter(file, true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			
			for (int i = 0; i < settings.length; i++) {
				bWriter.write(settings[i]);
				bWriter.newLine();
			}
			bWriter.flush();
			bWriter.close();
		} catch (IOException e) { }
	}
}