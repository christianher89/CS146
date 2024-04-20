from typing import List

class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        distances = [[float('inf')] * n for _ in range(n)]

        for i in range(n):
            distances[i][i] = 0

        for edge in edges:
            fromCity, toCity, weight = edge
            distances[fromCity][toCity] = weight
            distances[toCity][fromCity] = weight

        for k in range(n):
            for i in range(n):
                for j in range(n):
                    distances[i][j] = min(distances[i][j], distances[i][k] + distances[k][j])

        minReachableCities = float('inf')
        result = -1
        for i in range(n):
            reachableCities = sum(1 for j in range(n) if distances[i][j] <= distanceThreshold)
            if reachableCities <= minReachableCities:
                minReachableCities = reachableCities
                result = i
        
        return result

run = Solution()
n = 4
edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]]
distanceThreshold = 4
print(run.findTheCity(n, edges, distanceThreshold))

n2 = 5
edges2 = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]
distanceThreshold2 = 2
print(run.findTheCity(n2, edges2, distanceThreshold2))
