package server.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import server.gui.PopupManager;

public class GetIP {
	// Get the server's IP adress
	public static String ExtIP() {
		String ip = null;
		String[] mirrors = {
			"http://jchat.ted80.net/?type=IP",
			"http://api.exip.org/?call=ip",
			"http://icanhazip.com/",
			"http://api.exip.org/?call=ip",
			"http://ifconfig.me/ip",
			"http://ip.appspot.com/",
		};
		
		for (int i = 0; i < mirrors.length; i++) {
			try {
				URL site = new URL(mirrors[i]);
				BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));
				ip = in.readLine();
			} catch (Exception e) { }
			if (ip != null) break;
		}
		
		if (ip == null) {
			PopupManager.GiveWarning("External IP adress could not be resolved");
			ip = "0.0.0.0";
		}
		
		return ip;
	}
	
	// Get the local IP adress of the server
	public static String IntIP() {
		InetAddress address = null;
		String ip = null;
		
		try {
			address = InetAddress.getLocalHost();
			ip = address.getHostAddress();
		} catch(Exception ex) {
			PopupManager.GiveWarning("Local IP adress could not be resolved");
			ip = "0.0.0.0";
		}
		
		return ip;
	}
}
