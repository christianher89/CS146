import java.util.*;

public class HW11 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        if (originalColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor) {
            return;
        }
        image[row][col] = newColor;

        dfs(image, row + 1, col, originalColor, newColor);
        dfs(image, row - 1, col, originalColor, newColor);
        dfs(image, row, col + 1, originalColor, newColor);
        dfs(image, row, col - 1, originalColor, newColor);
    }

    public static void main(String[] args) {
        HW11 solution = new HW11();

        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr1 = 1, sc1 = 1, newColor1 = 2;
        solution.printImage(solution.floodFill(image1, sr1, sc1, newColor1));

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0, sc2 = 0, newColor2 = 0;
        solution.printImage(solution.floodFill(image2, sr2, sc2, newColor2));
    }

    private void printImage(int[][] image) {
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
