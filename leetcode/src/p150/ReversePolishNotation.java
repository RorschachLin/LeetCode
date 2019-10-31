package p150;

import java.util.Stack;

public class ReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (tokens[i].equals("-")) {
				stack.push(-stack.pop() + stack.pop());
			} else if (tokens[i].equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (tokens[i].equals("/")) {
				int divider = stack.pop();
				stack.push(stack.pop() / divider);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.peek();
	}
	
	public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(new ReversePolishNotation().evalRPN(tokens));
	}

}
