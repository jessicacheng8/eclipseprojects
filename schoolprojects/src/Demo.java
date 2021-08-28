/*
 * BA4 Jessica Cheng
 */

/**
 *  a program where it creates a spreadsheet of 
 * items being recycled, its material, weight in pounds, and
 * total amount made from recycling
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList<TrashVariables> trash = new ArrayList<TrashVariables>();
		
		Cup c1 = new Cup("Mug", "glass", 1.0);
		Cup c2 = new Cup("Sippie Cup", "plastic", 0.50);
		Bottle b1 = new Bottle("Beer", "aluminum", 0.56);
		Bottle b2 = new Bottle("Coke", "glass", 0.75);
		Container c3 = new Container("Tupperware", "glass", 0.17);
		Container c4 = new Container("Cardboard Box", "paper", 0.04);
		
		trash.add(c1);
		trash.add(c2);
		trash.add(b1);
		trash.add(b2);
		trash.add(c3);
		trash.add(c4);
		
		try {
			createSpreadSheet(trash);
		}
		catch(FileNotFoundException f){
			System.out.println(f.getMessage());
		}
		
	}
	
	/**
	 * 
	 * @param trashList which is the list of items being recycled
	 * @throws FileNotFoundException if file does not exist
	 */

	public static void createSpreadSheet(ArrayList<TrashVariables> trashList) throws FileNotFoundException {
		
		PrintWriter trashSheet = new PrintWriter("recycle.csv");
		
		trashSheet.println("Item, Material, Weight, Recyclable Amount");
		
		for(TrashVariables t : trashList) {
			trashSheet.println(t.getName() + "," + t.getMaterial() + "," + t.getWeightInPounds() + "," + t.recycle());
		}
		
		trashSheet.println("TOTAL" + ",,,=SUM(D2:D7)");
		
	
		trashSheet.close();		
		
		System.out.println("file recycle.csv has been created");
	}

}
