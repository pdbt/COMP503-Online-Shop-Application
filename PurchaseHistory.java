import java.util.ArrayList;

/**
 * PurchaseHistory --- class which models the purchase history of a customer.
 * @author Patricia Danielle Tan
 * 
 * */
public class PurchaseHistory {
	
	private ArrayList<Product> purchasedProducts = new ArrayList<Product>();
	
	//----------------------------------------------------------------------------------------
	/**
	 * Constructor supplying an ArrayList of Product objects.
	 * @param purchasedProducts An ArrayList of Product objects
	 * 
	 * */
	public PurchaseHistory(ArrayList<Product> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	} 
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the ArrayList of purchased products.
	 * @return an ArrayList of Product objects
	 * 
	 * */
	public ArrayList<Product> getPurchasedProducts() {
		return this.purchasedProducts;
	}
}
