package client.network;

import client.gui.GuiChat;

public class NetworkCommand extends Network
{
	public String[][] cmds = {
			{"CMD_CLEAN","c","clear","clearchat","cleanchat","cls","clean"},
			{"CMD_HELP","help","h"},
			{"CMD_KICK", "kick"},
			{"CMD_BAN", "ban"},
			{"CMD_UNBAN", "unban"},
			{"CMD_ADDOP", "op"},
			{"CMD_DEOP", "deop"},
			{"CMD_BANGLOB", "banglob"},
			{"CMD_UNBANGLOB", "unbanglob"}
		};

	
	public void SendClientCommand(String name, String nick, String info)
	{
		String infostring = "command#" + name + "#" + nick + "#" + info + "#" + "null";
		sendInfoToServer(infostring);
	}
	
	
	public void SendClientCommand(String name, String nick, String info, String para)
	{
		String infostring = "command#" + name + "#" + nick + "#" + info + "#" + para;
		sendInfoToServer(infostring);
	}
	
	public void NewCommand(String name, String nick, String info)
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
			SendClientCommand(name, nick, "CMD_CLEAN");
		} 
		
		if(cmdString.equals("CMD_KICK"))
		{
			if(input.length < 2)
			{
				GuiChat.DisplayMessage("No parameter found, example: /kick [name]");
			}
			else
			{
				SendClientCommand(name, nick, "CMD_KICK", input[1]);
			}
		}
		
		if(cmdString.equals("CMD_BAN"))
		{
			if(input.length < 2)
			{
				GuiChat.DisplayMessage("No parameter found, example: /ban [name]");
			}
			else
			{
				SendClientCommand(name, nick, "CMD_BAN", input[1]);
			}
		}

		if(cmdString.equals("CMD_ADDOP"))
		{
			if(input.length < 2)
			{
				GuiChat.DisplayMessage("No parameter found, example: /op [name]");
			}
			else
			{
				SendClientCommand(name, nick, "CMD_ADDOP", input[1]);
			}
		}
		
		if(cmdString.equals("CMD_DEOP"))
		{
			if(input.length < 2)
			{
				GuiChat.DisplayMessage("No parameter found, example: /deop [name]");
			}
			else
			{
				SendClientCommand(name, nick, "CMD_DEOP", input[1]);
			}
		}
		
		if(cmdString.equals("CMD_HELP"))
		{
			if(input.length < 2)
			{
				GuiChat.DisplayMessage("No parameter found, example: /help [page]");
			}
			else
			{
				GuiChat.DisplayMessage("you yelled for help but the server didn't respond....");
			}
		} 
	}
}
