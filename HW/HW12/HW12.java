import java.util.*;

public class HW12 {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[][] nums = Arrays.copyOf(pipes, pipes.length + n);
        for (int i = 0; i < n; i++) {
        	int[] newRow = {0, i+1, wells[i]};
            nums[pipes.length + i] = newRow;
        }
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int totalCost = 0;
        for (var pipe : nums) {
            int house1 = pipe[0], house2 = pipe[1], cost = pipe[2];
            int root1 = find(house1), root2 = find(house2);
            if (root1 != root2) {
                parent[root1] = root2;
                totalCost += cost;
                if (n-- == 0) {
                    return totalCost;
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        HW12 run = new HW12();

        int n1 = 3;
        int[] wells1 = {1, 2, 2};
        int[][] pipes1 = {{1, 2, 1}, {2, 3, 1}};
        System.out.println(run.minCostToSupplyWater(n1, wells1, pipes1));

        int n2 = 2;
        int[] wells2 = {1, 1};
        int[][] pipes2 = {{1, 2, 1}, {1, 2, 2}};
        System.out.println(run.minCostToSupplyWater(n2, wells2, pipes2));
    }
}
