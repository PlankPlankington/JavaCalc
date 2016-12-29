package com.txt452.calc.advancalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AdvanController implements ActionListener {
	private AdvanView calc;
	private AdvanModel model;

	public AdvanController(AdvanView calc) {
		this.calc = calc;
		model = new AdvanModel();
	}

	public void actionPerformed(ActionEvent e) {
		String eventText = e.getActionCommand();
		if (eventText.contains("key")) {
			switch (eventText.charAt(3)) {
			case 'M':
				if (model.isEqualsPressedLast()) {
					model.setMemory(Float.parseFloat(model.getCurrentText()));
					outputText("Memory Stored");
					model.setCurrentText("");
				} else {
					model.setCurrentText(model.getCurrentText() + model.getMemory());
					outputText(model.getCurrentText());
				}
				break;
			case 'C':
				outputText("Cleared");
				model.setCurrentText("");
				break;
			case '=':
				model.setCurrentText(model.getCurrentText().replace("sin(", "Math.sin(").replace("cos(", "Math.cos(")
						.replace("tan(", "Math.tan(").replace("ln(", "Math.log("));
				while (model.getCurrentText().indexOf("^") != -1) {
					String c = model.getCurrentText();
					String[] cb = c.split("[()]");
					ArrayList<String> cba = new ArrayList<String>(Arrays.asList(cb));
					for (int i = 0; i < cba.size(); i++) {
						if (cba.get(i).equals("^")) {
							double ac = 0;
							ac = Math.pow(Float.parseFloat(model.passEquation(cba.get(i - 1))),
									Float.parseFloat(model.passEquation(cba.get(i + 1))));
							cba.remove(i - 1);
							cba.remove(i - 1);
							cba.remove(i - 1);
							cba.add(i - 1, ac + "");
						}
					}
					c = "";
					for (String s : cba) {
						c = c + s;
					}
					model.setCurrentText(c);
				}
				model.setCurrentText(round(model.passEquation()));
				outputText(model.getCurrentText());
				if (model.getCurrentText().equals("ERROR")) {
					model.setCurrentText("");
				}
				model.setEqualsPressedLast(true);
				break;
			case 's':
				model.setCurrentText(model.getCurrentText() + "sin(");
				outputText(model.getCurrentText());
				break;
			case 'c':
				model.setCurrentText(model.getCurrentText() + "cos(");
				outputText(model.getCurrentText());
				break;
			case 't':
				model.setCurrentText(model.getCurrentText() + "tan(");
				outputText(model.getCurrentText());
				break;
			case 'l':
				model.setCurrentText(model.getCurrentText() + "ln(");
				outputText(model.getCurrentText());
				break;
			case '^':
				if (eventText.length() == 4) {
					model.setCurrentText(model.getCurrentText() + ")^(");
				} else{
					model.setCurrentText(model.getCurrentText() + ")^(2)");
				}
				outputText(model.getCurrentText());
				break;
			default:
				model.setCurrentText(model.getCurrentText() + eventText.charAt(3));
				outputText(model.getCurrentText());
			}
		}
	}

	public void outputText(String out) {
		calc.updateText(out);
	}

	public static String round(String snum) {
		if (snum.equals("ERROR")) {
			return "ERROR";
		}
		double num = Double.parseDouble(snum);
		if (num == 0) {
			return "0";
		}

		final double d = Math.ceil(Math.log10(num < 0 ? -num : num));
		final int power = 10 - (int) d;

		final double magnitude = Math.pow(10, power);
		final long shifted = Math.round(num * magnitude);
		return Double.toString(shifted / magnitude);
	}
}
