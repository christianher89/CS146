from typing import List

class HW12:
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        nums = pipes + [[0, i + 1, wells[i]] for i in range(n)]
        self.parent = [i for i in range(n + 1)]
        total_cost = 0
        for pipe in nums:
            house1, house2, cost = pipe
            root1, root2 = self.find(house1), self.find(house2)
            if root1 != root2:
                self.parent[root1] = root2
                total_cost += cost
                n -= 1
                if n == 0:
                    return total_cost
        return total_cost

# Test cases
run = HW12()
n1 = 3
wells1 = [1, 2, 2]
pipes1 = [[1, 2, 1], [2, 3, 1]]
print(run.minCostToSupplyWater(n1, wells1, pipes1))

n2 = 2
wells2 = [1, 1]
pipes2 = [[1, 2, 1], [1, 2, 2]]
print(run.minCostToSupplyWater(n2, wells2, pipes2))
