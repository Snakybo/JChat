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

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 2941318999657277463L;
	
	public static JTextPane txtArea;
	private JPanel panel;
	
	private JLabel olbl1, ilbl1, ilbl2;
	private JTextField txtField, otxtField1, itxtField1, itxtField2;
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
		otxtField1 = new JTextField();
		obtn1 = new JButton();
		
		ilbl1 = new JLabel();
		ilbl2 = new JLabel();
		itxtField1 = new JTextField();
		itxtField2 = new JTextField();
		
		olbl1.setText("Port:");
		olbl1.setBounds(360, 5, 145 , 10);
		
		otxtField1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		otxtField1.setBounds(360, 18, 145, 20);
		otxtField1.setText(Integer.toString(JServer.serverPort));
		
		ilbl1.setText("External IP:");
		ilbl1.setBounds(360, 38, 145, 20);
		ilbl2.setText("Local IP:");
		ilbl2.setBounds(360, 75, 145, 20);
		
		itxtField1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		itxtField1.setBounds(360, 56, 145, 20);
		itxtField1.setText(GetIP.ExtIP());
		itxtField1.setEditable(false);
		
		itxtField2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		itxtField2.setBounds(360, 93, 145, 20);
		itxtField2.setText(GetIP.IntIP(false));
		itxtField2.setEditable(false);
		
		obtn1.setText("Save");
		obtn1.setBounds(435, 415, 70, 20);
		
		panel.add(olbl1);
		panel.add(otxtField1);
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
		panel.remove(otxtField1);
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
			if (!JServer.debug) {
				if (Integer.parseInt(otxtField1.getText()) >= 1 && Integer.parseInt(otxtField1.getText()) <= 65535) JServer.serverPort = Integer.parseInt(otxtField1.getText());
				
				if (!FileWrite.WriteConfig()) {
					PopupManager.GiveWarning("Could not save configuration");
				} else {
					if (PopupManager.AskClose("Server settings saved, close server?", "Settings saved") == 0) {
						System.exit(0);
					}
				}
			} else {
				PopupManager.GiveWarning("Can not save while in debug mode");
			}
		}
	}
}
