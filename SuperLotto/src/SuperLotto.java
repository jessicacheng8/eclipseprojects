import java.util.Random;
import java.util.Scanner;

public class SuperLotto {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		String name;
		String doItAgain;
		int numTickets;

		do {
			System.out.println("Welcome to 11-Seven! What is your name?");
			name = scnr.next();

			System.out.println("Hello " + name + "! " + "How many Super Lotto tickets will you purchase today?");
			numTickets = scnr.nextInt();
			System.out.println();

			for (int i = 0; i < numTickets; i++) {
				quickPick();
				System.out.println();
			}

			System.out.println();

			System.out.println("Here are your numbers! Do you want to get more tickets? (Yes/No)");
			doItAgain = scnr.next().toLowerCase();
			System.out.println();

		} while (doItAgain.equals("yes"));

		System.out.println("Thanks for visiting 11-Seven!");

	}

	
	public static int[] quickPick() {
		Random generator = new Random();
		int[] lottoNums = new int[6];
		int megaNum;
		boolean check;

		do {
			for (int i = 0; i < lottoNums.length - 1; i++) {
				lottoNums[i] = generator.nextInt(70) + 1;
			}

			lottoNums[lottoNums.length - 1] = generator.nextInt(25) + 1;
			megaNum = lottoNums[lottoNums.length - 1];

			check = findDuplicate(lottoNums);

		} while (check == true);

		for (int i = 0; i < lottoNums.length - 1; i++) {
			System.out.print(lottoNums[i] + " ");
		}
		System.out.print("(MEGA: " + megaNum + ")");

		return lottoNums;

	}

	public static boolean findDuplicate(int[] findCopy) {
		boolean isCopy = false;

		for (int i = 0; i < findCopy.length - 1; i++) {
			for (int j = i + 1; j < findCopy.length - 1; j++) {
				if (findCopy[j] == findCopy[i]) {
					isCopy = true;
				}
			}
		}

		return isCopy;

	}

}

