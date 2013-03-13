package server.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import server.Server;
import server.file.FileWrite;

public class GUISettings extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	private JLabel jl1, jl2, jl3, jl4;
	private JTextField jtp, jtp2;
	private JButton jbtn1, jbtn2, jbtn3, jbtn4;
	
	public static Boolean portOK;
	public static Boolean maxConnectionsOK;
	
	public GUISettings() {
		//Create window
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(366, 469);
		setTitle("JChat - Server " + Server.version);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// Create window contents
		jp = new JPanel();
		jl1 = new JLabel();
		jl2 = new JLabel();
		jl3 = new JLabel();
		jl4 = new JLabel();
		jtp = new JTextField();
		jtp2 = new JTextField();
		jbtn1 = new JButton("Save");
		jbtn2 = new JButton("Cancel");
		jbtn3 = new JButton("OPs");
		jbtn4 = new JButton("Bans");
		
		jp.setLayout(null);

		jl1.setText("- JChat Server Config -");
		jl1.setFont(new Font("Arial", Font.BOLD, 25));
		jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		jl1.setBounds(15, 5, 300 , 30);
		
		jl2.setText("Port:");
		jl2.setBounds(55, -45, 100, 200);
		
		jl4.setText("Max connections:");
		jl4.setBounds(55, -5, 100, 200);
		
		jtp.setText(Integer.toString(Server.listenPort));
		jtp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtp.setBounds(55, 65, 200 , 20);
		
		jtp2.setText(Integer.toString(Server.maxConnections));
		jtp2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtp2.setBounds(55, 105, 200 , 20);
		
		jbtn1.setBounds(170, 415, 90, 20);
		jbtn2.setBounds(265, 415, 90, 20);
		jbtn3.setBounds(5, 415, 70, 20);
		jbtn4.setBounds(80, 415, 70, 20);
		
		jp.add(jl1);
		jp.add(jl2);
		jp.add(jl4);
		jp.add(jtp);
		jp.add(jtp2);
		jp.add(jbtn1);
		jp.add(jbtn2);
		jp.add(jbtn3);
		jp.add(jbtn4);
		add(jp);
		
		setVisible(true);
		
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		
		if (btn == "Save") {
			try {
				int intText = Integer.parseInt(jtp.getText());
			
				if (intText >= 1 && intText <= 65536) {
					Server.listenPort = intText;
					FileWrite.WriteConfig();
					portOK = true;
					Server.CloseServer(false);
				} else {
					portOK = false;
					PrintError("Port number is out of range (1 - 65536)");
				}
			} catch(Exception ex) {
				portOK = false;
				PrintError("Port must be numeric");
			}
			
			try {
				int intText = Integer.parseInt(jtp2.getText());
				
				if (intText >= 1 && intText <= 100) {
					Server.maxConnections = intText;
					FileWrite.WriteConfig();
					maxConnectionsOK = true;
					Server.CloseServer(false);
				} else {
					maxConnectionsOK = false;
					PrintError("Max connections is out of range (1 - 100)");
				}
			} catch(Exception ex) {
				maxConnectionsOK = false;
				PrintError("Max Connections must be numeric");
			}
		}
		
		if (btn == "Cancel") {
			setVisible(false);
		}
	}
	
	public void PrintError(String err) {
		jl3.setText(err);
		jl3.setFont(new Font("Arial", Font.BOLD, 13));
		jl3.setHorizontalAlignment(SwingConstants.CENTER);
		jl3.setForeground(Color.RED);
		jl3.setBounds(30, 26, 300 , 30);
		jp.add(jl3);
		jp.repaint();
	}
}


