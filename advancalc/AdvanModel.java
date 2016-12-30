package com.txt452.calc.advancalc;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AdvanModel {
	private boolean equalsPressedLast;
	private String currentText;
	private float memory;
	private ArrayList<String> equation;

	public AdvanModel() {
		setEqualsPressedLast(false);
		setCurrentText("");
		setMemory(0);
		setEquation(new ArrayList<String>());
	}

	public boolean isEqualsPressedLast() {
		return equalsPressedLast;
	}

	public void setEqualsPressedLast(boolean equalsPressedLast) {
		this.equalsPressedLast = equalsPressedLast;
	}

	public String getCurrentText() {
		return currentText;
	}

	public void setCurrentText(String currentText) {
		this.currentText = currentText;
	}

	public float getMemory() {
		return memory;
	}

	public void setMemory(float memory) {
		this.memory = memory;
	}

	public ArrayList<String> getEquation() {
		return equation;
	}

	public void setEquation(ArrayList<String> equation) {
		this.equation = equation;
	}

	public String passEquation() {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			return engine.eval(getCurrentText()).toString();
		} catch (Exception e) {
			System.out.println("Invalid format");
		}
		return "ERROR";
	}
	public String passEquation(String s) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			return engine.eval(s).toString();
		} catch (Exception e) {
			System.out.println("Invalid format");
		}
		return "ERROR";
	}

}
