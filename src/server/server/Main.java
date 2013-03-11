package server;

import gui.GUIStart;

import javax.swing.JFrame;

import network.Listen;


public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final float version = 0.2f;
	
	public static void main(String[] args) {
		// Create GUI
		new GUIStart();
		
		// Set up listening connection
		new Listen();
    }
}