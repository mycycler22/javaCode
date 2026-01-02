package hashmapBonus;

public class Main {

	public static void main(String[] args) {
        // Creating an instance of Catalog
        Catalog catalog = new Catalog();

        // Adding products to the catalog
        catalog.addProduct(new Product("P001", 29.99));
        catalog.addProduct(new Product("P002", 49.99));
        catalog.addProduct(new Product("P003", 19.99));

        // Displaying all products in the catalog
        System.out.println("Catalog contains:");
        catalog.displayProducts();

        // Searching for a product by its productId
        Product foundProduct = catalog.findProduct("P002");
        System.out.println("Found product: " + foundProduct);

        // Removing a product by its productId
        catalog.removeProduct("P003");
        System.out.println("Catalog after removing a product:");
        catalog.displayProducts();
		

	}

}
