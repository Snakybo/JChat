package server.file;

import java.io.FileWriter;
import java.io.IOException;

import server.Server;

public class FileWrite {
	public static void WriteHistory(String t, String s, String msg) {
		String time = "[" + t + "] ";
		String sender = s + ": ";
		String file = Server.rootDir + "history" + Server.fileExt;

		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(time);
			fw.write(sender);
			fw.write(msg + "\n");
			fw.close();
		} catch (IOException e) { }
	}
	
	public static void WriteConfig() {
		String file = Server.rootDir + "config" + Server.fileExt;
		
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write("Port: " + Server.listenPort + "\n");
			fw.close();
		} catch(IOException e) { }
	}
}