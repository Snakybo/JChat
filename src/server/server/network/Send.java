package server.network;

import server.JServer;
import server.gui.GUI;

public class Send {
	private static String[][] commands = {
		{"CMD_CLEAR", "c", "cls", "clear"},
		{"CMD_KICK", "kick"},
		{"CMD_BAN", "ban"},
		{"CMD_UNBAN", "unban"},
		{"CMD_UPDATE", "update", "u"},
		{"CMD_PING", "ping"},
	};
	
	public Send(String in) {
		if (in.charAt(0) == '/') {
			sendCommand(in);
		} else {
			sendMessage(in);
		}
	}
	
	private static void sendCommand(String cmd) {
		boolean com = false;
		cmd = cmd.substring(1);
		
		for(int i = 0; i < commands.length; i++) {
			for(int j = 1; j < commands[i].length; j++) {
				if(cmd.equals(commands[i][j])) {
					runCommand(commands[i][0]);
					com = true;
				}
			}
		}
		if (!com) GUI.Append("[" + JServer.getTime() + "] No such command /" + cmd);
	}
	
	private static void runCommand(String cmd) {
		System.out.println(cmd);
	}
	
	private static void sendMessage(String msg) {
		GUI.Append("[" + JServer.getTime() + "] Server: " + msg);
	}
}
