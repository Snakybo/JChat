package client.network;

public class NetworkCheck extends Network
{
	public void sendCheck()
	{
		String info = "";
		info = "check#null#null#null";
		sendInfoToServer(info);
	}
}
