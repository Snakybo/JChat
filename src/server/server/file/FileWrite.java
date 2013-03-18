package server.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import jexxus.common.Connection;

import server.JServer;

public class FileWrite {
	public static void WriteHistory(String t, Connection s, String msg) {		
		if (!JServer.debug) {
			try {
				String time = "[" + t + "] " ;
				String sender = s + ": ";
				String file = FileCreate.files[0];
				
				FileWriter fWriter = new FileWriter(file, true);
				BufferedWriter bWriter = new BufferedWriter(fWriter);
				
				bWriter.write(time + sender + msg);
				bWriter.newLine();
				bWriter.flush();
				bWriter.close();
			} catch(IOException e) { }
		}
	}
	
	public static boolean WriteConfig() {
		if (!JServer.debug) {
			try {
				String file = JServer.rootDir + "config";
				String[] settings = {
						"Port: " + JServer.serverPort,
						"Server Name: " + JServer.serverName,
						};
				
				FileClear.clearConfig();
				FileWriter fWriter = new FileWriter(file, true);
				BufferedWriter bWriter = new BufferedWriter(fWriter);
				for (int i = 0; i < settings.length; i++) {
					bWriter.write(settings[i]);
					bWriter.newLine();
				}
				bWriter.flush();
				bWriter.close();
			} catch(IOException e) { 
				return false;
			}
		}
		return true;
	}
}