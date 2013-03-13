package server.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import server.Server;

public class FileClear {
	private static String defaultText = "# JChat Server File\n# Copyright Ted80, Snakybo 2013\n\n";
	
	public static void ClearHistory() {
		try {
			File fileHistory = new File(Server.rootDir + "history" + Server.fileExt);
			FileWriter fstream = new FileWriter(fileHistory);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(defaultText);
			out.close();
			FileWrite.WriteHistory(Server.getTime(), "Server", "- Cleared chat history -");
		} catch(IOException e) { }
	}
}
