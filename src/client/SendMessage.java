
public class SendMessage extends Send
{
	public SendMessage()
	{
		
	}
	
	public void SendClientMessage(String name, String pass, String message, String server, int port)
	{
		//send to server
		String info = "";
		info = name + "#" + "pass" + "#" + message;
		sendInfoToServer(info, server, port);
		
		//display on client
	}
}
