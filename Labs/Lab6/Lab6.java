import java.util.Arrays;

public class Lab6 {
	
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		for(int i = 0; i < prerequisites.length; i++) {
			int[] list = {prerequisites[i][1], prerequisites[i][0]};
			for(int j = i + 1; j < prerequisites.length; j++) {
				if (Arrays.equals(list, prerequisites[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Lab6 run = new Lab6();
		int[][] prerequisites = {{1,0},{3,2},{1,2}};
		System.out.println(run.canFinish(2, prerequisites));
	}
}
