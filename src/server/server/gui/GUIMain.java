package server.gui;

import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import server.Server;

public class GUIMain extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	public static JTextArea jta;
	
	public GUIMain() {
		//Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(366, 479);
		setTitle("DerpChat 2 - Server " + Server.version);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// Create text area
		jp = new JPanel();
		jta = new JTextArea();
		
		jta.setRows(25);
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBounds(5, 5, 345, 395);
		jta.setMargin(new Insets(5,5,5,5));
		
		jp.add(jta);
		add(jp);
		
		jta.append("Starting server..\n");
	}
}


