package client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import client.Client;
import client.database.DataClientLogin;
//import client.database.DataClientServerlist;

public class Gui extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private int w;
	private int h;
	
	private GuiChat chat = new GuiChat();
	private GuiLogin login = new GuiLogin();
	private DataClientLogin databaselogin = new DataClientLogin();
	
	public Gui(int width, int height, int version)
	{
		w = width;
		h = height;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(w, h);
		setLocationRelativeTo(null);
		setTitle("JChat-Client V" + version);
		setResizable(false);	
	}
	
	public void guiCreate(int id)
	{
		if(id == 1){ add(login); login.guiChatCreate(w, h); addbuttonactions(1); }
		if(id == 2){}
		if(id == 3){ add(chat); chat.guiChatCreate(w, h); }
		setVisible(true);
	}
	
	public void guiDelete(int id)
	{
		if(id == 1){ remove(login); login.guiChatDestroy(); }
		if(id == 2){}
		if(id == 3){ remove(chat); chat.guiChatDestroy(); }
		setVisible(false);
	}
	
	public void addbuttonactions(int id)
	{
		if(id == 1)
		{
			login.loginbutton.addActionListener(new ActionListener() 
			{
	            public void actionPerformed(ActionEvent e) 
	            {
	            	int trylogin = databaselogin.Login(login.loginname.getText(), new String(login.loginpass.getPassword()));
	            	if(trylogin == 1) 
	            	{
		            	String[] serverpath = login.loginserver.getText().split(":");
		            	if(serverpath[0] == null && serverpath[1] == null)
		            	{
		            		login.textwarning.setText("Please enter a server");
		            	}
		            	else
		            	{
		                	Client.ServerIP = serverpath[0];
		                	Client.ServerPort = Integer.parseInt(serverpath[1]);
		                	Client.ClientName = login.loginname.getText();
		                	Client.ClientNick = login.loginname.getText();
		                	Client.ClientPass = new String(login.loginpass.getPassword());
		                	guiDelete(1);
		                	guiCreate(3); 
		            	}
	            	}
	            	if(trylogin == 2)
	            	{
	            		login.textwarning.setText("Username not found!");
	            	}
	            	if(trylogin == 3)
	            	{
	            		login.textwarning.setText("Name and pass don't match!");
	            	}
	            }
			});	
		}
	}
}
