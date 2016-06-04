import java.util.ArrayList;
import java.util.Collections;

/**
 * OnlineShop --- class containing a product database, recommender system and shopping cart.
 * Implements a payment system to compute the amount owing and complete the customer's transaction.
 * @author Patricia Danielle Tan
 * 
 * */
public class OnlineShop implements PaymentSystem {

	private ProductDatabase productDatabase;
	private RecommenderSystem recommenderSystem;
	private ArrayList<Product> cart;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Constructor supplying a product database and initialising instance variables.
	 * @param productDatabase 
	 * 
	 * */
	public OnlineShop(ProductDatabase productDatabase) {
		this.productDatabase = productDatabase;
		this.recommenderSystem = new RecommenderSystem();
		this.cart = new ArrayList<Product>();
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Calculates the total price of products in the cart.
	 * @return a Double
	 * 
	 * */
	@Override
	public Double amountOwing() {
		Double totalPrice = 0.00;
		for (Product p : this.cart) {
			totalPrice += p.getProductPrice();
		}
		return totalPrice;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Clears the cart.
	 * 
	 * */
	@Override
	public void completeTransaction() {
		this.cart.clear();
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Adds a product to the cart.
	 * @param p A Product object
	 * 
	 * */
	public void addProductToCart(Product p) {
		this.cart.add(p);
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns products in cart. 
	 * @return an ArrayList of Product objects
	 * 
	 * */
	public ArrayList<Product> getCart() {
		Collections.sort(this.cart);
		return this.cart;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * References the OnlineShop's recommender system.
	 * @return a RecommenderSystem object
	 * 
	 * */
	public RecommenderSystem getRecommenderSystem() {
		return this.recommenderSystem;
	}
}
