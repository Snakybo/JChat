package server.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import server.JServer;

public class FileClear {
	public static void clearHistory() {
		try {
			File file = new File(JServer.rootDir + "history");
			FileWriter fWriter = new FileWriter(file);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write(FileCreate.defText);
			bWriter.newLine();
			bWriter.flush();
			bWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void clearConfig() {
		try {
			File file = new File(JServer.rootDir + "config");
			FileWriter fWriter = new FileWriter(file);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write(FileCreate.defText);
			bWriter.newLine();
			bWriter.flush();
			bWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
