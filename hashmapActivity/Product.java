package hashmapBonus;

/**
 * Class for the creation of a Product object
 * 
 * @author Mark Yan
 * @version 12.8.25
 * 
 */

public class Product {
	
	private String productId;
	private double price;
	
	/**
	 * Constructor for the Product object
	 * 
	 * @param id
	 * @param price
	 */
	public Product(String id, double price) {
		this.productId = id;
		this.price = price;
	}
	
	/**
	 * Getter method that returns the product ID
	 * 
	 * @return productId
	 */
	public String getId() {
		return productId;
	}
	
	/**
	 * Getter method that returns the price of the product
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * toString method that prints the object's information
	 * 
	 */
	public String toString() {
		return "Product{productID: '" + productId + "', price: " + price + "}";
	}
}
