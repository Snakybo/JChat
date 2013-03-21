package client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import client.Client;
import client.database.DataClientLogin;
//import client.database.DataClientServerlist;
import client.database.DataClientRegister;

public class Gui extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private int w;
	private int h;
	
	private GuiChat chat = new GuiChat();
	private GuiLogin login = new GuiLogin();
	private GuiRegister register = new GuiRegister();
	private DataClientLogin databaselogin = new DataClientLogin();
	private DataClientRegister databaseregister = new DataClientRegister();
	
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
		if(id == 1){ add(login); login.guiCreate(w, h); addbuttonactions(1); }
		if(id == 2){ add(register); register.guiCreate(w, h); addbuttonactions(2); }
		if(id == 3){ add(chat); chat.guiChatCreate(w, h); }
		setVisible(true);
	}
	
	public void guiDelete(int id)
	{
		if(id == 1){ remove(login); login.guiDestroy(); }
		if(id == 2){ remove(register); register.guiDestroy(); }
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
	            	String[] serverpath = login.loginserver.getText().split(":");
	            	if(serverpath.length == 1) { login.textwarning.setText("Please enter a server"); }
	            	else if(login.loginname.getText().length() == 0) { login.textwarning.setText("Please enter a username"); }
	            	else if(new String(login.loginpass.getPassword()).length() == 0) { login.textwarning.setText("Please enter a password"); }
	            	else
	            	{
		            	int trylogin = databaselogin.Login(login.loginname.getText(), new String(login.loginpass.getPassword()));
		            	if(trylogin == 1) 
		            	{
		                	Client.ServerIP = serverpath[0];
		                	Client.ServerPort = Integer.parseInt(serverpath[1]);
		                	Client.ClientName = login.loginname.getText();
		                	Client.ClientNick = login.loginname.getText();
		                	Client.ClientPass = new String(login.loginpass.getPassword());
		                	guiDelete(1);
		                	guiCreate(3); 
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
	            }
			});	
			login.registerbutton.addActionListener(new ActionListener() 
			{
	            public void actionPerformed(ActionEvent e) 
	            {
	            	guiDelete(1);
	            	guiCreate(2); 
	            }
			});	
		}
		if(id == 2)
		{
			register.registerbutton.addActionListener(new ActionListener() 
			{
	            public void actionPerformed(ActionEvent e) 
	            {
	            	String[] serverpath = register.registerserver.getText().split(":");
	            	if(serverpath.length == 1) { register.textwarning.setText("Please enter a server"); }
	            	else if(register.registername.getText().length() == 0) { register.textwarning.setText("Please enter a username"); }
	            	else if(new String(register.registerpass.getPassword()).length() == 0) { register.textwarning.setText("Please enter a password"); }
	            	else
	            	{
		            	int trylogin = databaseregister.Register(register.registername.getText(), new String(register.registerpass.getPassword()));
		            	if(trylogin == 1) 
		            	{
		                	Client.ServerIP = serverpath[0];
		                	Client.ServerPort = Integer.parseInt(serverpath[1]);
		                	Client.ClientName = register.registername.getText();
		                	Client.ClientNick = register.registername.getText();
		                	Client.ClientPass = new String(register.registerpass.getPassword());
		                	guiDelete(2);
		                	guiCreate(3); 
		            	}
		            	if(trylogin == 2)
		            	{
		            		register.textwarning.setText("Username already exists!");
		            	}
	            	}
	            }
			});	
			register.backbutton.addActionListener(new ActionListener() 
			{
	            public void actionPerformed(ActionEvent e) 
	            {
	            	guiDelete(2);
	            	guiCreate(1);
	            }
			});	
		}
	}
}
