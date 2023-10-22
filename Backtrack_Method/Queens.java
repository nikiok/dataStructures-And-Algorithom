package Algorithm.Backtrack_Method;

import java.util.*;

/**
 * ∞Àª ∫ÛŒ Ã‚
 */
public class Queens {
    private static final int BOARD_SIZE = 8; //∆Â≈Ã≥ﬂ¥Á

    public static void main(String[] args) {
        int[] queens = new int[BOARD_SIZE];
        Arrays.fill(queens, -1);

        if (solve(queens, 0)) {
            printSolution(queens);
        } else {
            System.out.println("No solution found");
        }
    }

    public static boolean solve(int[] queens, int row) {
        if (row == BOARD_SIZE) {
            return true;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                if (solve(queens, row + 1)) {
                    return true;
                }
            }
        }

        queens[row] = -1;
        return false;
    }

    public static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int otherCol = queens[i];
            if (col == otherCol) {
                return false;
            }
            int colDiff = Math.abs(col - otherCol);
            int rowDiff = row - i;
            if (colDiff == rowDiff) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution(int[] queens) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
