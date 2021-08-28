

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Board board = new Board();
		System.out.println(board);

		Random CPU1 = new Random();
		char player;
		char CPU;

		System.out.println("X or O");
		player = reader.next().toUpperCase().charAt(0);

		if (player == 'X')
			CPU = 'O';
		else
			CPU = 'X';

		while (!board.winner()) {
			System.out.println("\n" + player + "'s turn");
			System.out.println("Enter the row and column");

			int r = reader.nextInt();
			int c = reader.nextInt();

			boolean success = board.placeXorO(player, r, c);
			if (!success)
				System.out.println("ERROR! SPACE FULL!");
			else
				System.out.println(board);

			System.out.println("CPU's Turn. \n");
			board.CPUTurn(CPU, CPU1.nextInt(3), CPU1.nextInt(3));
			System.out.println(board);

		}

		if (board.winner())
			System.out.println("WE HAVE A WINNER");
		else
			System.out.println("DRAW");

	}

}
