package server.network;

import server.file.FileRead;
import jexxus.common.Connection;
import jexxus.common.Delivery;

public class SendClientInfo {
	public SendClientInfo(Connection from) {
		from.send(getHistory().getBytes(), Delivery.RELIABLE);
		from.send(getUsers().getBytes(), Delivery.RELIABLE);
		from.send(getCommand().getBytes(), Delivery.RELIABLE);
		from.send("end".getBytes(), Delivery.RELIABLE);
	}
	
	public String getHistory() {
		FileRead.ReadHistory();
		return FileRead.history;
	}
	
	public String getUsers() {
		return User.users;
	}
	
	public String getCommand() {
		return "null";
	}
}
