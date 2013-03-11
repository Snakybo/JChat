package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import server.Main;

public class GUIMain extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static JPanel jp;
	public static JTextArea jta;
	public static JScrollPane jsp;
	
	public GUIMain() {
		//Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(366, 439);
		setTitle("DerpChat 2 - Server " + Main.version);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// Create text area
		jp = new JPanel();
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		
		jta.setRows(25);
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBounds(5, 5, 345, 395);
		
		jp.add(jta);
		add(jp);
	}
}


