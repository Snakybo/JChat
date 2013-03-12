package client.gui;

import javax.swing.JTextArea;

public class GuiChat 
{
	public static String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	
	private JTextArea chatfield;
	
	public GuiChat()
	{
		chatfield = new JTextArea("");
	}
	
	public static void guiChatCreate()
	{
	}
	
	public static void guiChatDestroy()
	{
		
	}
	
	public static void DisplayMessage(String info)
	{
		
	}
	
	public static void DisplayTranslatedMessage(String info)
	{
		String newinfo = translate(info);
		DisplayMessage(newinfo);
	}
	
	public static String translate(String message)
	{
		for(int i = 0; i < translatechars.length; i++)
		{
			message = message.replaceAll(translatechars[i][0], translatechars[i][1]);
		}

		return message;
	}
}
