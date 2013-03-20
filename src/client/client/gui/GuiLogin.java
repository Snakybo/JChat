package client.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.Client;
import client.database.DataClientServerlist;
import client.network.NetworkPing;

public class GuiLogin extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private JLabel texttitle;//, textname, textpass, textserver;
	private NetworkPing ping = new NetworkPing();
	private DataClientServerlist serverlist = new DataClientServerlist();

	public GuiLogin()
	{
		setLayout(null); 
	}
	
	public void guiChatCreate(int width, int height)
	{
		texttitle = new JLabel("JChat v" + Client.version, JLabel.CENTER);
		
		texttitle.setBounds((width / 2) - 50, (height / 2) - 200, 100, 20); 

		add(texttitle);
		
		serverlist();
	}
	

	public void guiChatDestroy()
	{
		remove(texttitle);
		repaint();
	}
	
	public void serverlist()
	{
		//PingServer(String server, int port)
		String[][] list = serverlist.GetServerList();
		for(int i = 0; i < list.length; i++)
		{
			if(list[i][1] != null)
			{
				String[] serverpath = list[i][1].split(":");
				int serverping = ping.PingServer(serverpath[0], Integer.parseInt(serverpath[1]));
				if(serverping < 999) { System.out.println("name:" + list[i][0] + " ip:" + list[i][1] + " users:" + list[i][2] +  " ping:" + serverping); }
				else { System.out.println("name:" + list[i][0] + " ip:" + list[i][1] + " users:" + list[i][2] +  " ping:" + serverping); }
			}
		}
	}
	
	public void tryLogin()
	{
		
	}
}
