package model;

import exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	private List<Ingredient> ingredients;
	
	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
	}
	
	// Metodo addIngredient: Diferente el especificado en el diagrama de clase, ingresa el nombre y el peso por parametro.
	public String addIngredient(String n, double w) throws NegativeNumberException {
		try {
			Ingredient searched = search(n);
			if(searched!=null) {
				searched.addWeight(w);
				return "Ingredient "+n+", was successfully added.";
			}else {
				Ingredient newIngredient = new Ingredient(n, w);
				ingredients.add(newIngredient);
				return "New ingredient "+n+", was successfully added.";
			}
		}catch (NegativeNumberException e) {
				return e.getMessage();
			}
		}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public String removeWeight(String n, double w)throws NegativeNumberException {
		Ingredient searched = search(n);
		if(searched!=null) {
			searched.removeWeight(w);
			return "Ingredient weight: "+n+", has been updated to: "+w;
		}else {
			return "The ingredient: "+n+", wasn't found.";
		}	
	}
	
	public String removeIngredient(String n) {
		Ingredient searched = search(n);
		if(searched!=null) {
			ingredients.remove(searched);
			return "The ingredient: "+n+", was successfully removed.";
		}else {
			return "The ingredient: "+n+", wasn't found.";
		}	
	}
	
	// Metodo search: adicional a lo especificado en el diagrama de clases. Busca un objeto Ingredient y lo retorna.
	public Ingredient search(String n) {
		Ingredient searched = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(n)) {
				searched = current;
			}
		}
		return searched;
	}
}
