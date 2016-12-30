package com.txt452.calc.intercalc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterView extends JPanel {
	
	private static final long serialVersionUID = 8482658400243768849L;
	
	public static final int IHEIGHT = 720;
	public static final int IWIDTH = 520;
	private String currentText;
	private JLabel textLabel;
	
	private InterController controller;

	public InterView() {
		super();
		
		//Adding controller
		
		controller = new InterController(this);
		
		//Setting frame size
		
		this.setPreferredSize(new Dimension(IWIDTH, IHEIGHT));
		
		// Text Panel-------------------------------

		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(IWIDTH, IHEIGHT / 5));
		currentText = "0";
		textLabel = new JLabel(currentText);
		textLabel.setFont(new Font("Serif", Font.BOLD, 100));
		textPanel.add(textLabel);

		// Number Panel---------------------------

		// Creating keys

		JButton key9 = new JButton("9");
		JButton key8 = new JButton("8");
		JButton key7 = new JButton("7");
		JButton key6 = new JButton("6");
		JButton key5 = new JButton("5");
		JButton key4 = new JButton("4");
		JButton key3 = new JButton("3");
		JButton key2 = new JButton("2");
		JButton key1 = new JButton("1");
		JButton key0 = new JButton("0");
		JButton keyp = new JButton(".");
	

		// Adding Listeners and Text Font

		formatBut(key9);
		formatBut(key8);
		formatBut(key7);
		formatBut(key6);
		formatBut(key5);
		formatBut(key4);
		formatBut(key3);
		formatBut(key2);
		formatBut(key1);
		formatBut(key0);
		formatBut(keyp);

		// Adding keys to JPanel

		JPanel numberpanel = new JPanel(new GridLayout(4, 3));
		numberpanel.setPreferredSize(new Dimension(IWIDTH * 3 / 5, IHEIGHT * 4 / 5));
		numberpanel.add(key7);
		numberpanel.add(key8);
		numberpanel.add(key9);
		numberpanel.add(key4);
		numberpanel.add(key5);
		numberpanel.add(key6);
		numberpanel.add(key1);
		numberpanel.add(key2);
		numberpanel.add(key3);
		numberpanel.add(key0);
		numberpanel.add(keyp);
		

		// Operator Panel----------------------------

		// Creating keys

		JButton keyMINU = new JButton("-");
		JButton keyPLUS = new JButton("+");
		JButton keyMULT = new JButton("X");
		JButton keyDIVI = new JButton("/");
		JButton keyC = new JButton("C");
		JButton keyM = new JButton("M");
		JButton keyEQUA = new JButton("=");

		// Adding Listeners and Font

		formatBut(keyMINU);
		formatBut(keyPLUS);
		formatBut(keyMULT);
		formatBut(keyDIVI);
		formatBut(keyC);
		formatBut(keyM);
		formatBut(keyEQUA);

		// Adding keys to JPanel

		JPanel operPanel = new JPanel(new GridLayout(4, 2));
		operPanel.setPreferredSize(new Dimension((IWIDTH * 2 / 5) - 5, IHEIGHT * 4 / 5));
		operPanel.add(keyPLUS);
		operPanel.add(keyMINU);
		operPanel.add(keyMULT);
		operPanel.add(keyDIVI);
		operPanel.add(keyC);
		operPanel.add(keyM);
		operPanel.add(keyEQUA);

		// Frame Creation------------------------
		
		this.setLayout(new BorderLayout());
		this.add(textPanel, BorderLayout.NORTH);
		this.add(operPanel, BorderLayout.EAST);
		this.add(numberpanel, BorderLayout.WEST);
	}
	
	public void updateText(String t){
		textLabel.setText(t);
	}

	public void formatBut(JButton b) {

		// Listener
		b.setActionCommand("key" + b.getText());
		b.addActionListener(controller);

		// Font
		b.setFont(new Font("Serif", Font.PLAIN, 60));
	}
}
