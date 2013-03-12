package server.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import server.Server;

public class GUIMain extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	public static JTextArea jta;
	private JTextField jtp;
	private JButton jbtn1, jbtn2;
	
	public GUIMain() {
		//Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(366, 469);
		setTitle("JChat - Server " + Server.version);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// Create window contents
		jp = new JPanel();
		jta = new JTextArea();
		jtp = new JTextField();
		jbtn1 = new JButton("Send");
		jbtn2 = new JButton("Config");
		
		jp.setLayout(null);
		
		jta.setEditable(false);
		jta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBounds(5, 5, 350 , 405);
		
		jtp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtp.setBounds(5, 415, 200 , 20);
		
		jbtn1.setBounds(210, 415, 70, 20);
		jbtn2.setBounds(285, 415, 70, 20);
		
		jp.add(jta);
		jp.add(jtp);
		jp.add(jbtn1);
		jp.add(jbtn2);
		add(jp);
		
		jta.append("Starting server..\n");
	}
}


