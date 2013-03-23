package server.network;

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
		return "null";
	}
	
	public String getUsers() {
		return "null";
	}
	
	public String getCommand() {
		return "null";
	}
}
