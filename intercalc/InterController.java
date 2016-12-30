package com.txt452.calc.intercalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterController implements ActionListener {
	private InterView calc;
	private InterModel model;

	public InterController(InterView calc) {
		this.calc = calc;
		model = new InterModel();
	}

	public void actionPerformed(ActionEvent e) {
		String eventText = e.getActionCommand();
		boolean doublpoint = false;
		if (eventText.contains("key")) {
			switch (eventText.charAt(3)) {
			case 'M':
				if (model.isEqualsPressedLast()) {
					if (!model.getCurrentText().equals("ERROR")) {
						model.setMemory(Float.parseFloat(model.getCurrentText()));
						model.setCurrentText("");
						outputText("0");
					}
				} else {
					model.setCurrentText(Float.toString(model.getMemory()));
					outputText(model.getCurrentText());
				}
				model.setEqualsPressedLast(false);
				;
				break;
			case 'C':
				model.setCurrentText("");
				outputText("0");
				model.setEquation(new ArrayList<String>());

				break;
			case '+':
				model.getEquation().add(model.getCurrentText());
				model.getEquation().add("+");
				model.setCurrentText("");
				outputText("+");
				model.setEqualsPressedLast(false);
				break;
			case '-':
				model.getEquation().add(model.getCurrentText());
				model.getEquation().add("-");
				model.setCurrentText("");
				outputText("-");
				model.setEqualsPressedLast(false);
				break;
			case 'X':
				model.getEquation().add(model.getCurrentText());
				model.getEquation().add("X");
				model.setCurrentText("");
				outputText("X");
				model.setEqualsPressedLast(false);
				break;
			case '/':
				model.getEquation().add(model.getCurrentText());
				model.getEquation().add("/");
				model.setCurrentText("");
				outputText("/");
				model.setEqualsPressedLast(false);
				break;
			case '=':
				model.getEquation().add(model.getCurrentText());
				float acc;
				try {
					acc = Float.parseFloat(model.getEquation().get(0));
				} catch (Exception e2) {
					acc = 0;
				}
				for (int i = 0; i < model.getEquation().size() - 1; i++) {

					if (!doublpoint) {
						if (model.getEquation().get(i).equals("+")) {
							acc = acc + Float.parseFloat(model.getEquation().get(i + 1));
						} else if (model.getEquation().get(i).equals("-")) {
							acc = acc - Float.parseFloat(model.getEquation().get(i + 1));
						} else if (model.getEquation().get(i).equals("X")) {
							acc = acc * Float.parseFloat(model.getEquation().get(i + 1));
						} else if (model.getEquation().get(i).equals("/")) {
							try {
								acc = acc / Float.parseFloat(model.getEquation().get(i + 1));
							} catch (Exception e2) {
								acc = 0;
							}
						}
					}
				}
				model.setEquation(new ArrayList<String>());
				model.setEqualsPressedLast(true);
				if (doublpoint) {
					System.out.println("At doublepoint");
					model.setCurrentText("ERROR");
					outputText(model.getCurrentText());
				} else {
					model.setCurrentText(Float.toString(acc));
					outputText(model.getCurrentText());
				}
				break;
			default:
				if (model.getCurrentText().replace(".", "").length() >= 10) {

					model.setCurrentText(model.getCurrentText() + eventText.charAt(3));
					outputText(model.getCurrentText());
				} else if (model.getCurrentText().equals("ERROR")) {
					model.setCurrentText(Float.toString(Float.parseFloat("" + eventText.charAt(3))));
					outputText(model.getCurrentText());
				} else {
					try {
						model.setCurrentText(model.getCurrentText() + eventText.charAt(3));
					} catch (NumberFormatException ex) {
						model.setCurrentText("ERROR");
					}
					outputText(model.getCurrentText());
				}
				model.setEqualsPressedLast(false);
			}
		}
	}

	public void outputText(String out) {
		try{
			calc.updateText(Double.toString(round(Double.parseDouble(out))));
		} catch(Exception e2) {
			calc.updateText(out);
		}
	}

	public static double round(double num) {
		if (num == 0) {
			return 0;
		}

		final double d = Math.ceil(Math.log10(num < 0 ? -num : num));
		final int power = 10 - (int) d;

		final double magnitude = Math.pow(10, power);
		final long shifted = Math.round(num * magnitude);
		return shifted / magnitude;
	}
}
