package com.tree;

import java.util.Stack;

import nodes.TreeNode;

public class TreeTraversal {
	public static void postOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		TreeNode lastVisit = root;
		while(!stack.isEmpty() || node != null) {
			while(node != null) {
				stack.push(node);
				node = node.left;
				
			}
//			for(TreeNode tn : stack) {
//				System.out.println(tn.val);
//			}
//			System.out.println("---------------");
			node = stack.peek();
			if(node.right == null || node.right == lastVisit) {
				System.out.print(node.val + " ");
				stack.pop();
				lastVisit = node; 
				node = null;
			} else {
				node = node.right;
			}
		}
	}
}
