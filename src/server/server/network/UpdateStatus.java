package server.network;

import java.util.Timer;
import java.util.TimerTask;

import server.JServer;
import server.database.DataServerServerlist;

public class UpdateStatus {
	private DataServerServerlist dataserverlist = new DataServerServerlist();

	public UpdateStatus() {
		Timer updateTimer = new Timer();
		int updateTime = 6*60*1000;
		
		updateTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(JServer.getTime() + " - Updated");
				dataserverlist.UpdateServer();
			}
		}, updateTime, updateTime);
	}
}
