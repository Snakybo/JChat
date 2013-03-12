package server.filehandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import server.Server;

public class FileWrite {
	public static void initFiles() {
		String[] files = {"history", "users", "ops", "config"};
		
		for (int i = 0; i < files.length; i++) {
			try {
				FileWriter file = new FileWriter(files[i] + Server.fileExt);
				BufferedWriter fileWrite = new BufferedWriter(file);
				fileWrite.write("test");
				fileWrite.close();
				System.out.println(fileWrite);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Test");
	}
}