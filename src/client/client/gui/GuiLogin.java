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
import client.network.NetworkPing;

public class GuiLogin extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public JLabel texttitle, textname, textpass, textserver, textwarning, textserverlist;
	public JTextField loginname, loginserver;
	public JPasswordField loginpass;
	public JButton loginbutton, registerbutton;
	public JTextArea serverfield1, serverfield2, serverfield3, serverfield4;
	
	private NetworkPing ping = new NetworkPing();
	private DataClientServerlist serverlist = new DataClientServerlist();

	public GuiLogin()
	{
		setLayout(null); 
	}
	
	public void guiCreate(int width, int height)
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
		serverfield1 = new JTextArea("");
		serverfield2 = new JTextArea("");
		serverfield3 = new JTextArea("");
		serverfield4 = new JTextArea("");
		serverfield1.setEditable(false);
		serverfield2.setEditable(false);
		serverfield3.setEditable(false);
		serverfield4.setEditable(false);
		textserverlist = new JLabel("Server list", JLabel.CENTER);
		loginname.requestFocusInWindow();
		
		texttitle.setBounds((width / 2) - 260, (height / 2) - 135, 200, 20); 
		textname.setBounds((width / 2) - 290, (height / 2) - 75, 100, 20); 
		textpass.setBounds((width / 2) - 290, (height / 2) - 40, 100, 20); 
		textserver.setBounds((width / 2) - 280, (height / 2) - 5, 100, 20); 
		loginname.setBounds((width / 2) - 200, (height / 2) - 75, 140, 20); 
		loginpass.setBounds((width / 2) - 200, (height / 2) - 40, 140, 20); 
		loginserver.setBounds((width / 2) - 200, (height / 2) - 5, 140, 20); 
		loginbutton.setBounds((width / 2) - 260, (height / 2) + 65, 90, 20); 
		registerbutton.setBounds((width / 2) - 160, (height / 2) + 65, 90, 20); 
		textwarning.setBounds((width / 2) - 265, (height / 2) + 30, 200, 20); 
		
		serverfield1.setBounds((width / 2) + 10, (height / 2) - 205, 120, 375); 
		serverfield2.setBounds((width / 2) + 130, (height / 2) - 205, 120, 375); 
		serverfield3.setBounds((width / 2) + 250, (height / 2) - 205, 50, 375); 
		serverfield4.setBounds((width / 2) + 300, (height / 2) - 205, 30, 375); 
		textserverlist.setBounds((width / 2) + 120, (height / 2) - 230, 100, 20); 	
		
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
		add(serverfield1);
		add(serverfield2);
		add(serverfield3);
		add(serverfield4);
		add(textserverlist);
		
		serverlist();
	}
	

	public void guiDestroy()
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
		remove(serverfield1);
		remove(serverfield2);
		remove(serverfield3);
		remove(serverfield4);
		remove(textserverlist);
		repaint();
	}
	
	public void serverlist()
	{
		serverfield1.setText("");
		serverfield1.append("server name" + "\n");
		serverfield2.append("ip + port" + "\n");
		serverfield3.append("users" + "\n");
		serverfield4.append("ping" + "\n");

		Thread serverlistthread = new Thread(this);
		serverlistthread.start();
	}
	
	public void run()
	{
		String[][] list = serverlist.GetServerList();
		for(int i = 0; i < list.length; i++)
		{
			if(list[i][1] != null)
			{
				String users = list[i][2].replaceAll(":", "/");
				String[] serverpath = list[i][1].split(":");
				int serverping = ping.PingServer(serverpath[0], Integer.parseInt(serverpath[1]));
				serverfield1.append(list[i][0] + "\n");
				serverfield2.append(list[i][1] + "\n"); 
				serverfield3.append(users + "\n");
				serverfield4.append(serverping + "\n");
			}
		}
	}
}
