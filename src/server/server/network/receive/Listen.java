package server.network.receive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Listen implements Runnable {
	private Socket server;
	private String line, input;
	
	Listen(Socket server) {
		this.server = server;
	}
	
	public void run() {
		input = "";
		
		try {
			// Get client input
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintStream out = new PrintStream(server.getOutputStream());
			
			while((line = in.readLine()) != null && !line.equals(".")) {
				input = input + line;
				out.println("Received: " + line);
			}
			
			System.out.println(input);
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
