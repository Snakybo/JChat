package server.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import server.Server;


public class Update {
	private static String updateServer = "http://jchat.ted80.net/";
	private static String[] serverInfo = new String[3];
	
	public static void RunUpdate() {
		// TODO
	}
	
	public static boolean CheckUpdate() {
		// Get versions from server
		try {
			URL target = new URL(updateServer + "?type=SERVER_CHECK");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(target.openStream()));
			System.out.println(Server.version);
			for (int i = 0; i < 3; i++) {
				serverInfo[i] = bReader.readLine();
				System.out.println(serverInfo[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Check for updates
		if (Integer.parseInt(serverInfo[0]) == 1) {
			float[] sVersion = Integer.parseInt(Server.version.split("."));
			String[] nVersion = serverInfo[1].split(".");
			String[] rVersion = serverInfo[1].split(".");
			
			System.out.println(sVersion.length);
			//System.out.println(sVersion[0] + " " + sVersion[1] + " " + sVersion[2]);
			
//			int sVersion0 = Integer.parseInt(sVersion[0]);
//			int sVersion1 = Integer.parseInt(sVersion[1]);
//			int sVersion2 = Integer.parseInt(sVersion[2]);
//			int nVersion0 = Integer.parseInt(nVersion[0]);
//			int nVersion1 = Integer.parseInt(nVersion[1]);
//			int nVersion2 = Integer.parseInt(nVersion[2]);
//			int rVersion0 = Integer.parseInt(rVersion[0]);
//			int rVersion1 = Integer.parseInt(rVersion[1]);
//			int rVersion2 = Integer.parseInt(rVersion[2]);
//			
//			if (sVersion0 < nVersion0 || sVersion1 < nVersion1 || sVersion2 < nVersion2) return true;
//			if (sVersion0 < rVersion0 || sVersion1 < rVersion1 || sVersion2 < rVersion2) return true;
		}
		return false;
	}
}