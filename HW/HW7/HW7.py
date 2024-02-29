import heapq
from typing import List

class MeetingRooms:
    def get_start_time(self, interval):
        return interval[0]

    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=self.get_start_time)
        min_heap = []

        for interval in intervals:
            start_time = interval[0]

            if min_heap and min_heap[0] <= start_time:
                heapq.heappop(min_heap)

            heapq.heappush(min_heap, interval[1])

        return len(min_heap)

# Example usage
if __name__ == "__main__":
    solution = MeetingRooms()

    intervals1 = [[0, 30], [5, 10], [15, 20]]
    print(solution.minMeetingRooms(intervals1))  # Output: 2

    intervals2 = [[0, 1], [1, 2], [2, 3]]
    print(solution.minMeetingRooms(intervals2))  # Output: 1
