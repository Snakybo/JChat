package client.gui;
import javax.swing.JFrame;

public class Gui extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private int w;
	private int h;
	
	private GuiChat chat = new GuiChat();
	private GuiLogin login = new GuiLogin();
	
	public Gui(int width, int height, int version)
	{
		w = width;
		h = height;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(w, h);
		setLocationRelativeTo(null);
		setTitle("JChat-Client V" + version);
		setResizable(false);
	}
	
	public void guiCreate(int id)
	{
		switch(id) 
		{
			case 1: {  add(login); login.guiChatCreate(w, h); }
			//case 1: { add(chat); chat.guiChatCreate(w, h); }
		}
		setVisible(true);
	}
	
	public void guiDelete(int id)
	{
		switch(id)
		{
			case 1: { remove(login); login.guiChatDestroy(); }
			//case 1: { remove(chat); chat.guiChatDestroy(); }
		}
		setVisible(false);
	}
}
