package Algorithm.Backtrack_Method;

public class maze {
    private int[][] maze; // 迷宫地图
    private int[][] solution; // 解决方案
    private int startRow, startCol; // 起点
    private int endRow, endCol; // 终点
    private int numRows, numCols; // 迷宫的行数和列数

    public maze(int[][] maze, int startRow, int startCol, int endRow, int endCol) {
        this.maze = maze;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
        this.numRows = maze.length;
        this.numCols = maze[0].length;
        this.solution = new int[numRows][numCols];
    }

    public boolean solve() {
        // 初始化解决方案矩阵
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                solution[i][j] = 0;
            }
        }

        // 尝试从起点开始解决迷宫
        if (solveHelper(startRow, startCol)) {
            // 如果找到了一条通路，输出解决方案
            printSolution();
            return true;
        } else {
            // 如果无法找到通路，输出无解信息
            System.out.println("No solution exists!");
            return false;
        }
    }

    private boolean solveHelper(int row, int col) {
        // 判断当前位置是否是终点
        if (row == endRow && col == endCol) {
            solution[row][col] = 1;
            return true;
        }

        // 判断当前位置是否是合法位置
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || maze[row][col] == 0 || solution[row][col] == 1) {
            return false;
        }

        // 将当前位置标记为已访问
        solution[row][col] = 1;

        // 尝试从当前位置向上、下、左、右四个方向走一步
        if (solveHelper(row - 1, col) || solveHelper(row + 1, col) || solveHelper(row, col - 1) || solveHelper(row, col + 1)) {
            return true;
        } else {
            // 如果四个方向都无法走通，则回溯到上一个位置
            solution[row][col] = 0;
            return false;
        }
    }

    private void printSolution() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 0, 2},
                {2, 0, 0, 2, 0, 2, 2},
                {2, 2, 0, 2, 0, 2, 2},
                {2, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2}
        };
        Algorithm.Backtrack_Method.maze solver = new maze(maze, 1, 0, 3, 4);
        solver.solve();
    }
}
