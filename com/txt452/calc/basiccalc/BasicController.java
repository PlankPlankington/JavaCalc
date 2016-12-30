package com.txt452.calc.basiccalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BasicController implements ActionListener {
	private BasicView calc;
	private BasicModel model;

	public BasicController(BasicView calc){
		this.calc = calc;
		model = new BasicModel();
	}

	public void actionPerformed(ActionEvent e) {
		String eventText = e.getActionCommand();
		if (eventText.contains("key")) {
			switch (eventText.charAt(3)) {
			case 'M':
				if (model.isEqualsPressedLast()) {
					if (!model.getCurrentText().equals("ERROR")) {
						model.setMemory(Integer.parseInt(model.getCurrentText()));
						model.setCurrentText("0");
						calc.updateText("0");
					}
				} else {
					model.setCurrentText(Integer.toString(model.getMemory()));
					calc.updateText(model.getCurrentText());
				}
				model.setEqualsPressedLast(false);;
				break;
			case 'C':
				model.setCurrentText("0");
				calc.updateText("0");
				model.setEquation(new ArrayList<String>());

				break;
			case '+':
				model.getEquation().add(model.getCurrentText());
				model.getEquation().add("+");
				model.setCurrentText("0");
				calc.updateText("0");
				model.setEqualsPressedLast(false);
				break;
			case '-':
				model.getEquation().add(model.getCurrentText());
				model.getEquation().add("-");
				model.setCurrentText("0");
				calc.updateText("0");
				model.setEqualsPressedLast(false);
				break;
			case '=':
				model.getEquation().add(model.getCurrentText());
				int acc;
				try {
					acc = Integer.parseInt(model.getEquation().get(0));
				} catch (Exception e2) {
					acc = 0;
				}
				for (int i = 0; i < model.getEquation().size(); i++) {
					if (model.getEquation().get(i).equals("+")) {
						acc = acc + Integer.parseInt(model.getEquation().get(i + 1));
					} else if (model.getEquation().get(i).equals("-")) {
						acc = acc - Integer.parseInt(model.getEquation().get(i + 1));
					}
				}
				model.setEquation(new ArrayList<String>());
				model.setCurrentText(Integer.toString(acc));
				calc.updateText(model.getCurrentText());
				model.setEqualsPressedLast(true);;
				break;
			default:
				if (model.getCurrentText().length() == 10) {
					model.setCurrentText("ERROR");
				} else if (model.getCurrentText().equals("ERROR")) {
					model.setCurrentText(Integer.toString(Integer.parseInt("" + eventText.charAt(3))));
				} else {
					try {
						model.setCurrentText(Integer.toString(Integer.parseInt(model.getCurrentText() + eventText.charAt(3))));
					} catch (NumberFormatException ex) {
						model.setCurrentText("ERROR");;
					}
				}
				model.setEqualsPressedLast(false);
				calc.updateText(model.getCurrentText());
			}
		}
	}
}
