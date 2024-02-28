import java.util.*;


public class HW7 {
	public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int startTime = interval[0];

            if (!minHeap.isEmpty() && minHeap.peek() <= startTime) {
                minHeap.poll();
            }

            minHeap.offer(interval[1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {

        int[][] intervals1 = {{0, 30}, {10, 15}, {15, 45}};
        System.out.println(minMeetingRooms(intervals1)); 

        int[][] intervals2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(minMeetingRooms(intervals2));
    }
}
