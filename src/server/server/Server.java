package server;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import server.file.FileCreate;
import server.file.FileRead;
import server.gui.GUI;
import server.network.Update;

public class Server {
	public static Boolean debug = false;
	
	public static final String version = "0.40";
	public static final String rootDir = getRoot() + "\\server\\";
	
	public static int serverPort = 1337;
	public static int numThreads = 20;
	
	public static void main(String[] args) {
		// Get and handle Command line arguments
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("debug")) debug = true;
			}
		}
		
		// Check for updates
		if (Update.CheckUpdate()) Update.RunUpdate();
		
		// Create main GUI
		new GUI();
		
		// Handle files
		if (!debug) {
			if (!FileCreate.Check()) {
				if (!FileCreate.Create()) CloseWithError("Server could not create files.");
			} else {
				FileRead.Read();
			}
		}
		
		// Create server threads
		Threads.Create();
//		
		// Start listening for messages
//		Listen.Start();
	}
	
	// Returns the root directory of the JAR file
	private static String getRoot() {
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		return path;
	}
	
	// Returns the current system time
	public static String getTime() {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	return sdf.format(cal.getTime());
	}
	
	// Close application with error
	public static void CloseWithError(String err) {
		JOptionPane.showMessageDialog(null, err);
		System.exit(0);
	}
}