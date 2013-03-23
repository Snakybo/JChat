package server.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.StyledDocument;

import server.JServer;
import server.file.FileWrite;
import server.network.GetIP;
import server.network.Send;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 2941318999657277463L;
	
	public static JTextPane txtArea;
	private JPanel panel;
	
	private JLabel olbl1, olbl2, olbl3, ilbl1, ilbl2;
	private JTextField txtField, otxtField1, otxtField2, otxtField3, itxtField1, itxtField2;
	private JButton btn1, btn2, obtn1;
	
	private Boolean configToggled = false;

	public GUI() {
		// Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350 + 16, 450 + 19);
		setLocationRelativeTo(null);
		setTitle("JChat - Server " + JServer.version);
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
		
		txtField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtField.setBounds(5, 415, 200, 20);
		txtField.requestFocusInWindow();
		
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
            		new Send(txtField.getText());
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
		olbl3 = new JLabel();
		otxtField1 = new JTextField();
		otxtField2 = new JTextField();
		otxtField3 = new JTextField();
		obtn1 = new JButton();
		
		ilbl1 = new JLabel();
		ilbl2 = new JLabel();
		itxtField1 = new JTextField();
		itxtField2 = new JTextField();
		
		olbl1.setText("Port:");
		olbl1.setBounds(360, (1*5), 145 , 10);
		otxtField1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		otxtField1.setBounds(360, (1*20 - 2), 145, 20);
		otxtField1.setText(Integer.toString(JServer.serverPort));
		
		olbl2.setText("Server Name:");
		olbl2.setBounds(360, ((5*5) + (1*20)), 145 , 10);
		otxtField2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		otxtField2.setBounds(360, ((2*20) + (4*5) - 2), 145, 20);
		otxtField2.setText(JServer.serverName);
		
		olbl3.setText("Max Users");
		olbl3.setBounds(360, ((5*5) + (3*20)), 145 , 10);
		otxtField3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		otxtField3.setBounds(360, ((4*20) + (4*5) - 2), 145, 20);
		otxtField3.setText(Integer.toString(JServer.serverMaxusers));
		
		ilbl1.setText("External IP:");
		ilbl1.setBounds(360, ((4*5) + (5*20)), 145, 20);
		itxtField1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		itxtField1.setBounds(360, ((6*20) + (4*5) - 2), 145, 20);
		itxtField1.setText(JServer.serverIP);
		itxtField1.setEditable(false);
		
		ilbl2.setText("Local IP:");
		ilbl2.setBounds(360, ((4*5) + (7*20)), 145, 20);
		itxtField2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		itxtField2.setBounds(360, ((8*20) + (4*5) - 2), 145, 20);
		itxtField2.setText(GetIP.IntIP());
		itxtField2.setEditable(false);
		
		obtn1.setText("Save");
		obtn1.setBounds(435, 415, 70, 20);
		
		panel.add(olbl1);
		panel.add(olbl2);
		panel.add(olbl3);
		panel.add(otxtField1);
		panel.add(otxtField2);
		panel.add(otxtField3);
		panel.add(obtn1);
		panel.add(ilbl1);
		panel.add(ilbl2);
		panel.add(itxtField1);
		panel.add(itxtField2);
		repaint();
		
		obtn1.addActionListener(this);
		itxtField1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						itxtField1.selectAll();
					}
				});
			}
		});
		itxtField2.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						itxtField2.selectAll();
					}
				});
			}
		});
	}
	
	// Retract the options panel
	public void Retract() {		
		panel.remove(olbl1);
		panel.remove(olbl2);
		panel.remove(olbl3);
		panel.remove(otxtField1);
		panel.remove(otxtField2);
		panel.remove(otxtField3);
		panel.remove(obtn1);
		panel.remove(ilbl1);
		panel.remove(ilbl2);
		panel.remove(itxtField1);
		panel.remove(itxtField2);		
		repaint();
		
		setSize(350 + 16, 450 + 19);
	}
	
	// Append to the txtArea
	public static void Append(String s) {
		StyledDocument doc = txtArea.getStyledDocument();
		try {
			doc.insertString(doc.getLength()," " + "[" + JServer.getTime() + "] " + s + "\n", null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String btn = arg0.getActionCommand();
		
		if (btn == "Send") {
			new Send(txtField.getText());
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
			if (!JServer.debug) {
				if (Integer.parseInt(otxtField1.getText()) >= 1 && Integer.parseInt(otxtField1.getText()) <= 65535) {
					if (Integer.parseInt(otxtField3.getText()) > 0) {
						JServer.serverPort = Integer.parseInt(otxtField1.getText());
						JServer.serverName = otxtField2.getText();
						JServer.serverMaxusers = Integer.parseInt(otxtField3.getText());
						
						FileWrite.WriteConfig();
						if (PopupManager.AskClose("Server settings saved, close server?", "Settings saved") == 0) {
							System.exit(0);
						}
					}
				}
			} else {
				PopupManager.GiveWarning("Can not save while in debug mode");
			}
		}
	}
}
