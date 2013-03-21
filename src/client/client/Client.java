package client;

import client.gui.*;

public class Client
{   
	private int screenwidth = 803;
	private int screenheight = 600;

    public Gui gui;

    public static int version = 100;
    public static int ClientID = 1;
    public static String ClientName = "client_name";
    public static String ClientNick = "client_nick";
    public static String ClientPass = "client_pass";
    public static String ServerIP = "localhost";
    public static int ServerPort = 1337;
    public static String Database = "jchat.ted80.net";
    public static boolean Connected = false;
 
    public Client()
    {
		gui = new Gui(screenwidth, screenheight, version);
		gui.guiCreate(1);
    }
    
    public static void main(String args[]) 
    {
    	new Client();
    }
}