import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * RecommenderSystem --- class containing a product recommender algorithm.
 * @author Patricia Danielle Tan
 * 
 * */
public class RecommenderSystem {
	
	private ProductDatabase productDatabase;
	private HashSet<PurchaseHistory> purchaseHistories;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Default constructor initialising instance variables: a ProductDatabase object and a
	 * HashSet of PurchaseHistory objects.
	 * 
	 * */
	public RecommenderSystem() {
		productDatabase = new ProductDatabase();
		purchaseHistories = new HashSet<PurchaseHistory>();
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Supplies the RecommenderSystem with a product database.
	 * @param productDatabase A ProductDatabase object
	 * 
	 * */
	public void setProductDatabase(ProductDatabase productDatabase) {
		this.productDatabase = productDatabase;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Supplies the RecommenderSystem with a set of purchase histories.
	 * @param purchaseHistories A HashSet of PurchaseHistory objects
	 * 
	 * */
	public void setPurchaseHistories(HashSet<PurchaseHistory> purchaseHistories) {
		this.purchaseHistories = purchaseHistories;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Generates a list of recommended products based on the customer's cart. The list contains
	 * products which, according to purchase history data, have been purchased alongside those in the 
	 * customer's cart with equal/greater frequency to a number specified. This algorithm takes care
	 * not to recommend duplicate products or products already in the customer's cart.
	 * @param cart An ArrayList of Product objects
	 * @param freq An int specifying a minimum observation frequency
	 * 
	 * */
	public ArrayList<Product> praAlgorithm(ArrayList<Product> cart, int freq) {
		
		//find other products purchased alongside each cart product according to purchase histories and store these in a list
		ArrayList<Product> otherProducts = new ArrayList<Product>();
		for (Product cartProduct : cart) {
			for (PurchaseHistory ph : this.purchaseHistories) {
				if (ph.getPurchasedProducts().contains(cartProduct)) {
					ph.getPurchasedProducts().remove(cartProduct);
					otherProducts.addAll(ph.getPurchasedProducts());
				}
			}
		}
		
		//remove any occurrences of each cart product from the list of other products
		for (Product cartProduct : cart) {
			if (otherProducts.contains(cartProduct)) {
				otherProducts.removeAll(Collections.singleton(cartProduct));
			}
		}

		//map each product in the list of other products to a number representing the frequency it appears
		HashMap<Product, Integer> productFrequencyCountMap = new HashMap<Product, Integer>();
		for (Product otherProduct : otherProducts) {
			if (productFrequencyCountMap.containsKey(otherProduct)) {
				productFrequencyCountMap.put(otherProduct, (productFrequencyCountMap.get(otherProduct)+1));
			}
			else {
				productFrequencyCountMap.put(otherProduct, 1);
			}
		}
		
		//add any products mapped to a number equal/greater than the specified frequency to a list of recommended products
		ArrayList<Product> recommendations = new ArrayList<Product>();
		for (Entry<Product, Integer> p : productFrequencyCountMap.entrySet()) {
			if (p.getValue() >= freq) {
				recommendations.add(p.getKey());
			}
		}
		
		//sort and return the list of recommended products
		Collections.sort(recommendations);
		return recommendations;
	}
}
