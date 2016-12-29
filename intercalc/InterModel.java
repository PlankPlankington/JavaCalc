package com.txt452.calc.intercalc;

import java.util.ArrayList;

public class InterModel{
	private boolean equalsPressedLast;
	private String currentText;
	private float memory;
	private ArrayList<String> equation;
	
	public InterModel(){
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
	
}
