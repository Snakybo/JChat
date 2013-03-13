package old.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import old.server.file.FileCreate;
import old.server.file.FileRead;
import old.server.gui.GUIMain;
import old.server.gui.GUISettings;
import old.server.network.receive.Listen;


public class Server extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final String version = "0.37";
	public static final String rootDir =  getRoot() + "\\server\\";
	public static final String fileExt = ".jc";
	public static Boolean debug = false;
	
	public static int listenPort = 1337;
	public static int maxConnections = 10;
	
	private Timer servertick;
	
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("debug")) debug = true;
		}
		
		new Server();
    }
	
	public void tick() { }
	
	public Server() {
		new GUIMain();
		
		new FileCreate();
		if (debug == false) FileRead.ReadConfig();
		new Listen();
		
		
		servertick = new Timer(1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	tick();
	        }
        });  
		servertick.start();
	}
	
	public static String getRoot() {
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		
		return path;
	}
	
	public static String getTime() {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	
    	return sdf.format(cal.getTime());
	}
	
	public static void CloseServer(Boolean ext) {
		if (GUISettings.portOK && GUISettings.maxConnectionsOK || ext == true) {
			JOptionPane.showMessageDialog(null, "Settings saved, server closing..");
			System.exit(0);
		}
	}
}