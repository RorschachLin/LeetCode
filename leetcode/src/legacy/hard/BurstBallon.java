package legacy.hard;


import java.util.Scanner;

public class BurstBallon {
	public Integer maxCoins(Integer[] nums) {
		int n = nums.length + 2;
		Integer[] newNums = new Integer[n];
		for (int i = 0; i < n-2; i++) {
			newNums[i+1] = nums[i];
		}
		newNums[0] = 1;
		newNums[n-1] = 1;
		int[][] dp = new int[n][n];
		for (int k = 2; k < n; k++) {
			for (int l = 0; l + k < n; l++) {
				Integer h = l + k;
				for (int m = l + 1; m < h; m++) {
					dp[l][h] = Math.max(dp[l][h], newNums[l]*newNums[m]*newNums[h]+dp[l][m]+dp[m][h]);
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String targetNum = sc.nextLine();
		Integer targetNumInt = Integer.valueOf(targetNum); 
		Integer[] nums = new Integer[targetNumInt];
		for (int i = 0; i < targetNumInt; i++) {
			String num = sc.nextLine();
			Integer integer = Integer.valueOf(num);
			nums[i] = integer;
		}
		BurstBallon burstBallon = new BurstBallon();
		Integer maxResult = burstBallon.maxCoins(nums);
		System.out.println(maxResult);
		
	}
}
