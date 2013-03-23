package server.network;

import java.util.Timer;
import java.util.TimerTask;

import server.database.DatabaseServerlist;

public class Update {
	public static void updateStatus() {
		final DatabaseServerlist dataserverlist = new DatabaseServerlist();
		Timer updateTimer = new Timer();
		int updateTime = 6*60*1000;
		
		updateTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				dataserverlist.UpdateServer();
			}
		}, updateTime, updateTime);
	}
}
