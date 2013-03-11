import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
 
public class Server extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public Connect connect;
	public static final float version = 0.1f;
	
	public Server() {
		// Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(366, 439);
		setTitle("DerpChat 2 - Server " + version);
		setResizable(false);
		setVisible(true);
		
		// Create text area
		JTextArea textArea = new JTextArea(); 
	}
	private static Socket socket;
    public static void main(String[] args) {
    	new Server();
    	new Connect();
    }
}