package model;

import exceptions.*;

public class Ingredient {
	
	private String name;
	private double weight;
	
	public Ingredient(String n, double w) throws NegativeNumberException {
		if(w<0) {
			throw new NegativeNumberException();
		}
			name = n;
			weight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException {
		if(additionalW<0) {
			throw new NegativeNumberException();
		}else {
			weight = weight + additionalW;
		}
	}
	
	public void removeWeight(double inputWeight)throws NegativeNumberException {
		if(inputWeight<0 || (weight - inputWeight)<0) {
			throw new NegativeNumberException();
		}else {
			weight -= inputWeight;
		}
	}
}
