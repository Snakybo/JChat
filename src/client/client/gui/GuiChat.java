package client.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiChat extends JPanel
{
	public static String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	private static JTextArea chatfield;
	
	public GuiChat()
	{
	}
	
	public void guiChatCreate(int width, int height)
	{
		chatfield = new JTextArea("");
		chatfield.setBounds(10, 10, 500, 400);
		chatfield.setEditable(false); 
		add(chatfield);
		
		DisplayMessage("Loading JChat V1.00");
	}
	
	public void guiChatDestroy()
	{
		
	}
	
	public static void DisplayMessage(String info)
	{
		chatfield.append(info + "\n");
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
