import java.util.Random;

public class Board {
	Random CPU1 = new Random();
	private char[][] board;

	public Board() {
		board = new char[3][3];
		reset();
	}

	public void reset() {
		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++)
				board[r][c] = '-';
	}

	public String toString() {
		String result = "\n";
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++)
				result += board[row][column] + " ";
			result += "\n";
		}
		return result;
	}

	public boolean placeXorO(char player, int r, int c) {
		if (board[r - 1][c - 1] == '-') {
			board[r - 1][c - 1] = player;
			return true;
		} else
			return false;
	}

	public boolean full() {
		for (char[] board1 : board) {
			for (int j = 0; j < board1.length; j++) {
				if (board1[j] == '-') {
					return true;
				}
			}
		}
		return false;
	}

	public boolean winner() {
		return (row() || column() || diagonal());
	}

	private boolean row() {
		for (int i = 0; i < 3; i++) {
			if (check(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean column() {
		for (int i = 0; i < 3; i++) {
			if (check(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean diagonal() {
		return ((check(board[0][0], board[1][1], board[2][2]) == true)
				|| (check(board[0][2], board[1][1], board[2][0]) == true));
	}

	private boolean check(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	}

	public void CPUTurn(char computer, int row, int column) {
		if (board[row][column] == '-')
			board[row][column] = computer;
		else
			CPUTurn(computer, CPU1.nextInt(3), CPU1.nextInt(3));

	}
}