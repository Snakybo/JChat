package server.network.send;

import server.file.FileClear;
import server.gui.GUIMain;

public class SendMsg {
	private String[][] cmds = {
			{"cls", "clear"},
			{"exit", "stop"},
	};
	
	public SendMsg(String msg) {
		if (msg.length() > 0) {
			char cmd = msg.charAt(0);

			if (cmd == '/') {
				msg = msg.substring(1);
				Boolean valid = false;
				
				for (int i = 0; i < cmds.length; i++) {
					for (int a = 0; a < (cmds[i].length); a++) {
						System.out.println(msg);
						if (msg.equals(cmds[0][a])) { valid = true; FileClear.ClearHistory(); }
						//if (msg.equals(cmds[1][a])) { valid = true; Server.CloseServer(true); }
					}
				}
				
				if (valid == false) { GUIMain.jta.append("Unknown command\n"); }
			} else {
				System.out.println("message " + msg);
			}
		}
	}
}
