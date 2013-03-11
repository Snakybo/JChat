package server;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import server.connection.Connect;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public Connect connect;
	
	public static final float version = 0.2f;
	private int windowWidth = 350;
	private int windowHeight = 400;
	
	public Main() {
		// Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowWidth + 16, windowHeight + 39);
		setTitle("DerpChat 2 - Server " + Main.version);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// Create text area
		JPanel jp = new JPanel();
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		jta.setRows(25);
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBounds(5, 5, (windowWidth - 5), (windowHeight - 5));
		
		jp.add(jta);
		add(jp);
		
		// Set up connection
		new Connect();
	}
	
	public static void main(String[] args) {
		new Main();	
    }
}