package com.txt452.calc.basiccalc;

import java.util.ArrayList;

public class BasicModel{
	private boolean equalsPressedLast;
	private String currentText;
	private int memory;
	private ArrayList<String> equation;
	
	public BasicModel(){
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

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public ArrayList<String> getEquation() {
		return equation;
	}

	public void setEquation(ArrayList<String> equation) {
		this.equation = equation;
	}
	
}
