package hashmapBonus;

import java.util.HashMap;

/**
 * Catalog class that adds Products object to a HashMap and returns certain elements of the HashMap
 * 
 * @author Mark Yan
 * @version 12.8.25
 * 
 */

public class Catalog {
	
	private HashMap<String, Product> products;
	
	/**
	 * Initializes a new HashMap object
	 * 
	 */
	public Catalog() {
		// TODO Auto-generated constructor stub
		products = new HashMap<>();
	}
	
	/**
	 * Void method that adds a Product object to the HashMap
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		products.put(product.getId(), product);
	}
	
	/**
	 * Void method that removes a Product from the HashMap by its product ID
	 * 
	 * @param productId
	 */
	public void removeProduct(String productId) {
		products.remove(productId);
	}
	
	/**
	 * Method that returns the Product's information based on its product ID
	 * 
	 * @param productId
	 * @return Product Information or null
	 */
	public Product findProduct(String productId) {
		if(products.containsKey(productId)) {
			return products.get(productId);
		}
		return null;
	}
	
	/**
	 * Void method that displays the elements in the HashMap
	 * 
	 */
	public void displayProducts() {
		if(products.isEmpty()) {
			System.out.println("There are no items in the catalog.");
		}
		else {
			for(Product product: products.values()) {
				System.out.println(product);
			}
		}
	}

}
