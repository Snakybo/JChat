package server.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import server.JServer;

public class FileRead {
	public static void Read() {
		if (!JServer.debug) {
			ReadFile("history");
		}
	}
	
	public static void ReadFile(String f) {
		String file = JServer.rootDir + f;
		String cLine;
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {

			while ((cLine = bReader.readLine()) != null) {
				if (cLine.trim().indexOf('#') == 0)	continue;
			}
		} catch(IOException e) { }
	}
}
