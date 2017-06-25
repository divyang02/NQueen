package nQueen;

public class NQueen {
	
	private static boolean[][] board;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQ(4);
	}
	
	private static void solveNQ(int n) {
		board = new boolean[n][n];
		boolean check = backtrackQueen(0,n);
		if(check) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}
	
	private static boolean backtrackQueen(int row, int n) {
		if(row == n) return true;
		for(int i = 0; i < n; i++) {
			if(queenSafe(row,i,n)) {
				board[row][i] = true;
				if(row == n) {
					return true;
				}
				else {
					if(backtrackQueen(row+1,n)) return true;
					else board[row][i] = false;
				}
			}
		}
		return false;
	}
	
	private static boolean queenSafe(int row, int col, int n) {
		for(int i = 0; i < n; i++) {
			if(board[i][col]) return false;
		}
		int reset = Math.min(row, col);
		for(int i = row-reset , j = col-reset; i < row && j < col && j < n && i < n; i++, j++) {
			if(board[i][j]) return false;
		}
		for(int i = row-reset , j = col+reset ; i < row && j > col && j < n && i < n; i++, j--) {
			if(board[i][j]) return false;
		}
		return true;
	}

}
