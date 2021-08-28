/*
 * BA4 Jessica Cheng
 */

public class Cup extends TrashVariables implements Recyclable{
	
	protected String name;
	protected String material;
	protected double weightInPounds;
	
	/**
	 * 
	 * @param name
	 * @param material
	 * @param weightInPounds
	 */
	public Cup(String name, String material, double weightInPounds) {
		this.name = name;
		this.material = material;
		this.weightInPounds = weightInPounds;
	}
	
	public Cup() {
		this("unknown", "unknown", 0.0); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getWeightInPounds() {
		return weightInPounds;
	}

	public void setWeightInPounds(double weightInPounds) {
		this.weightInPounds = weightInPounds;
	}

	@Override
	public void reuse() {
		System.out.println("Yo save the tortles!");
		
	}

	@Override
	public double recycle() {
		double price = 0.0;
		
		if (material == "aluminum") {
			price = weightInPounds * AL_PRICE_PER_LB;
		}
		
		if (material == "glass") {
			price = weightInPounds * GLASS_PRICE_PER_LB;
		}
		if (material == "plastic") {
			price = weightInPounds * PLASTIC_PRICE_PER_LB;
		}
		
		return price;
	} 

}
