package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import server.Server;

public class GUIStart extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public GUIStart() {
		//Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 150);
		setTitle("DerpChat 2 - Server " + Server.version);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// Add header label
		JLabel jl = new JLabel("JChat Server " + Server.version);
		add(jl);
		
		jl.setFont(new Font("Arial", Font.PLAIN, 25));
		jl.setVerticalAlignment(JLabel.TOP);
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		// Add textfield
		JLabel plb = new JLabel("         Port: ");
		JTextField ptf = new JTextField(6);
    	
		plb.setBounds(35, 15, 150, 20); 
    	ptf.setBounds(60, 50, 150, 20); 
    	
    	add(ptf);
    	add(plb);
	}
}
