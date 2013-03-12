package server.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import server.Server;
import server.gui.GUIMain;

public class FileRead {
	public static void ReadHistory() {
		String file = Server.rootDir + "history" + Server.fileExt;
	
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.trim().indexOf('#') == 0)
					continue;
				GUIMain.jta.append(sCurrentLine + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
