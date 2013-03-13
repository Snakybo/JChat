package old.server.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import old.server.Server;
import old.server.network.send.SendMsg;


public class GUIMain extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	public static JTextArea jta;
	private JTextField jtp;
	private JButton jbtn1, jbtn2;
	
	public GUIMain() {
		//Create window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(366, 469);
		setTitle("JChat - Server " + Server.version);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// Create window contents
		jp = new JPanel();
		jta = new JTextArea();
		jtp = new JTextField();
		jbtn1 = new JButton("Send");
		jbtn2 = new JButton("Config");
		
		jp.setLayout(null);
		
		jta.setEditable(false);
		jta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBounds(5, 5, 350 , 405);
		
		jtp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtp.setBounds(5, 415, 200 , 20);
		
		jbtn1.setBounds(210, 415, 70, 20);
		jbtn2.setBounds(285, 415, 70, 20);
		
		jp.add(jta);
		jp.add(jtp);
		jp.add(jbtn1);
		jp.add(jbtn2);
		add(jp);
		
		setVisible(true);
		
		jta.append("Starting server..\n");
		
		jbtn2.addActionListener(this);
		jbtn1.addActionListener(this);
		jtp.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e)  { }
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == 10) {
            		new SendMsg(jtp.getText());
            		jtp.setText("");
            	}
            }
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		
		if (btn == "Send") {
			new SendMsg(jtp.getText());
			jtp.setText("");
		}
		
		if (btn == "Config") {
			new GUISettings();
		}
	}
}


