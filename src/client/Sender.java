import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Sender 
{
    private static Socket socket;
    
	public Sender()
	{
		
	}

	public void Send(String Message, String ip, int port)
	{
        try 
        {
        	System.out.println("send 1");
            String host = ip;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);

        	System.out.println("send 2");
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

        	System.out.println("send 3");
            bw.write(Message);
            bw.flush();

        	System.out.println("send 4");
            //InputStream is = socket.getInputStream();
            //InputStreamReader isr = new InputStreamReader(is);
            //BufferedReader br = new BufferedReader(isr);
            //String message = br.readLine();

        	//System.out.println("send 5: " + message);
        	
            //return message;
        } 
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
        finally 
        {
            //Closing the socket
            try 
            {
                socket.close();
            } 
            catch(Exception e) 
            {
                e.printStackTrace();
            }
        }
        
        //return "";
	}
}
