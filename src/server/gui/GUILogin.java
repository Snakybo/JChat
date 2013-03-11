package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.Main;

public class GUILogin extends JFrame {
	private static final long serialVersionUID = 1L;

	public GUILogin() {
		//Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 150);
		setTitle("DerpChat 2 - Server " + Main.version);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// Add header label
		JLabel jl = new JLabel("JChat Server " + Main.version);
		add(jl);
		
		jl.setFont(new Font("Arial", Font.PLAIN, 25));
		jl.setVerticalAlignment(JLabel.TOP);
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		// Add textfield
		JPanel jp = new JPanel();
		JTextField jtf = new JTextField();
		
		jtf.setColumns(10);
		jtf.setBounds(20, 5, 30, 30);
		
		jp.add(jtf);
		add(jp);
	}
}
