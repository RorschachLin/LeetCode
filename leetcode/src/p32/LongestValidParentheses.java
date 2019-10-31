package p32;

import java.util.Stack;

public class LongestValidParentheses {

	// dynamic programming solution. 
	public int longestValidParenthesesDP(String s) {
		int max = 0;
		int len = s.length();
		int[] dp = new int[len];

		for (int i = 1; i < len; i++) {
			if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
				dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
			}

			if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
				if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + 2;
					if (i - dp[i - 1] - 2 >= 0) {
						dp[i] += dp[i - dp[i - 1] - 2];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	// stack solution
	public int longestValidParenthesesStack(String s) {
		Stack<Integer> validStack = new Stack<Integer>();
		validStack.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				validStack.push(i);
			} else {
				validStack.pop();
				if (validStack.isEmpty())
					validStack.push(i);
				int len = i - validStack.peek();
				max = Math.max(len, max);
			}
		}
		return max;
	}

	// pointer solution
	public int longestValidParenthesesPointer(String s) {
		int len = s.length();
		// forward
		int left = 0;
		int right = 0;
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(')
				left++;
			if (s.charAt(i) == ')')
				right++;
			if (right > left) {
				left = 0;
				right = 0;
			}
			if (left == right) {
				max = Math.max(max, right * 2);
			}
		}

		// backward
		left = 0;
		right = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) == '(')
				left++;
			if (s.charAt(i) == ')')
				right++;
			if (right < left) {
				left = 0;
				right = 0;
			}
			if (left == right) {
				max = Math.max(max, left * 2);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String s = "(()())";
		System.out.println(new LongestValidParentheses().longestValidParenthesesDP(s));

	}

}
