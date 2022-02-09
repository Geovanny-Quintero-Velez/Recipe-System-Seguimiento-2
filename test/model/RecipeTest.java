package model;

import exceptions.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class RecipeTest {

	private Recipe recipe;
	
	private void setupStage1() {
		recipe = null;
		recipe = new Recipe();
	}
	
	private void setupStage2() throws NegativeNumberException {
		recipe = null;
		recipe = new Recipe();
		recipe.addIngredient("Onion", 4);
		recipe.addIngredient("Rice", 4);
		recipe.addIngredient("Garlic", 58);
	}
	
	@Test
	public void testAddElementEmptyIngredients() throws NegativeNumberException {
		setupStage1();
		try {
			recipe.addIngredient("Salt", 12);
		} catch(NegativeNumberException e){
			fail("This exception shouldn't be thrown.");
		}
		assertTrue("Item was not addded to the list.", recipe.search("Salt") != null);
		assertEquals("List size isn't: 1.", 1 ,recipe.getIngredients().size());
		
	}
	
	@Test
	public void testAddFourthElement() throws NegativeNumberException {
		setupStage2();
		assertEquals("Initial list size isn't: 3.", 3 ,recipe.getIngredients().size());
		try {
			recipe.addIngredient("Pepper", 6);
		} catch(NegativeNumberException e) {
			fail("This exception shouldn't be thrown.");
		}
		assertTrue("Item was not addded to the list.", recipe.search("Pepper") != null);
		assertEquals("List size isn't: 4.", 4 ,recipe.getIngredients().size());
	}
	
	@Test
	public void testAddExistingIngredient() throws NegativeNumberException {
		setupStage2();
		try {
			recipe.addIngredient("Garlic", 21);
		} catch(NegativeNumberException e) {
			fail("This exception shouldn't be thrown.");
		}
		assertEquals("List size isn't: 3.", 3 ,recipe.getIngredients().size());
		assertEquals("Garlic size isn't: 79.", 79 ,recipe.search("Garlic").getWeight(), 0.00001);
	}
	
	@Test
	public void testRemoveIngredient() throws NegativeNumberException {
		setupStage2();
		recipe.removeIngredient("Garlic");
		assertEquals("List size isn't: 2.", 2 ,recipe.getIngredients().size());
		assertTrue("Item Onion isn't exist.", recipe.search("Onion") != null);
		assertTrue("Item Rice isn't exist.", recipe.search("Rice") != null);
	}
	
	
	
}
