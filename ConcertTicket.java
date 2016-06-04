/**
 * ConcertTicket --- concrete subclass of Product with attributes for concert name and restricted status.
 * @author Patricia Danielle Tan
 * 
 * */
public class ConcertTicket extends Product {
	
	private String concertName;
	private boolean restricted;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Constructor with input parameters for all attributes, including inherited attributes.
	 * @param concertName A String
	 * @param restricted A boolean
	 * @param productCode An Integer
	 * @param productPrice A Double
	 * 
	 * */
	public ConcertTicket(String concertName, boolean restricted,
						 Integer productCode, Double productPrice) {
		this.concertName = concertName;
		this.restricted = restricted;
		this.productCode = productCode;
		this.productPrice = productPrice;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the concert name.
	 * @return a String
	 * 
	 * */
	public String getConcertName() {
		return concertName;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the concert name.
	 * @param concertName A String
	 * 
	 * */
	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the concert's age restricted status.
	 * @return a boolean, true if age restricted and false otherwise
	 * 
	 * */
	public boolean isRestricted() {
		return this.restricted;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the concert's age restricted status.
	 * @param restricted A boolean
	 * 
	 * */
	public void setRestricted(boolean restricted) {
		this.restricted = restricted;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a String representation of the ConcertTicket.
	 * @return a String
	 * 
	 * */
	public String toString() {
		return "Concert Ticket: "+this.concertName+" R18: "+(this.restricted?"Yes":"No")
				+" ("+this.productCode+") - Price: $"+String.format("%.2f", this.productPrice);
	}
}
