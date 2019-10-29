package p20;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		HashMap<Character, Character> parentheseMap = new HashMap<>();
		parentheseMap.put(')', '(');
		parentheseMap.put(']', '[');
		parentheseMap.put('}', '{');
		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (parentheseMap.containsKey(c)) {
				if (stack.isEmpty()) return false;
				if (stack.pop() != parentheseMap.get(c)) return false;
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "{}[{]()";
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid(s));
	}

}
