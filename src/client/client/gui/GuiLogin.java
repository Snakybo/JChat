package client.gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.Client;
//import client.database.DataClientLogin;
import client.database.DataClientServerlist;
//import client.network.NetworkPing;

public class GuiLogin extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public JLabel texttitle, textname, textpass, textserver, textwarning, textserverlist;
	public JTextField loginname, loginserver;
	public JPasswordField loginpass;
	public JButton loginbutton, registerbutton;
	public JTextArea serverlistfield;
	
	//private NetworkPing ping = new NetworkPing();
	private DataClientServerlist serverlist = new DataClientServerlist();
	//private DataClientLogin login = new DataClientLogin();

	public GuiLogin()
	{
		setLayout(null); 
	}
	
	public void guiChatCreate(int width, int height)
	{
		texttitle = new JLabel("JChat v" + Client.version + " - Login", JLabel.CENTER);
		textname = new JLabel("Username:", JLabel.CENTER);
		textpass = new JLabel("Password:", JLabel.CENTER);
		textserver = new JLabel("Server:", JLabel.CENTER);
		loginname = new JTextField(18);
		loginpass = new JPasswordField(18);
		loginserver = new JTextField(18);
		loginbutton = new JButton("login");
		registerbutton = new JButton("register");
		textwarning = new JLabel("", JLabel.CENTER);
		textwarning.setForeground(Color.red);
		serverlistfield = new JTextArea("Loading serverlist...");
		serverlistfield.setEditable(false);
		textserverlist = new JLabel("Server list", JLabel.CENTER);
		
		texttitle.setBounds((width / 2) - 230, (height / 2) - 140, 200, 20); 
		textname.setBounds((width / 2) - 260, (height / 2) - 90, 100, 20); 
		textpass.setBounds((width / 2) - 260, (height / 2) - 55, 100, 20); 
		textserver.setBounds((width / 2) - 250, (height / 2) - 20, 100, 20); 
		loginname.setBounds((width / 2) - 170, (height / 2) - 90, 140, 20); 
		loginpass.setBounds((width / 2) - 170, (height / 2) - 55, 140, 20); 
		loginserver.setBounds((width / 2) - 170, (height / 2) - 20, 140, 20); 
		loginbutton.setBounds((width / 2) - 230, (height / 2) + 50, 90, 20); 
		registerbutton.setBounds((width / 2) - 130, (height / 2) + 50, 90, 20); 
		textwarning.setBounds((width / 2) - 235, (height / 2) + 15, 200, 20); 
		serverlistfield.setBounds((width / 2) + 10, (height / 2) - 205, 270, 375); 
		textserverlist.setBounds((width / 2) + 100, (height / 2) - 230, 100, 20); 	
		
		add(texttitle);
		add(textname);
		add(textpass);
		add(textserver);
		add(loginname);
		add(loginpass);
		add(loginserver);
		add(loginbutton);
		add(registerbutton);
		add(textwarning);
		add(serverlistfield);
		add(textserverlist);
		
		serverlist();
	}
	

	public void guiChatDestroy()
	{
		remove(texttitle);
		remove(textname);
		remove(textpass);
		remove(textserver);
		remove(loginname);
		remove(loginpass);
		remove(loginserver);
		remove(loginbutton);
		remove(registerbutton);
		remove(textwarning);
		remove(serverlistfield);
		remove(textserverlist);
		repaint();
	}
	
	public void serverlist()
	{
		//PingServer(String server, int port)
		serverlistfield.setText("");
		String[][] list = serverlist.GetServerList();
		for(int i = 0; i < list.length; i++)
		{
			if(list[i][1] != null)
			{
				String users = list[i][2].replaceAll(":", "/");
				//String[] serverpath = list[i][1].split(":");
				//int serverping = ping.PingServer(serverpath[0], Integer.parseInt(serverpath[1]));
				serverlistfield.append(list[i][0] + "   " + list[i][1] + "   " + users + /*"   " + serverping +*/ "\n");
			}
		}
	}
	
	public void tryLogin()
	{
		
	}
}
