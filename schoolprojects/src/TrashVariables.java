/*
 * BA4 Jessica Cheng
 */

public class TrashVariables {

	final double AL_PRICE_PER_LB = 1.60;
	final double PLASTIC_PRICE_PER_LB = 0.58;
	final double GLASS_PRICE_PER_LB = 0.10;
	
	protected String name;
	protected String material;
	protected double weightInPounds;
	
	/**
	 * 
	 * @return price
	 */
	public double recycle() {
		double price = 0.0;
				
		return price;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name 
	 * name of the item
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * 
	 * @param material
	 * material of the item
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * 
	 * @return weightInPounds
	 */
	public double getWeightInPounds() {
		return weightInPounds;
	}

	/**
	 * 
	 * @param weightInPounds 
	 * weight of the item
	 */
	public void setWeightInPounds(double weightInPounds) {
		this.weightInPounds = weightInPounds;
	}
	
	
	
	
}
