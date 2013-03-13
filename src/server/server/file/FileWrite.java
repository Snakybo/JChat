package server.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import server.Server;

public class FileWrite {
	public void WriteHistory(String t, String s, String msg) {		
		if (!Server.debug) {
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
}
