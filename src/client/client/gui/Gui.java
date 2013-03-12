package client.gui;

public class Gui 
{	
	public Gui()
	{
		
	}
	
	public static void guiCreate(int id)
	{
		switch(id) 
		{
			case 1: GuiChat.guiChatCreate();
		}
	}
	
	public static void guiDelete(int id)
	{
		switch(id)
		{
			case 1: GuiChat.guiChatDestroy();
		}
	}
}
