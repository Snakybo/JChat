package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import client.gui.*;

public class Client
{   
	private Timer clienttick;
	private int screenwidth = 803;
	private int screenheight = 600;

    public Gui gui;

    public static int version = 100;
    public static int ClientID = 1;
    public static String ClientName = "client_name";
    public static String ClientPass = "client_pass";
    public static String ServerIP = "localhost";
    public static int ServerPort = 1337;
    public static String Database = "jchat.ted80.net";
 
    public Client()
    {
		gui = new Gui(screenwidth, screenheight, version);
		gui.guiCreate(1);

		clienttick = new Timer(1000, new ActionListener()  
		{
            public void actionPerformed(ActionEvent e)  
            {
            	tick();
            }
        });  
		clienttick.start();
    }
    
    public void tick()
    {
    	
    }
    
    public static void main(String args[]) 
    {
    	new Client();
    }
}