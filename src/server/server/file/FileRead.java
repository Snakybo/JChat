package server.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import server.Server;
import server.gui.GUIMain;

public class FileRead {
	public static void ReadHistory() {
		if (Server.debug == false) {
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
	
	public static void ReadConfig() {
		String file = Server.rootDir + "config" + Server.fileExt;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.trim().indexOf('#') == 0)
					continue;
				String[] parts = sCurrentLine.split(": ");
				int part2 = Integer.parseInt(parts[1]);
				
				if (parts[0] == "Port") {
					System.out.println("gedaan1");
					Server.listenPort = part2;
				}
				
				if (parts[0] == "Max Connections") {
					System.out.println("gedaan2");
					Server.maxConnections = part2;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
