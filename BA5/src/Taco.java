/**
 * Taco class
 * Jessica Cheng 
 * CS 108
 */
public class Taco {

	private String type;
	private int ounces;
	private double price;
	
	

	/**
	 * @param type
	 * @param ounces
	 * @param price
	 */
	public Taco(String type, int ounces, double price) {
		super();
		this.type = type;
		this.ounces = ounces;
		this.price = price;
	}
	
	/**
	 * @return the ounces
	 */
	public int getOunces() {
		return ounces;
	}
	/**
	 * @param ounces the ounces to set
	 */
	public void setOunces(int ounces) {
		this.ounces = ounces;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
}