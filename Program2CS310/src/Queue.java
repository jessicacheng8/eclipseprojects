/*
 * Jessica Cheng
 * Section 1
 * CS 310
 * Program 2
 */

import java.util.ArrayList;
import java.util.List;

public class Queue {

	private static int size = 0;

	protected List<Integer> codes = new ArrayList<>();


	protected boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	protected void loadValue(int val) {
		codes.add(val);
		size++;

	}

	protected int nextValue() {
		if (!codes.isEmpty()) {
			codes.remove(0);	
		}
		
		return -1;

	}

	protected void normalize() {
		int val = codes.get(0);

		for (int i = 0; i < codes.size(); i++) {
			codes.set(i, codes.get(i) - val);
		}
		

	}

	protected int[] peek(int num) {		
		int[] peekVal = new int[6];
		
		for(int i = 0; i < num; i++) {
			peekVal[i] = codes.get(i);
		}
		
		
		return peekVal;

	}

	protected int size() {
		return size;
	}

	



}
