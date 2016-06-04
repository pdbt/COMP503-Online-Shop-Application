/**
 * Shoes --- concrete subclass of Product with attributes for shoe name and colour.
 * @author Patricia Danielle Tan
 * 
 * */
public class Shoes extends Product {
	
	private String shoeName;
	private String shoeColour;

	//----------------------------------------------------------------------------------------
	/**
	 * Constructor with input parameters for all attributes, including inherited attributes.
	 * @param shoeName A String
	 * @param shoeColour A String
	 * @param productCode An Integer
	 * @param productPrice A Double
	 * 
	 * */
	public Shoes(String shoeName, String shoeColour, 
					Integer productCode, Double productPrice) {
		this.shoeName = shoeName;
		this.shoeColour = shoeColour;
		this.productCode = productCode;
		this.productPrice = productPrice;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the name of the shoes.
	 * @return a String
	 * 
	 * */
	public String getShoeName() {
		return this.shoeName;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the name of the shoes.
	 * @param shoeName A String
	 * 
	 * */
	public void setClothingName(String shoeName) {
		this.shoeName = shoeName;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the colour of the shoes.
	 * @return a String
	 * 
	 * */
	public String getShoeColour() {
		return this.shoeColour;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the colour of the shoes.
	 * @param shoeColour A String
	 * 
	 * */
	public void setShoeColour(String shoeColour) {
		this.shoeColour = shoeColour;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a String representation of the Shoes.
	 * @return a String
	 * 
	 * */
	public String toString() {
		return "Shoes: "+this.shoeName+" in "+this.shoeColour
				+" ("+this.productCode+") - Price: $"+String.format("%.2f", this.productPrice);
	}
}
