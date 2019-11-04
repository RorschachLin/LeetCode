package p239;

import java.util.ArrayDeque;

public class SlidWinMax {

	// deque solution
	public int[] maxSlidingWindowDeque(int[] nums, int k) {
		int len = nums.length;
		if (len == 0)
			return new int[0];
		if (k == 1)
			return nums;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int[] result = new int[len - k + 1];
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		for (int i = k - 1; i < len; i++) {
			if (!deque.isEmpty() && deque.getFirst() <= i - k) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
				deque.removeLast();
			}
			for (int j : deque) {
				System.out.print(j + "|");
			}
			System.out.println();

			deque.addLast(i);
			result[i - k + 1] = nums[deque.getFirst()];
		}
		return result;
	}

	// dynamic programming solution
	public int[] maxSlidingWindowDP(int[] nums, int k) {
		int len = nums.length;
		if (len == 0)
			return new int[0];
		if (k == 1 || k == 0)
			return nums;
		int[] left = new int[len];
		int[] right = new int[len];
		right[len - 1] = nums[len - 1];
		left[0] = nums[0];
		for (int i = 1; i < len; i++) {
			// construct an array, which divide the array to k elements from the left. In
			// each block of the array, all the right elements is bigger than left ones
			if (i % k == 0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(left[i - 1], nums[i]);
			}

			// construct an array, which divide the array to k elements from the right. In
			// each block of the array, all the left elements is bigger than right ones
			int rightIndex = len - i - 1;
			if (0 == (rightIndex) % k) {
				right[rightIndex] = nums[rightIndex];
			} else {
				right[rightIndex] = Math.max(right[rightIndex + 1], nums[rightIndex]);
			}
		}

		int[] result = new int[len - k + 1];
		for (int head = 0; head < len - k + 1; head++) {
			int tail = head + k - 1;
			result[head] = Math.max(left[tail], right[head]);
		}

		return result;
	}
	


	public static void main(String[] args) {
//		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] nums = {1,3,1,2,0,5};
//		int[] nums = {};
		int[] result = new SlidWinMax().maxSlidingWindowDP(nums, 3);
		for (int i : result) {
			System.out.print(i + "-");
		}
	}
}
