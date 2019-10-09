package legacy.easy;

public class BuyAndSellStock121 {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int minPrice = prices[0];
		int maxProfit = 0;
		for (int i = 0; i < prices.length-1; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			maxProfit = Math.max(maxProfit, prices[i+1] - minPrice);
			
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BuyAndSellStock121 bAndSellStock121 = new BuyAndSellStock121();
		int[] prices = new int[]{2,1,4};
		int result = bAndSellStock121.maxProfit(prices);
		System.out.println(result);
	}

}
