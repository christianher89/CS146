import java.util.ArrayList;
import java.util.List;

public class Lab6 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.get(course).add(prerequisiteCourse);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(adjacencyList, i, visited, inStack)) {
                    return false;
                }
            }
        }
        

        return true;
    }
    
    
    private boolean hasCycle(List<List<Integer>> adjacencyList, int course, boolean[] visited, boolean[] inStack) {
        visited[course] = true;
        inStack[course] = true;
        
        for (int neighbor : adjacencyList.get(course)) {
            if (!visited[neighbor]) {
                if (hasCycle(adjacencyList, neighbor, visited, inStack)) {
                    return true;
                }
            } else if (inStack[neighbor]) {
                return true;
            }
        }
        
        inStack[course] = false;
        return false;
    }
    
    public static void main(String[] args) {
        Lab6 courseSchedule = new Lab6();
        
        int[][] prerequisites1 = {{1,0}};
        int[][] prerequisites2 = {{1,0},{0,1}};
        int[][] prerequisites3 = {{1,0},{2,3},{5,4}};
        
        System.out.println(courseSchedule.canFinish(2, prerequisites1));
        System.out.println(courseSchedule.canFinish(2, prerequisites2));
        System.out.println(courseSchedule.canFinish(6, prerequisites3));
    }
}
