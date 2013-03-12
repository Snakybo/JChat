package client.gui;
import javax.swing.JFrame;

public class Gui extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private int w = 200;
	private int h = 200;
	
	private GuiChat chat = new GuiChat();
	
	public Gui(int width, int height, String version)
	{
		w = width;
		h = height;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(w, h);
		//setLayout(null); 
		setLocationRelativeTo(null);
		setTitle("JChat-Client V" + version);
		setResizable(false);
		setVisible(true);
	}
	
	public void guiCreate(int id)
	{
		switch(id) 
		{
			case 1: { add(chat); chat.guiChatCreate(w, h); }
		}
	}
	
	public void guiDelete(int id)
	{
		switch(id)
		{
			case 1: { remove(chat); chat.guiChatDestroy(); }
		}
	}
}
