package Algorithm.Backtrack_Method;

public class maze {
    private int[][] maze; // �Թ���ͼ
    private int[][] solution; // �������
    private int startRow, startCol; // ���
    private int endRow, endCol; // �յ�
    private int numRows, numCols; // �Թ�������������

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
        // ��ʼ�������������
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                solution[i][j] = 0;
            }
        }

        // ���Դ���㿪ʼ����Թ�
        if (solveHelper(startRow, startCol)) {
            // ����ҵ���һ��ͨ·������������
            printSolution();
            return true;
        } else {
            // ����޷��ҵ�ͨ·������޽���Ϣ
            System.out.println("No solution exists!");
            return false;
        }
    }

    private boolean solveHelper(int row, int col) {
        // �жϵ�ǰλ���Ƿ����յ�
        if (row == endRow && col == endCol) {
            solution[row][col] = 1;
            return true;
        }

        // �жϵ�ǰλ���Ƿ��ǺϷ�λ��
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || maze[row][col] == 0 || solution[row][col] == 1) {
            return false;
        }

        // ����ǰλ�ñ��Ϊ�ѷ���
        solution[row][col] = 1;

        // ���Դӵ�ǰλ�����ϡ��¡������ĸ�������һ��
        if (solveHelper(row - 1, col) || solveHelper(row + 1, col) || solveHelper(row, col - 1) || solveHelper(row, col + 1)) {
            return true;
        } else {
            // ����ĸ������޷���ͨ������ݵ���һ��λ��
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
