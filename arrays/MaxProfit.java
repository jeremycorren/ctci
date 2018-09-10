import java.lang.*;

/**
 * Determine max profit from flipping stock given sequence of stock prices
 */
public class MaxProfit {

	/**
	 * Compare all buy/sell price pairs
	 * Time: O(N^2)
	 */
	public static int maxProfitBruteForce(int[] prices) {
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				maxProfit = Math.max(prices[j] - prices[i], maxProfit);
			}
		}
		return maxProfit;
	}

	/**
	 * Greedy in one pass, keep track of min so far
	 * Time: O(N)
	 */
	public static int maxProfitGreedy(int[] prices) {
		int minPrice = prices[0];
		int maxProfit = 0;
		for (Integer price : prices) {
			minPrice = Math.min(price, minPrice);
			maxProfit = Math.max(price - minPrice, maxProfit);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		/**
		 * Sequence of stock prices since market open
		 */
		int[] prices = { 10, 7, 5, 8, 11, 9 };

		System.out.println(maxProfitBruteForce(prices));
		System.out.println(maxProfitGreedy(prices));
	}
}