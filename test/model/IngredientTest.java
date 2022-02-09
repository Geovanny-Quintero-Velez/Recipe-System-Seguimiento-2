package model;

import static org.junit.Assert.*;
import org.junit.Test;
import exceptions.NegativeNumberException;

public class IngredientTest {

	private Ingredient ingredient;
	
	private void setupStage1() throws NegativeNumberException {
		ingredient = null;
		ingredient = new Ingredient("Ingredient_1",245);
	}
	
	@Test
	public void testAddWeight() throws NegativeNumberException {
		setupStage1();
		try {
			ingredient.addWeight(54);
		} catch(NegativeNumberException e) {
			fail("This exception shouldn't be thrown.");
		}
		assertEquals("The weight wasn't uptaded.", 299, ingredient.getWeight(), 0.00001);
	}
	
	@Test
	public void testAddNegativeWeight() throws NegativeNumberException{
		setupStage1();
		try {
			ingredient.addWeight(-100);
			fail("The exception wasn't thrown.");
		} catch(NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
		assertEquals("The weight changed.", 245, ingredient.getWeight(), 0.00001);
	}
	
	@Test
	public void testRemoveWeight() throws NegativeNumberException {
		setupStage1();
		try {
			ingredient.removeWeight(45);
		} catch(NegativeNumberException e) {
			fail("This exception shouldn't be thrown.");
		}
		assertEquals("The weight wasn't uptaded.", 200, ingredient.getWeight(), 0.00001);
	}
	
	@Test
	public void testRemoveNegativeWeight() throws NegativeNumberException{
		setupStage1();
		try {
			ingredient.removeWeight(-100);
			fail("The exception wasn't thrown.");
		} catch(NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
		assertEquals("The weight changed.", 245, ingredient.getWeight(), 0.00001);
	}
	
}
