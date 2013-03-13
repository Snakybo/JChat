package old.server.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import old.server.Server;


public class FileClear {
	private static String defaultText = "# JChat Server File\n# Copyright Ted80, Snakybo 2013\n#\n";
	
	public static void ClearHistory() {
		try {
			File file = new File(Server.rootDir + "history" + Server.fileExt);
			FileWriter fstream = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(defaultText);
			out.close();
			FileWrite.WriteHistory(Server.getTime(), "Server", "Cleared chat history");
		} catch(IOException e) { }
	}
	
	public static void ClearConfig() {
		try {
			File file = new File(Server.rootDir + "config" + Server.fileExt);
			FileWriter fstream = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(defaultText);
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
