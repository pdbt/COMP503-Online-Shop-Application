/**
 * Instrument --- concrete subclass of Product with attributes for instrument brand and type.
 * @author Patricia Danielle Tan
 * 
 * */
public class Instrument extends Product {
	
	private String instrumentBrand;
	private String instrumentType;

	//----------------------------------------------------------------------------------------
	/**
	 * Constructor with input parameters for all attributes, including inherited attributes.
	 * @param instrumentBrand A String
	 * @param instrumentType A String
	 * @param productCode An Integer
	 * @param productPrice A Double
	 * 
	 * */
	public Instrument(String instrumentBrand, String instrumentType,
					  Integer productCode, Double productPrice) {
		this.instrumentBrand = instrumentBrand;
		this.instrumentType = instrumentType;
		this.productCode = productCode;
		this.productPrice = productPrice;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the instrument brand.
	 * @return a String
	 * 
	 * */
	public String getInstrumentBrand() {
		return instrumentBrand;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the instrument brand.
	 * @param instrumentBrand A String
	 * 
	 * */
	public void setInstrumentBrand(String instrumentBrand) {
		this.instrumentBrand = instrumentBrand;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the instrument type.
	 * @return a String
	 * 
	 * */
	public String getInstrumentType() {
		return instrumentType;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the instrument type.
	 * @param instrumentType A String
	 * 
	 * */
	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a String representation of the Instrument.
	 * @return a String
	 * 
	 * */
	public String toString() {
		return "Instrument: "+this.instrumentBrand+" "+this.instrumentType
				+" ("+this.productCode+") - Price: $"+String.format("%.2f", this.productPrice);
	}
}
