import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * ProductDatabase --- class storing a database of products.
 * @author Patricia Danielle Tan
 * 
 * */
public class ProductDatabase {
	
	HashMap<Integer, Product> products;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Default constructor initialising a HashMap collection mapping Integers to Product objects.
	 * 
	 * */
	public ProductDatabase() {
		products = new HashMap<Integer, Product>();
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Adds a product to the database.
	 * @param p A Product object
	 * 
	 * */
	public void addProduct(Product p) {
		products.put(p.getProductCode(), p);
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns the products stored in the database in an ArrayList.
	 * @return an ArrayList of Product objects
	 * 
	 * */
	public ArrayList<Product> getProductDatabase() {
		ArrayList<Product> productArrayList = new ArrayList<Product>(products.values());
		Collections.sort(productArrayList);
		return productArrayList;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a String representation of the ProductDatabase object.
	 * @return a String representation of the ProductDatabase object
	 * 
	 * */
	public String toString() {
		int listNumber = 1;
		String productList = "";
		for (Product p : getProductDatabase()) {
			productList += (listNumber++)+" "+p.toString();
			if (listNumber <= getProductDatabase().size()) {
				productList += "\n";
			}
		}
		return productList;
	}
}
