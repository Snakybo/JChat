package server.network;

import server.JServerHelp;
import server.database.DataServerPing;
import server.file.FileClear;
import server.gui.GUI;

public class Send {
	private static String[][] commands = {
		{"CMD_CLEAR", "c", "cls", "clear"},
		{"CMD_KICK", "kick"},
		{"CMD_BAN", "ban"},
		{"CMD_UNBAN", "unban"},
		{"CMD_UPDATE", "update", "u"},
		{"CMD_PING", "ping"},
		{"CMC_HELP", "help", "h"},
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
		if (!com) GUI.Append("No such command /" + cmd);
	}
	
	private static void runCommand(String cmd) {
		if (cmd == "CMD_CLEAR") FileClear.clearHistory();
		if (cmd == "CMD_KICK") User.kick();
		if (cmd == "CMD_BAN") User.ban();
		if (cmd == "CMD_UNBAN") User.unban();
		if (cmd == "CMD_UPDATE") Update.forceUpdate();
		if (cmd == "CMD_PING") new DataServerPing();
		if (cmd == "CMD_HELP") new JServerHelp();
	}
	
	private static void sendMessage(String msg) {
		GUI.Append("Server: " + msg);
	}
}
