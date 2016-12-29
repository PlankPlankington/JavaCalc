package com.txt452.calc;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.txt452.calc.advancalc.AdvanView;
import com.txt452.calc.basiccalc.BasicView;
import com.txt452.calc.intercalc.InterView;

public class Calc {
	private JFrame f;
	private static JPanel b;
	private static JPanel i;
	private static JPanel a;
	private JPanel cards;

	public Calc() {

		// Creating GUI---------------------------
		f = new JFrame("Basic Calculator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setLocationRelativeTo(null);
		f.setLayout(new BorderLayout());

		// Adding JMenu----------------

		JMenuBar dropdown = new JMenuBar();
		JMenu mode = new JMenu("Mode");
		JMenuItem BaiscView = new JMenuItem("Basic");

		// Adding listeners
		BaiscView.setActionCommand("B");
		BaiscView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard(e.getActionCommand());
			}
		});
		
		
		JMenuItem InterView = new JMenuItem("Intermediate");
		InterView.setActionCommand("I");
		InterView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard(e.getActionCommand());
			}
		});
		
		
		JMenuItem AdvanView = new JMenuItem("Scientific");
		AdvanView.setActionCommand("A");
		AdvanView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard(e.getActionCommand());
			}
		});
		
		
		// Initializing card Panel
		
		cards = new JPanel(new CardLayout());

		b = new BasicView();
		i = new InterView();
		a = new AdvanView();

		cards.add(b, "B");
		cards.add(i, "I");
		cards.add(a, "A");
		
		// Adding components to frame

		mode.add(BaiscView);
		mode.add(InterView);
		mode.add(AdvanView);
		dropdown.add(mode);

		f.add(dropdown, BorderLayout.NORTH);
		f.add(cards, BorderLayout.CENTER);
		f.setVisible(true);

		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, "B");
		f.setSize(new Dimension(BasicView.BWIDTH + 10, BasicView.BHEIGHT + 10));
	}

	public void showCard(String key) {
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, key);
		switch(key.charAt(0)){
		case 'B':
			f.setSize(new Dimension(BasicView.BWIDTH + 10, BasicView.BHEIGHT + 10));
			break;
		case 'I':
			f.setSize(new Dimension(InterView.IWIDTH + 10, InterView.IHEIGHT + 10));
			break;
		case 'A':
			f.setSize(new Dimension(AdvanView.AWIDTH + 10, AdvanView.AHEIGHT + 10));
			break;
		}
	}
}
