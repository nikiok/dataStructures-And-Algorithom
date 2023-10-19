package Algorithm.Backtrack_Method;

public class horse {
    private static final int BOARD_SIZE = 8;
    private static final int[][] MOVES = {
            {2, -1}, {2, 1}, {-2, -1}, {-2, 1},
            {1, -2}, {1, 2}, {-1, -2}, {-1, 2}
    };

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        int startX = 0, startY = 0, endX = 7, endY = 7;

        if (solve(board, startX, startY, endX, endY)) {
            printSolution(board);
        } else {
            System.out.println("No solution found");
        }
    }

    public static boolean solve(int[][] board, int x, int y, int endX, int endY) {
        if (x == endX && y == endY) {
            return true;
        }

        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE || board[x][y] != 0) {
            return false;
        }

        board[x][y] = 1;

        for (int[] move : MOVES) {
            int nextX = x + move[0];
            int nextY = y + move[1];

            if (solve(board, nextX, nextY, endX, endY)) {
                return true;
            }
        }

        board[x][y] = 0;
        return false;
    }

    public static void printSolution(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
