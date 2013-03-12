package server.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import server.Server;

public class GUISettings extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	private JLabel jl1, jl2, jl3;
	private JTextField jtp;
	private JButton jbtn1, jbtn2;
	
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
		jtp = new JTextField();
		jbtn1 = new JButton("Save");
		jbtn2 = new JButton("Cancel");
		
		jp.setLayout(null);

		jl1.setText("- JChat Server Config -");
		jl1.setFont(new Font("Arial", Font.BOLD, 25));
		jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		jl1.setBounds(15, 5, 300 , 30);
		
		jl2.setText("Port:");
		jl2.setBounds(55, -30, 100, 200);
		
		jtp.setText(Integer.toString(Server.listenPort));
		jtp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtp.setBounds(90, 60, 200 , 20);
		
		jbtn1.setBounds(170, 415, 90, 20);
		jbtn2.setBounds(265, 415, 90, 20);
		
		jp.add(jl1);
		jp.add(jl2);
		jp.add(jtp);
		jp.add(jbtn1);
		jp.add(jbtn2);
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
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Settings saved, server closing..");
					System.exit(0);
				} else {
					jl3.setText("Port number is out of range (1 - 65536)");
					jl3.setFont(new Font("Arial", Font.BOLD, 13));
					jl3.setHorizontalAlignment(SwingConstants.CENTER);
					jl3.setForeground(Color.RED);
					jl3.setBounds(30, 32, 300 , 30);
					jp.add(jl3);
					jp.repaint();
				}
			} catch(Exception ex) {
				jl3.setText("Port must be numeric");
				jl3.setFont(new Font("Arial", Font.BOLD, 13));
				jl3.setHorizontalAlignment(SwingConstants.CENTER);
				jl3.setForeground(Color.RED);
				jl3.setBounds(30, 32, 300 , 30);
				jp.add(jl3);
				jp.repaint();
			}
		}
		
		if (btn == "Cancel") {
			setVisible(false);
		}
	}
}


