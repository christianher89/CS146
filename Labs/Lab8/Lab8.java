

public class Lab8 {
	
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		for(int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <= amount; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}
		
		if(dp[amount] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return dp[amount];
		}
	}
	
	public static void main(String[] args) {
		Lab8 run = new Lab8();
		
		int[] coins1 = {1,2,5};
		int amount1 = 11;
		System.out.println(run.coinChange(coins1, amount1));
		
		int[] coins2 = {1,3,4};
		int amount2 = 6;
		System.out.println(run.coinChange(coins2, amount2));
		
		int[] coins3 = {1};
		int amount3 = 0;
		System.out.println(run.coinChange(coins3, amount3));
		
		int[] coins4 = {2};
		int amount4 = 3;
		System.out.println(run.coinChange(coins4, amount4));
	}
}
