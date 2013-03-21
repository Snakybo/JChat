package server.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import server.JServer;

public class FileClear {
	public FileClear(String s) {
		try {
			File file = new File(JServer.rootDir + s);
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
