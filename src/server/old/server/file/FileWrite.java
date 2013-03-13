package old.server.file;

import java.io.FileWriter;
import java.io.IOException;

import old.server.Server;
import old.server.gui.GUIMain;


public class FileWrite {
	public static void WriteHistory(String t, String s, String msg) {
		String time = "[" + t + "] ";
		String sender = s + ": ";
		
		if (Server.debug == false) {
			String file = Server.rootDir + "history" + Server.fileExt;
	
			try {
				FileWriter fw = new FileWriter(file, true);
				fw.write(time);
				fw.write(sender);
				fw.write(msg + "\n");
				fw.close();
			} catch (IOException e) { }
		}
		
		GUIMain.jta.append(time + sender + msg + "\n");
	}
	
	public static void WriteConfig() {
		if (Server.debug == false) {
			String file = Server.rootDir + "config" + Server.fileExt;
			
			try {
				FileClear.ClearConfig();
				FileWriter fw = new FileWriter(file, true);
				fw.write("Port: " + Server.listenPort + "\n");
				fw.write("Max Connections: " + Server.maxConnections + "\n");
				fw.close();
			} catch(IOException e) { }
		}
	}
}