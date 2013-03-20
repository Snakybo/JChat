package client.network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class NetworkPing extends Network
{
	private int pingsec = 0;
	private Timer ping = null;
	
	public int PingServer(String server, int port)
	{
		pingsec = 1;
		ping = new Timer(1, new ActionListener()  {
            public void actionPerformed(ActionEvent e)  {
            	pingsec++;
            	if(pingsec > 999){ ping.stop(); }
            }
        });  
		ping.start();
		boolean connection = pingToServer(server, port);
		ping.stop();
		if(connection == false || pingsec > 999) { pingsec = 999; }
		return pingsec;
	}
}
