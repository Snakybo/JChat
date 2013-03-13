package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.Timer;

import server.file.FileCreate;
import server.gui.GUIMain;
import server.network.receive.Listen;

public class Server extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final String version = "0.37";
	public static final String rootDir =  getRoot() + "\\server\\";
	public static final String fileExt = ".jc";
	public static final Boolean debug = false;
	public static int listenPort = 1337;
	

	private Timer servertick;
	
	public Server() {
		new GUIMain();
		
		new FileCreate();		
		new Listen();
		
		
		servertick = new Timer(1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	tick();
	        }
        });  
		servertick.start();
	}
	
	public static void main(String[] args) {
		new Server();
    }
	
	public void tick() {
		
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
}