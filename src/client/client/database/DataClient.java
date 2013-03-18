package client.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DataClient 
{
	public String sendData(String data)
	{
		URL url = null;
		BufferedReader in = null;
		String returnINFO = "";

		try 
		{ 
			url = new URL(data); 
			in = new BufferedReader(new InputStreamReader(url.openStream())); 
			String inputLine; 
			while ((inputLine = in.readLine()) != null)  
			{
				returnINFO += inputLine;
			}  
		} 
		catch (MalformedURLException e) 
		{ System.out.println("Cannot connect to server"); }
		catch (IOException e) 
		{ System.out.println("Cannot read from server"); }

		return returnINFO;
	}
}
