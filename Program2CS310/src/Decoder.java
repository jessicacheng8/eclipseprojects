
/*
 * Jessica Cheng
 * Section 1
 * CS 310
 * Program 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Decoder extends Queue {

	/*
	 * checks to see if key (pattern) matches with the arraylist value adds the
	 * weapon code to the finalCSV list if there is a match
	 */
	public List<Integer> SoftwareDecoder(Map<List<Integer>, Integer> weaponCode, Queue qVal) {
		List<Integer> finalCSV = new ArrayList<>();
		Queue val = new Queue();
		int count = 0;

		int i = 0;
		while (i < qVal.codes.size()) {
			if (!qVal.isEmpty()) {
				
				/*
				 * inserts the next 6 values into an arraylist
				 * if the number of values is divisble by six 
				 */
				if (val.codes.size() == 0 && (qVal.codes.size() % 6 == 0)) {
					int[] arr = qVal.peek(6);
					for (int j = 0; j < arr.length; j++) {
						val.codes.add(arr[j]);
					}

				} else if (qVal.codes.size() % 6 != 0) {
					val.codes = qVal.codes;
				}

				if (weaponCode.containsKey(val.codes)) {
					finalCSV.add((Integer) (weaponCode.get(val.codes)));

					for (int l = 0; l < 6; l++) {
						qVal.nextValue();
					}
					val.codes.clear();

				}

				else {
					if (val.codes.get(0) != 0) {
						val.normalize();
					}

					if (val.codes.get(1) < 19) {
						val.nextValue();
					}

					/*
					 * checks for noise values
					 * noise values when there are more than six values 
					 */
					else if (val.codes.size() > 6) {
						for (int k = 0; k < val.codes.size() - 1; k++) {
							if (val.codes.get(k) % 10 != 0) {
								count++;
							}

							if (count > 1) {
								return finalCSV;
							}
							if (count == 1) {
								val.codes.remove(k);
							}
						}
					}

				}

				i++;

			}
		}

		return finalCSV;

	}

}
