package com.tree;

import java.util.LinkedList;
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
	
	public static void levelTraversal(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.removeFirst();
			if(curr != null) {
				System.out.print(curr.val + " ");
				queue.addLast(curr.left);
				queue.addLast(curr.right);
			}
		}
	}
}
