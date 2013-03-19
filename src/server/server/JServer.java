package server;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import server.database.DataServerServerlist;
import server.file.FileCreate;
import server.file.FileRead;
import server.file.FileWrite;
import server.gui.GUI;
import server.gui.PopupManager;
import server.network.GetIP;
import server.network.Listen;
import server.network.UpdateStatus;

public class JServer {
	public static boolean debug = false;
	public static boolean offline = false;
	
	public static final String version = "1.0";
	public static final String rootDir = getRoot() + "\\server\\";
	
	public static int serverPort = 1337;
	public static String serverIP = GetIP.ExtIP();
	public static String serverName = "Default Name";
    public static String database = "jchat.ted80.net";
    public static int serverMaxusers = 100;
    public static int serverUsers = 0;
    
    //private static boolean defName = false;
	
	public static void main(String[] args) {
		// Get and handle Command line arguments
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("debug")) debug = true;
				if (args[i].equals("offline")) offline = true;;
			}
		}

		// Create main GUI
		new GUI();
		GUI.Append("Starting server on port: " + serverPort);
		
		// Handle files
		if (!debug) {
			GUI.Append("Checking for server files..");
			if (!FileCreate.Check()) {
				GUI.Append("  - Files missing! Creating..");
				if (!FileCreate.Create()) PopupManager.CloseWithError("Server could not create files.");
				if (!FileWrite.WriteConfig()) PopupManager.CloseWithError("Could not write to files.");
				GUI.Append("  - Files Created!");
			} else {
				GUI.Append("  - Files found.");
				FileRead.Read();
				if (!FileRead.ReadConfig()) PopupManager.GiveWarning("Config file could not be read!");
			}
		} else {
			GUI.Append("Running in debug mode!");
		}
		
		if (serverName.equals("Default Name")) defName = true;
		
		// Start listening
		if (!offline) {
			//if (!defName) {
				GUI.Append("Attempting to start services..");
				new DataServerServerlist().UpdateServer();
				new UpdateStatus();
				new Listen();
			//} else { 
			//	PopupManager.GiveWarning("Server name can't be 'Default Name'");
			//	GUI.Append("Failed to start server");
			//}
		} else {
			GUI.Append("Running in offline mode!");
		}
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
}
