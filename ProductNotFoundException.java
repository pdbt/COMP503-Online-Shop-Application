/**
 * ProductNotFoundException --- subclass of Exception, to be thrown when a referenced
 * product code does not match an existing product in the database.
 * @author Patricia Danielle Tan
 * 
 * */
@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {

	private int productCode;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Constructor with input parameters for error message and bad product code.
	 * @param message A string
	 * @param productCode An int
	 * 
	 * */
	public ProductNotFoundException(String message, int productCode) {
		super(message);
		this.productCode = productCode;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a String description of the ProductNotFoundException.
	 * @return a String
	 * 
	 * */
	@Override
	public String toString() {
		return super.getMessage()+" for product code: "+productCode;
	}
}
