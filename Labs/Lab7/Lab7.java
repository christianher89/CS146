import java.util.Arrays;

public class Lab7 {

	
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] distances = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE / 2);
			distances[i][i] = 0;
		}
		
		
		for (int[] edge: edges) {
			int fromCity = edge[0];
			int toCity = edge[1];
			int weight = edge[2];
			distances[fromCity][toCity] = weight;
			distances[toCity][fromCity] = weight;
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++){
				for(int j = 0; j < n; j++) {
					distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
				}
			}
		}
		
		int minReachableCities = Integer.MAX_VALUE;
		int result = -1;
		
		for(int i = 0; i < n; i++) {
			int reachableCities = 0;
			for(int j = 0; j < n; j++) {
				if(distances[i][j] <= distanceThreshold) {
					reachableCities++;
				}
			}
			if(reachableCities <= minReachableCities) {
				minReachableCities = reachableCities;
				result = Math.max(result,  i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Lab7 run = new Lab7();
		
		int n = 4;
		int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		int distanceThreshold = 4;
		System.out.println(run.findTheCity(n, edges, distanceThreshold));
		
		int n2 = 5;
		int[][] edges2 = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
		int distanceThreshold2 = 2;
		System.out.println(run.findTheCity(n2, edges2, distanceThreshold2));
	}
}
