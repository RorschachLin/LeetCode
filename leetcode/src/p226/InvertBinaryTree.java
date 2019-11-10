package p226;

import java.util.LinkedList;
import java.util.Stack;

import com.tree.TreeTraversal;

import nodes.TreeNode;

public class InvertBinaryTree {

	// recursion solution
	public TreeNode invertTreeRecursion(TreeNode root) {

		return null;
	}

	public TreeNode invertTreeIterat(TreeNode root) {
		if (root == null)
			return null;
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.poll();
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;

			if (curr.left != null)
				nodes.add(curr.left);
			if (curr.right != null)
				nodes.add(curr.right);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		TreeTraversal.postOrderTraversal(root);
		TreeNode resultRoot = new InvertBinaryTree().invertTreeIterat(root);
		System.out.println();
		TreeTraversal.postOrderTraversal(resultRoot);
//		TreeTraversal.postOrderTraversal(root);
	}
}
