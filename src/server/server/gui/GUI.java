package server.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import server.Server;

public class GUI extends JFrame {
	private static final long serialVersionUID = 2941318999657277463L;
	
	public static JTextPane txtArea;
	private JPanel panel;
	
	private JTextField txtField;
	private JButton btn1, btn2;

	public GUI() {
		// Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350 + 16, 450 + 19);
		setLocationRelativeTo(null);
		setTitle("JChat - Server " + Server.version);
		setResizable(false);
		
		// Create content
		panel = new JPanel();
		txtArea = new JTextPane();
		txtField = new JTextField();
		btn1 = new JButton("Send");
		btn2 = new JButton("Config");
		
		panel.setLayout(null);
		
		txtArea.setEditable(false);
		txtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtArea.setBounds(5, 5, 350, 405);
		txtArea.setContentType("text/html");
		String font = txtArea.getFont().getFamily();
		txtArea.setText("<html><body style=\"font-family: " + font + "\"");
		
		txtField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtField.setBounds(5, 415, 200, 20);
		
		btn1.setBounds(210, 415, 70, 20);
		btn2.setBounds(285, 415, 70, 20);
		
		panel.add(txtArea);
		panel.add(txtField);
		panel.add(btn1);
		panel.add(btn2);
		add(panel);
		
		setVisible(true);
	}
	
	// Extend the options panel
	public static void Extend() {
		// TODO
	}
	
	// Retract the options panel
	public static void Retract() {
		// TODO
	}
	
	// Append to the txtArea
	public static void Append(String s) {
		StyledDocument doc = txtArea.getStyledDocument();
		System.out.println( "test");
		try {
			doc.insertString(doc.getLength(), s + "\n", null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
