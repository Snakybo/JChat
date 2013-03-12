package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

import client.gui.*;
 
public class Client extends JFrame
{   
	private static final long serialVersionUID = 1L;
	private Timer clienttick;
	private int screenwidth = 800;
	private int screenheight = 600;

    public Gui gui;

    public static String version = "0.01";
    public static int ClientID = 1;
    public static String ClientName = "";
    public static String ClientPass = "";
    public static String ServerIP = "";
    public static int ServerPort = 1;
 
    public Client()
    {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenwidth, screenheight);
		setLocationRelativeTo(null);
		setTitle("JChat V" + version);
		setResizable(false);
		setVisible(true);
		
		gui = new Gui(screenwidth, screenheight);
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