import java.util.*;


public class HW7 {
	static class compareStartTimes implements Comparator<int[]>{
		public int compare(int[] a, int[] b) {
			return a[0] - b[0];
		}
	}
	
	public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new compareStartTimes());

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

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals1)); 

        int[][] intervals2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(minMeetingRooms(intervals2));
    }
}
