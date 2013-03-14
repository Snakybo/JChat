package server.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import server.file.FileWrite;

import server.Server;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 2941318999657277463L;
	
	public static JTextPane txtArea;
	private JPanel panel;
	
	private JLabel olbl1, olbl2;
	private JTextField txtField, otxtField1, otxtField2;
	private JButton btn1, btn2, obtn1;
	
	private Boolean configToggled = false;

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
		btn1 = new JButton();
		btn2 = new JButton();
		
		panel.setLayout(null);
		
		txtArea.setEditable(false);
		txtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtArea.setBounds(5, 5, 350, 405);
		txtArea.setContentType("text/html");
		String font = txtArea.getFont().getFamily();
		txtArea.setText("<html><body style=\"font-family: " + font + "\"");
		
		txtField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtField.setBounds(5, 415, 200, 20);
		
		btn1.setText("Send");
		btn2.setText("Config");
		btn1.setBounds(210, 415, 70, 20);
		btn2.setBounds(285, 415, 70, 20);
		
		panel.add(txtArea);
		panel.add(txtField);
		panel.add(btn1);
		panel.add(btn2);
		add(panel);
		
		setVisible(true);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txtField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e)  { }
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == 10) {
            		txtField.setText("");
            	}
            }
        });
	}
	
	// Extend the options panel
	public void Extend() {
		setSize(500 + 16, 450 + 19);
		
		olbl1 = new JLabel();
		olbl2 = new JLabel();
		otxtField1 = new JTextField();
		otxtField2 = new JTextField();
		obtn1 = new JButton();
		
		olbl1.setText("Port:");
		olbl2.setText("Max Connections:");
		olbl1.setBounds(360, 5, 145 , 10);
		olbl2.setBounds(360, 45, 145, 10);
		
		otxtField1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		otxtField2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		otxtField1.setBounds(360, 20, 145, 20);
		otxtField2.setBounds(360, 60, 145, 20);
		
		obtn1.setText("Save");
		obtn1.setBounds(435, 415, 70, 20);
		
		panel.add(olbl1);
		panel.add(olbl2);
		panel.add(otxtField1);
		panel.add(otxtField2);
		panel.add(obtn1);
		repaint();
		
		obtn1.addActionListener(this);
	}
	
	// Retract the options panel
	public void Retract() {		
		panel.remove(olbl1);
		panel.remove(olbl2);
		panel.remove(otxtField1);
		panel.remove(otxtField2);
		panel.remove(obtn1);
		repaint();
		
		setSize(350 + 16, 450 + 19);
	}
	
	// Append to the txtArea
	public static void Append(String s) {
		StyledDocument doc = txtArea.getStyledDocument();
		try {
			doc.insertString(doc.getLength()," " + s + "\n", null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String btn = arg0.getActionCommand();
		
		if (btn == "Send") {
			txtField.setText("");
		}
		
		if (btn == "Config") {
			if (configToggled) {
				Retract();
				configToggled = false;
			} else {
				Extend();
				configToggled = true;
			}
		}
		
		if (btn == "Save") {
			if (!FileWrite.WriteConfig()) {
				Server.GiveWarning("Could not save configuration");
			} else {
				Server.CloseWithMessage("Configuration saved. Closing server");
			}
		}
	}
}
