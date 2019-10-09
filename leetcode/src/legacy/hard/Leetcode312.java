package legacy.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Leetcode312 {
	public Integer maxScore(Integer[] nums) {
		int numsLength = nums.length;
		int newNumsLength = numsLength +2;
		// construct a trimmed array, begin and end with 1;
		int[] newNums = new int[newNumsLength];
		for (int i = 0; i < numsLength; i++) {
			newNums[i + 1] = nums[i];
		}
		newNums[0] = newNums[newNumsLength - 1] = 1;
		// dp[left][right] stores the socre between left and right
		// Integer[][] does not work, all element will be null when init. While int[][] with all
		// 0
		int[][] dp = new int[newNumsLength][newNumsLength];
		//gap：left和right之间的间隙
		for (int gap = 2; gap < newNumsLength; gap++) {
			for (int left = 0; left + gap < newNumsLength; left++) {
				int right = left + gap;
				//遍历所有left和right之间的（i）
				for (int i = left + 1; i < right; i++) {
					//dp[left][right]记录left和right之间可以有的最大分数
					dp[left][right] = Math.max(dp[left][right],
							newNums[left] * newNums[i] * newNums[right] + dp[left][i] + dp[i][right]);
				}
			}
		}
		return dp[0][newNumsLength-1];
	}

	public List<Integer[]> splitArrayBy0(Integer[] nums, Integer[] delimiter) {
		List<Integer[]> splitedArrays = new ArrayList<>();
		if (delimiter.length == 0 || delimiter == null) {
			splitedArrays.add(nums);
			return splitedArrays;
		}
		Integer begin = 0;
		outer:
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < delimiter.length; j++) {
				if (nums[i+j]!=delimiter[j]) {
					continue outer;
				}
			}
			Integer[] splitedArray = Arrays.copyOfRange(nums, begin, i);
			splitedArrays.add(splitedArray);
			begin = i + delimiter.length;
		}
		Integer[] lastSplit = Arrays.copyOfRange(nums, begin, nums.length);
		splitedArrays.add(lastSplit);
		return splitedArrays;
	}
	
	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getName());
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
		Leetcode312 lc = new Leetcode312();
		Integer[] delimiter = {0};
		List<Integer[]> test = lc.splitArrayBy0(nums, delimiter);
		Integer maxResult = 0;
		for (Integer[] integers : test) {
			if (integers.length == 0) {
				continue;
			}
			Integer r  = lc.maxScore(integers);
			maxResult = maxResult + r;
		}
		System.out.println(maxResult);
//		Integer[] testArray = {0,3,0,5,8,5,9,0,6,74};
		
//		System.out.println(test.toString());
	}
}
