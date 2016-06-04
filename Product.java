/**
 * Product --- abstract class implementing the Comparable interface and storing a product's 
 * code and price.
 * @author Patricia Danielle Tan
 * 
 * */
public abstract class Product implements Comparable<Product> {

	protected Integer productCode;
	protected Double productPrice;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Compares the current Product with another Product based on price.
	 * @param other A Product object
	 * @return an int, less than 0 if the current Product is lower priced,
	 * 		   0 if equally priced and greater than 0 if greater priced.
	 * 
	 * */
	public int compareTo(Product other) {
        return productPrice.compareTo(other.productPrice);
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Evaluates whether another Product object is equal to the current Product object.
	 * @return a boolean, true if Products are equal and false otherwise
	 * 
	 * */
	@Override
	public boolean equals(Object o1) {
		if (this == o1) {
			return true;
		}
		Product product = (Product) o1;
		if (this.productCode != null && product.getProductCode() != null) {
			if (this.productCode.equals(product.getProductCode())) {
				return true;
			}
			return false;
		}
		return false;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the product's code.
	 * @return an Integer
	 * 
	 * */
	public Integer getProductCode() {
		return this.productCode;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the product's price.
	 * @return a Double
	 * 
	 * */
	public Double getProductPrice() {
		return this.productPrice;
	}
}
