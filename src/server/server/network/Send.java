package server.network;

import server.JServer;
import server.JServerHelp;
import server.database.DataServerPing;
import server.file.FileClear;
import server.file.FileWrite;
import server.gui.GUI;
import server.network.user.User;

public class Send {
	private static String[][] commands = {
		{"CMD_CLEAN", "c", "cls", "clear", "clean"},
		{"CMD_KICK", "kick"},
		{"CMD_BAN", "ban"},
		{"CMD_BANGLOB", "banip"},
		{"CMD_UNBANGLOB", "unbanip"},
		{"CMD_UNBAN", "unban"},
		{"CMD_UPDATE", "update", "u"},
		{"CMD_PING", "ping"},
		{"CMD_HELP", "help", "h"},
		{"CMD_ADDOP", "op"},
		{"CMD_DEOP", "deop"},
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
		if (cmd.contains(" ")) {
			String cmdPar[] = cmd.split(" ");		
			for(int i = 0; i < commands.length; i++) {
				for(int j = 1; j < commands[i].length; j++) {
					if(cmdPar[0].equalsIgnoreCase(commands[i][j])) {
						runCommandWithPar(commands[i][0], cmdPar[1]);
						com = true;
					}
				}
			}
		} else {
			for(int i = 0; i < commands.length; i++) {
				for(int j = 1; j < commands[i].length; j++) {
					if(cmd.equalsIgnoreCase(commands[i][j])) {
						runCommand(commands[i][0]);
						com = true;
					}
				}
			}
		}
		
		if (!com) GUI.Append("No such command /" + cmd);
	}
	
	public static void runCommand(String cmd) {
		if (!JServer.debug) if (cmd.equals("CMD_CLEAN")) FileClear.clearHistory();
		if (cmd.equals("CMD_UPDATE")) Update.forceUpdate();
		if (cmd.equals("CMD_PING")) new DataServerPing();
		if (cmd.equals("CMD_HELP")) new JServerHelp();
	}
	
	public static void runCommandWithPar(String cmd, String par) {
		if (cmd.equals("CMD_KICK")) User.kick();
		if (cmd.equals("CMD_BAN")) User.ban();
		if (cmd.equals("CMD_UNBAN")) User.unban();
		if (cmd.equals("CMD_BANGLOB")) User.banglob();
		if (cmd.equals("CMD_UNBANGLOB")) User.unbanglob();
		if (cmd.equals("CMD_OP")) User.op();
		if (cmd.equals("CMD_DEOP")) User.deop();
	}
	
	private static void sendMessage(String msg) {
		GUI.Append("Server: " + msg);
		if (!JServer.debug) {
			FileWrite.WriteHistory(JServer.getTime(), "Server", msg);
		}
	}
}
