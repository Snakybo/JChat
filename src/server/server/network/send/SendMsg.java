package server.network.send;

public class SendMsg {
	public SendMsg(String msg) {
		if (msg.length() > 0) {
			char cmd = msg.charAt(0);

			if (cmd == '/') {
				msg = msg.substring(1);
				System.out.println("command " + msg);
			} else {
				System.out.println("message " + msg);
			}
		}
	}
}
