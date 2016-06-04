/**
 * Album --- concrete subclass of Product with attributes for title and artist.
 * @author Patricia Danielle Tan
 * 
 * */
public class Album extends Product {
	
	private String albumTitle;
	private String albumArtist;
	
	//----------------------------------------------------------------------------------------
	/**
	 * Constructor with input parameters for all attributes, including inherited attributes.
	 * @param albumTitle A String
	 * @param albumArtist A String
	 * @param productCode An Integer
	 * @param productPrice A Double
	 * 
	 * */
	public Album(String albumTitle, String albumArtist,
				Integer productCode, Double productPrice) {
		this.albumTitle = albumTitle;
		this.albumArtist = albumArtist;
		this.productCode = productCode;
		this.productPrice = productPrice;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the album title.
	 * @return a String
	 * 
	 * */
	public String getAlbumTitle() {
		return this.albumTitle;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the album title.
	 * @param albumTitle A String
	 * 
	 * */
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Gets the album artist.
	 * @return a String
	 * 
	 * */
	public String getAlbumArtist() {
		return this.albumArtist;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Sets the album artist.
	 * @param albumArtist A String
	 * 
	 * */
	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}
	//----------------------------------------------------------------------------------------
	/**
	 * Returns a String representation of the Album.
	 * @return a String
	 * 
	 * */
	public String toString() {
		return "Album: \""+this.albumTitle+"\" by "+this.albumArtist
				+" ("+this.productCode+") - Price: $"+String.format("%.2f", this.productPrice);
	}
}
