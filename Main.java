package com.txt452.calc;

import javax.swing.UIManager;

public class Main {
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("L&F not Found");
		}
		new Calc();
	}

}
