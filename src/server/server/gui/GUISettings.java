package server.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import server.Server;
import server.network.Listen;

public class GUISettings extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel jl, pl, el;
	private JTextField ptf;
	private JButton btn;
	
	public GUISettings() {
		//Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 150);
		setTitle("JChat - Server " + Server.version);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// Add header label
		jl = new JLabel("JChat Server " + Server.version);
		add(jl);
		
		jl.setFont(new Font("Arial", Font.PLAIN, 25));
		jl.setVerticalAlignment(JLabel.TOP);
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		// Add textfield
		pl = new JLabel("         Port: ");
		ptf = new JTextField(13);
		btn = new JButton("Start Server");
		
		pl.setBounds(40, 10, 100, 20); 
    	ptf.setBounds(65, 50, 150, 20);
    	btn.setBounds(((250 / 2) - (120 / 2)), 75, 120, 20);
    	
    	add(ptf);
    	add(btn);
    	add(pl);
    	
    	btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String ptfText = ptf.getText(); 
			int ptfInt = Integer.parseInt(ptfText);
			if (ptfInt >= 1 && ptfInt <= 65535) {
				setVisible(false);
		    	new GUIMain();
		    	new Listen(ptfInt);
			} else {
				System.out.println("werk niet");
				el = new JLabel("Port smust be a number");
				
				el.setBounds(10, 10, 100, 20);
				
				add(el);
			}
		} catch(NumberFormatException a) {
			System.out.println("werk niet");
			el = new JLabel("Port smust be a number");
			
			el.setBounds(10, 10, 100, 20);
			
			add(el);
		}
	}
}
