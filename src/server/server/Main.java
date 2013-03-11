package server;

import gui.GUILogin;

import javax.swing.JFrame;

import server.network.Listen;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final float version = 0.2f;
	
	public static void main(String[] args) {
		// Create GUI
		new GUILogin();
		
		// Set up listening connection
		new Listen();
    }
}