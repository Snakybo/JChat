import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
 
public class Client { 
    private static Socket socket;
 
    public static void main(String args[]) {
        try {
        	System.out.println("Connecting");
            String host = "172.17.53.107";
            int port = 7;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            //Send the message to the server
            System.out.println("Sending message");
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
 
            String number = "5";
 
            String sendMessage = number + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage);
            System.out.println("Message send");
            
            //Get the return message from the server
            System.out.println("Receiving message");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " +message);
            System.out.println("Message received");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            //Closing the socket
            try {
                socket.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}