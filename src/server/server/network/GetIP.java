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
		try {
			URL site = new URL("http://api.exip.org/?call=ip");
			BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));
			ip = in.readLine();
		} catch (Exception e) {
			try {
				URL site = new URL("http://icanhazip.com/");
				BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));
				ip = in.readLine();
			} catch (Exception ex) {
				PopupManager.GiveWarning("External IP adress could not be resolved");
				ip = "0.0.0.0";
			}
		}
		return ip;
	}
	
	// Get the local IP adress of the server
	public static String IntIP(boolean getName) {
		InetAddress address = null;
		String ip = null;
		String name = null;
		
		try {
			address = InetAddress.getLocalHost();
			ip = address.getHostAddress();
			name = address.getHostName();
		} catch(Exception ex) {
			PopupManager.GiveWarning("Local IP adress could not be resolved");
			ip = "0.0.0.0";
		}
		
		if (!getName) { return ip; } else { return name; }
	}
}
