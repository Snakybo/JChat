package gui;

public class GuiChat 
{
	public static String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	
	public GuiChat()
	{
		
	}
	
	public void guiChatCreate()
	{
		
	}
	
	public void guiChatDestroy()
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
