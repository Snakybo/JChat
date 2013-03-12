package client.sender;

import client.gui.GuiChat;

public class SendCommand extends Send
{
	public String[][] cmds = {
			{"CMD_CLEAN","c","clear","clearchat","cleanchat","cls"},
			{"CMD_HELP","help","h"}
		};

	
	public void SendClientCommand(String name, String pass, String info, String server, int port)
	{
		String infostring = "command#" + name + "#" + pass + "#" + info;
		sendInfoToServer(infostring, server, port);
	}
	
	public void NewCommand(String name, String pass, String info, String server, int port)
	{
		String[] input = info.split(" ");
		String cmdString = "";
		
		for(int i = 0; i < cmds.length; i++)
		{
			for(int j = 1; j < cmds[i].length; j++)
			{
				if(input[0].equals(cmds[i][j]))
				{
					cmdString = cmds[i][0];
				}
			}
		}
		
		if(cmdString.equals("CMD_CLEAN"))
		{
			SendClientCommand(name, pass, "CLEAR_SCREEN", server, port);
		} 
		
		if(cmdString.equals("CMD_HELP"))
		{
			if(input.length < 2)
			{
				GuiChat.DisplayMessage("No parameter found, example: /help [page]");
			}
			else
			{
				GuiChat.DisplayMessage("you yelled for help but the server didn't anwser....");
			}
		} 
	}
}
