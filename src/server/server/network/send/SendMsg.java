package server.network.send;

import server.file.FileClear;
import server.gui.GUIMain;

public class SendMsg {
	private String[][] cmds = {
			{"cls", "clear"},
	};
	
	public SendMsg(String msg) {
		if (msg.length() > 0) {
			char cmd = msg.charAt(0);

			if (cmd == '/') {
				msg = msg.substring(1);
				Boolean valid = false;
				
				for (int i = 0; i < cmds.length; i++) {
					for (int a = 0; a < (cmds[i].length); a++) {
						if (msg.equals(cmds[0][a])) { valid = true; FileClear.ClearHistory(); }
					}
				}
				
				if (valid == false) { GUIMain.jta.append("Unknown command"); }
			} else {
				System.out.println("message " + msg);
			}
		}
	}
}
