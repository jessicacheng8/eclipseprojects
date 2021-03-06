
/*
 * Jessica Cheng
 * Section 1
 * CS 310
 * Program 2
 */

import java.io.*;
import java.util.*;

public class SoftwareDecoder {

	public static void main(String[] args) throws IOException {

		try {
			readCSV(args);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	/*
	 * reads CSV file pattern is in HashMap value is in List
	 */
	public static void readCSV(String[] args) throws IOException {
		Queue queueValue = new Queue();

		Decoder d = new Decoder();

		Map<List<Integer>, Integer> weaponCode = new HashMap<>();
		List<List<Integer>> records = new ArrayList<>();

		String pat = args[0];
		String val = args[1];

		if (val.isEmpty() || pat.isEmpty()) {
			outputCSV(d.SoftwareDecoder(weaponCode, queueValue));
		}

		Scanner readPattern = new Scanner(new File(pat));
		Scanner readValue = new Scanner(new File(val));
		Scanner numV;

		Scanner scanner = new Scanner(new File(pat));
		while (scanner.hasNextLine()) {
			Queue queuePattern = new Queue();
			Scanner reader = new Scanner(scanner.nextLine());
			reader.useDelimiter(",");

			while (reader.hasNext()) {
				queuePattern.loadValue(Integer.parseInt(reader.next()));
			}

			records.add(queuePattern.codes);
			reader.close();

		}

		for (int i = 0; i < records.size(); i++) {
			int c = records.get(i).get(6);
			records.get(i).remove(6);
			weaponCode.put(records.get(i), c);
		}

		while (readValue.hasNext()) {
			numV = new Scanner(readValue.nextLine()).useDelimiter(",");

			while (numV.hasNext()) {

				String v = numV.next();
				queueValue.loadValue(Integer.parseInt(v));
			}
		}

		readPattern.close();
		readValue.close();
		scanner.close();

		outputCSV(d.SoftwareDecoder(weaponCode, queueValue));

	}

	/*
	 * produces a CSV file
	 */
	private static void outputCSV(List<Integer> list) throws IOException {
		FileOutputStream csv = new FileOutputStream("weaponCodes.csv", true);
		PrintWriter pw = new PrintWriter(csv);

		for (int i = 0; i < list.size(); i++) {
			pw.print(list.get(i) + " ");
		}
		pw.println();

		pw.close();

	}

}
