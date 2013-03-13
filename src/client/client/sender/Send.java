package client.sender;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Send 
{
	private static Socket socket;
	private OutputStream os;
	private OutputStreamWriter osw;
	
	public void openConnection(String ip, int port)
	{
        try 
        {
			socket = new Socket(ip, port);
	        os = socket.getOutputStream();
	        osw = new OutputStreamWriter(os);
	        sendInfoToServer("helloserver?");
        	System.out.println("connected");
        }
        catch (Exception exception) 
        {
        	System.out.println("cannot open connection");
        }
	}

	public void closeConnection(String ip, int port)
	{
		try
		{
	        os.close();
	        osw.close();
	        socket.close();
		}
        catch (Exception exception) 
        {
            System.out.println("cannot close connection");
        }
	}
	
	public void sendInfoToServer(String info)
	{
		System.out.println(info);
		
        try 
        {
        	BufferedWriter bw = new BufferedWriter(osw);
            bw.write(info);
            bw.flush();
            bw.close();
        	System.out.println("send");
        }
        catch (Exception exception) 
        {
        	System.out.println("cannot send info");
        }
        
	}
}