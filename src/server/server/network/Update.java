package server.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JOptionPane;

import server.Server;

public class Update {
	public static void RunUpdate() {
		// TODO
	}
	
	public static boolean CheckUpdate() {
		try {
			URL site = new URL("http://jchat.ted80.net/?type=SERVER_CHECK");
			BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));
			String info = in.readLine();
			String[] parts = info.split("&");
			
			int part0 = Integer.parseInt(parts[0]);
			String part1 = parts[1];
			String part2 = parts[2];
			
			if (part0 == 1) {
				String[] sVersion = Server.version.split(".");
				String[] nVersion = part1.split(".");
				String[] rVersion = part2.split(".");
				
				if (Integer.parseInt(sVersion[0]) < Integer.parseInt(rVersion[0]) || Integer.parseInt(sVersion[1]) < Integer.parseInt(rVersion[1]) || Integer.parseInt(sVersion[2]) < Integer.parseInt(rVersion[2])) {
					return true;
				}
				
				if (Integer.parseInt(sVersion[0]) < Integer.parseInt(nVersion[0]) || Integer.parseInt(sVersion[1]) < Integer.parseInt(nVersion[1]) || Integer.parseInt(sVersion[2]) < Integer.parseInt(nVersion[2])) {
					int ans = JOptionPane.showConfirmDialog(null, "Minor update found, update?", "Update found", JOptionPane.YES_NO_OPTION);
					if (ans == 0) return true;
					if (ans == 1) return false;
				}
				
			} else {
				if (part0 == 2) Server.CloseWithError("Could not connect with server\nReason: Master Server offline");
				if (part0 == 3) Server.CloseWithError("Master Server is in maintainace mode, please try again later");
				if (part0 == 0) Server.CloseWithError("Could not connect with server\nReason: Master Server offline");
			}
		} catch(Exception e) {
			Server.CloseWithError("Could not connect with server\nReason: Master Server offline");
		}
		return false;
	}
}