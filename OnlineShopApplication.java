import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * COMP503 Programming 2 2016 S1
 * 
 * This program provides interaction with an Online Shop, allowing users to select and 
 * purchase products from a database. The program implements a Product Recommender Algorithm
 * (PRA) algorithm that recommends related products to the customer based on their purchases. 
 * The PRA works by analysing transaction histories from a text file and observing the frequency 
 * products are purchased together. Other products with high purchase frequencies with the
 * customer's current purchases are recommended to them.
 * 
 * @author Patricia Danielle Tan
 * @version 1.0 - 29.05.2016: Created
 */
public class OnlineShopApplication {
	
	//----------------------------------------------------------------------------------------
	/**
	 * Implements Online Shop functionality and takes user input via console.
	 * @param args A string array containing the command line arguments
	 * 
	 * */
	public static void main(String[] args) {
		
		System.out.println("Welcome to the MiscMart Online Shop\n");
		
		OnlineShop miscMart = new OnlineShop(generateSampleDatabase()); //initialise new OnlineShop object
		
		//try to read purchase history transcript from text file and handle errors appropriately
		try {
			miscMart.getRecommenderSystem().setPurchaseHistories(readPurchaseHistoryData(generateSampleDatabase(), "purchase-history.txt"));
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Cannot process product codes\nThe program will now terminate");
			System.exit(0);
		} catch (ProductNotFoundException e) {
			System.out.println("ERROR: Product missing from database\nThe program will now terminate");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("ERROR: The purchase transcript file cannot be opened/read\nThe program will now terminate");
			System.exit(0);
		}
		
		//String representing main menu
		String menu = "------------------------------------------------"
					 +"\nOnline Shop functionality"
					 +"\n1. Add product to cart"
					 +"\n2. View your shopping cart"
					 +"\n3. Finalise purchases"
					 +"\n4. Quit"
					 +"\nPlease enter a menu option (1-4):";
		
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		int menuSelect = 0;
		
		do {
			do { //main menu functionality
				System.out.println(menu);
				try {
					menuSelect = keyboard.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("ERROR: Invalid input type\nPlease restart the application");
					System.exit(0);
				}
			} while (menuSelect < 1 || menuSelect > 4); //repeat menu if input out of range

			if (menuSelect == 1) { //display product menu and allow customer to add a chosen product to the cart
				int productSelect = 0;
				do {
					System.out.println("------------------------------------------------"
									  +"\nPlease select a product from the menu");
					System.out.println(generateSampleDatabase());
					System.out.println("Please enter a menu option (1-"+generateSampleDatabase().getProductDatabase().size()+"):");
					try {
						productSelect = keyboard.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("ERROR: Invalid input type\nPlease restart the application");
						System.exit(0);
					}
				} while (productSelect < 1 || productSelect > generateSampleDatabase().getProductDatabase().size()); //repeat menu if input out of range
				miscMart.addProductToCart((generateSampleDatabase().getProductDatabase().get(productSelect-1)));
				System.out.println("Adding "+(generateSampleDatabase().getProductDatabase().get(productSelect-1))+" to your cart");
			}
			
			if (menuSelect == 2) { //display contents of the cart
				if (!miscMart.getCart().isEmpty()) {
					System.out.println("------------------------------------------------"
									  +"\nContents of your cart (sorted by price)");
					for (Product p : miscMart.getCart()) {
					System.out.println(p);
					}
				} 
				else {
					System.out.println("Your cart is currently empty");
				}
			}
			
			if (menuSelect == 3) { //compute total payment owing and allow customer to finalise purchases
				int payNow = 0;
				if (!miscMart.getCart().isEmpty()) {
					do {
						System.out.println("------------------------------------------------"
										  +"\nContents of your cart (sorted by price)");
						for (Product p : miscMart.getCart()) {
							System.out.println(p);
						}
						System.out.println("Total amount owing: $"+String.format("%.2f", miscMart.amountOwing()));
						System.out.println("Pay full amount?\n1. Yes\n2. No, back to main menu");
						System.out.println("Please enter a menu option (1-2):");
						try {
							payNow = keyboard.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("ERROR: Invalid input type\nPlease restart the application");
							System.exit(0);
						}
						if (payNow == 1) {
							System.out.println("Thank you for your purchase."
											  +"\nYou may also be interested in purchasing these products:");
							ArrayList<Product> recommended = new ArrayList<Product>();
							recommended.addAll(miscMart.getRecommenderSystem().praAlgorithm(miscMart.getCart(), 2)); //store recommended products in a list
							if (!recommended.isEmpty()) {
								for (Product p : recommended) {	//display each recommended product
									System.out.println(p);
								}
							}
							else {
								System.out.println("No suggestions");
							}
							miscMart.completeTransaction();
						}
					} while (payNow < 1 || payNow > 2); //repeat menu if input out of range
				}
				else {
					System.out.println("Your cart is currently empty");
				}
			}
			
			if (menuSelect == 4) { //exit out of program
				System.out.println("Thank you for using the Online Shop");
				quit = true;
			}
		} while (!quit);
		
		keyboard.close();
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Generates a sample product database.
	 * @return a ProductDatabase object containing sample Products
	 * 
	 * */
	private static ProductDatabase generateSampleDatabase() {
		
		ProductDatabase productDatabase = new ProductDatabase();
		
		productDatabase.addProduct(new Instrument("Fender", "Telecaster Electric Guitar", 123, 1000.00));
		productDatabase.addProduct(new Album("Valtari", "Sigur Ros", 187, 23.99));
		productDatabase.addProduct(new Shoes("Dr Martens 1460 8-Eye Boot", "CHERRY RED", 199, 226.00));
		productDatabase.addProduct(new Fabric("Black Flocked Satin", 2, 200, 17.50));
		productDatabase.addProduct(new ConcertTicket("Bring Me The Horizon Auckland 25 Sep 2016 GA", false, 865, 76.50));
		
		return productDatabase;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Reads purchase history data from a text file and returns a set of customer purchases.
	 * @param pd A ProductDatabase
	 * @param fileName A String representing the name of the text file
	 * @throws ProductNotFoundException If a product on file is missing from the supplied database
	 * @throws IOException If file cannot be opened/read
	 * @throws NumberFormatException If Integer parsing fails
	 * @return a HashSet of PurchaseHistory objects
	 * 
	 * */
	public static HashSet<PurchaseHistory> readPurchaseHistoryData(ProductDatabase pd, String fileName)
			  	  throws ProductNotFoundException, IOException, NumberFormatException {
		
		HashSet<PurchaseHistory> purchaseHistorySet = new HashSet<PurchaseHistory>(); //initialise set of customer purchases
		
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		System.out.println("Reading purchase transcript: "+fileName);
		String line = null;
		
		while ((line = br.readLine()) != null) {
			ArrayList<Product> customerPurchases = new ArrayList<Product>(); 
			int nProductsPurchased = new Integer(line);
			for (int i=0; i<nProductsPurchased; i++) {
				Integer code = new Integer(br.readLine());
				if (pd.products.get(code) == null) { //throw an exception if code in file does not match a product in database
					br.close();
					throw new ProductNotFoundException("ERROR: Product not found in database", code);
				}
				customerPurchases.add(pd.products.get(code)); //populate an array with products purchased together
			}
			
			PurchaseHistory purchaseHistory = new PurchaseHistory(customerPurchases); //initialise array as a new PurchaseHistory object
			
			purchaseHistorySet.add(purchaseHistory); //add PurchaseHistory object to set	
		}
		
		br.close();
		return purchaseHistorySet; //return set
	}
}