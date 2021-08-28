/*
 * BA5
 */

/**
 * TacoTuesday class
 * Jessica Cheng
 * CS 108
 */

import java.util.ArrayList;

public class TacoTuesday {

	public static void main(String[] args) {

		ArrayList<Taco> tacoPlatter = new ArrayList<Taco>();
		
		tacoPlatter.add(new Taco("Shrimp", 10, 2.99)); 				
		tacoPlatter.add(new Taco("Mahi-Mahi", 12, 3.99));			
		tacoPlatter.add(new Taco("Carne Asada", 11, 2.49));   		
		tacoPlatter.add(new Taco("Chicken", 14, 2.19));				
		tacoPlatter.add(new Taco("Vegan", 4, 8.99));				
		tacoPlatter.add(new Taco("Fish", 10, 2.99));				
		tacoPlatter.add(new Taco("Calamari", 13, 3.49));			
		
		insertionSort(tacoPlatter);
		System.out.println("Index: " + binarySearch(tacoPlatter, 3.99));
		eatTaco(tacoPlatter.get(5));
	}
	
	/*
	 * I chose an insertion sort method because there is only a small amount of data 
	 * that needs to be sorted and is most likely faster through using an insertion sort.
	 */
	
	/**
	 * 
	 * @param tacoDish
	 */
	public static void insertionSort(ArrayList<Taco> tacoDish) {
		
		for (int i = 1; i < tacoDish.size(); i++) {	
			Taco searchValue = tacoDish.get(i);
			int t = i;
			
			while (t > 0 && searchValue.getPrice() < tacoDish.get(t - 1).getPrice()) {
				tacoDish.set(t, tacoDish.get(t - 1));
				t--;
			}
			
			tacoDish.set(t, searchValue);
		}
		
	}
	
	/**
	 * 
	 * @param findTaco
	 * @param target
	 * @return
	 */
	public static int binarySearch(ArrayList<Taco> findTaco, double target) {
			
			int low = 0;
			int high = findTaco.size() - 1;
			int middle = 0;
			
			while (low <= high) {
				
				middle = (low + high) / 2;
				
				if (findTaco.get(middle).getPrice() == target) {
					return middle;
				}
			
				else if (target < findTaco.get(middle).getPrice()) {
					high = middle - 1;
				}
				else {
					low = middle + 1;
				}
				
			}
			
			return -1;	
			
	}
					
	
	/**
	 * 
	 * @param t
	 */
	public static void eatTaco(Taco t) {
		if (t.getOunces() == 0) { //base case
			System.out.println("Done.");
		}
		else { //recursive case
			int eat = t.getOunces() - 1;
			System.out.println("There are " + eat + " ounces of " + t.getType() + " tacos remaning.");
			t.setOunces(eat);
			eatTaco(t);

		}
		
	}
		
		
	
	
	


	
	
}