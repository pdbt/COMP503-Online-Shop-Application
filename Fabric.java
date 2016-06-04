/**
 * Fabric --- concrete subclass of Product with attributes for fabric type and metre length.
 * @author Patricia Danielle Tan
 * 
 * */
public class Fabric extends Product {

	private String fabricType;
	private int fabricMetres;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Constructor with input parameters for all attributes, including inherited attributes.
	 * @param fabricType A String
	 * @param fabricMetres An int
	 * @param productCode An Integer
	 * @param productPrice A Double
	 * 
	 * */
	public Fabric(String fabricType, int fabricMetres,
				  Integer productCode, Double productPrice) {
		this.fabricType = fabricType;
		this.fabricMetres = fabricMetres;
		this.productCode = productCode;
		this.productPrice = productPrice;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the fabric type.
	 * @return a String
	 * 
	 * */
	public String getFabricType() {
		return fabricType;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the fabric type.
	 * @param fabricType A String
	 * 
	 * */
	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the metre length of the fabric.
	 * @return an int
	 * 
	 * */
	public int getFabricMetres() {
		return fabricMetres;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the metre length of the fabric.
	 * @param fabricMetres An int
	 * 
	 * */
	public void setFabricMetres(int fabricMetres) {
		this.fabricMetres = fabricMetres;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a String representation of the Fabric.
	 * @return a String
	 * 
	 * */
	public String toString() {
		return "Fabric: "+this.fabricType+" "+this.fabricMetres+"m"
				+" ("+this.productCode+") - Price: $"+String.format("%.2f", this.productPrice);
	}
}
