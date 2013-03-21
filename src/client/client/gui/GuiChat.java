package client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.network.*;
import client.Client;

public class GuiChat extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public static String[] chat = new String[32];
	public static String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	
	private static JTextArea chatfield, userfield;
	private JButton chatSettings, chatLogout, chatSend;
	private JTextField chatnew;
	
	private NetworkMessage message = new NetworkMessage();
	private NetworkCommand command = new NetworkCommand();
	private NetworkCheck check = new NetworkCheck();
	private Timer checktimer;
	
	public GuiChat()
	{
		setLayout(null); 
	}
	
	public void guiChatCreate(int width, int height)
	{	
		chatfield = new JTextArea("");
		userfield = new JTextArea("");
		chatSettings = new JButton("Settings");
		chatLogout = new JButton("Logout");
		chatSend = new JButton("Send");
		chatnew = new JTextField(20);
		
		userfield.setBounds(width - 200, 10, 185, height - 110);
	  	chatSettings.setBounds(width - 105, height - 95, 90, 20); 
	  	chatLogout.setBounds(width - 200, height - 95, 90, 20); 
	  	chatSend.setBounds(width - 105, height - 70, 90, 20); 
	  	chatnew.setBounds(10, height - 70, width - 120, 20); 
		chatfield.setBounds(10, 10, width - 220, height - 85);
		chatfield.setEditable(false); 
		userfield.setEditable(false); 
		chatnew.requestFocusInWindow();
		
		checktimer = new Timer(2000, new ActionListener()  
		{
			public void actionPerformed(ActionEvent e)  
			{
				check.sendCheck();
			}
		});  
		checktimer.start();

		
	  	chatSend.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e)  {
            	PrepairMessage(chatnew.getText());
            	chatnew.setText("");
            	chatnew.requestFocusInWindow();
            }
		});
	  	
	  	chatnew.addKeyListener(new KeyAdapter() 
	  	{
            public void keyReleased(KeyEvent e)  { }
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) 
            {
            	if(e.getKeyCode() == 10)
            	{
            		PrepairMessage(chatnew.getText());
                	chatnew.setText("");
                	chatnew.requestFocusInWindow();
            	}
            }
        });
		
		add(chatSettings);
		add(chatLogout);
		add(chatSend);
		add(chatnew);
		add(userfield);
		add(chatfield);
		repaint();
	}
	
	public void guiChatDestroy()
	{		
		checktimer.stop();
		remove(userfield);
		remove(chatfield);
		remove(chatSettings);
		remove(chatLogout);
		remove(chatSend);
		remove(chatnew);
		repaint();
	}
	
	public void PrepairMessage(String info)
	{
		if(info.length() > 0)
		{
			char cmdcheck = info.charAt(0);
			if (cmdcheck == '/')
			{
				command.NewCommand(Client.ClientName, Client.ClientNick, info.substring(1));
			}
			else
			{
				message.SendClientMessage(Client.ClientName, Client.ClientNick, Client.ClientPass, info);
			}
		}
	}
	
	public static void DisplayMessage(String info)
	{
		for(int i = chat.length - 2; i > -1; i--)
		{
			chat[i + 1] = chat[i];
			if(i == 0) 
			{ 
				chat[i] = info; 
			}
		}		
		
		String newstring = "";
		for(int i = chat.length - 1; i > -1; i--)
		{
			if(chat[i] != null)
			{
				newstring += chat[i] + "\n";
			}	
			else
			{
				newstring += "" + "\n";
			}
		}
		
		chatfield.setText(newstring);
	}
	
	public static void DisplayTranslatedMessage(String info)
	{
		String newinfo = translate(info);
		DisplayMessage(newinfo);
	}
	
	public static String translate(String message)
	{
		for(int i = 0; i < translatechars.length; i++)
		{
			message = message.replaceAll(translatechars[i][0], translatechars[i][1]);
		}

		return message;
	}
}
