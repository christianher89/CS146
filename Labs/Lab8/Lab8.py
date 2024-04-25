from typing import List

class Lab8:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        
        for i in range(1, amount + 1):
            for coin in coins:
                if i - coin >= 0 and dp[i - coin] != float('inf'):
                    dp[i] = min(dp[i], 1 + dp[i - coin])
        
        return dp[amount] if dp[amount] != float('inf') else -1

run = Lab8()

coins1 = [1,2,5]
amount1 = 11
print(run.coinChange(coins1, amount1))

coins2 = [1,3,4]
amount2 = 6
print(run.coinChange(coins2, amount2))

coins3 = [1]
amount3 = 0
print(run.coinChange(coins3, amount3))

coins4 = [2]
amount4 = 3
print(run.coinChange(coins4, amount4))
