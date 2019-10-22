package legacy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import nodes.TreeNode;;

public class TreeTraversals {

	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return ans;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			ans.add(cur.val);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			} 
		}
		return ans;
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return ans;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			ans.addFirst(cur.val);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			} 
		}
		return ans;
	}
	

	
	
	public List<Integer> postOrderStack(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		//map as a flag
		Map<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode temp = s.peek();
			if (temp.left != null && !map.containsKey(temp.left)) {
				temp = temp.left;
				while (temp != null) {
					if (map.containsKey(temp))
						break;
					else
						s.push(temp);
					temp = temp.left;
				}
				continue;
			}
			if (temp.right != null && !map.containsKey(temp.right)) {
				s.push(temp.right);
				continue;
			}
			TreeNode t = s.pop();
			map.put(t, true);
			//System.out.println(t.val);
			res.add(t.val);
		}
		return res;
	}

	public static void main(String[] args) {
		// tree 1
		TreeNode eNode = new TreeNode(6, null, null);
		TreeNode gNode = new TreeNode(7, null, null);
		TreeNode dNode = new TreeNode(4, null, eNode);
		TreeNode fNode = new TreeNode(5, gNode, null);
		TreeNode cNode = new TreeNode(3, null, null);
		TreeNode bNode = new TreeNode(2, dNode, fNode);
		TreeNode aNode = new TreeNode(1, bNode, cNode);

		// tree 2
		TreeNode c = new TreeNode(3, null, null);
		TreeNode b = new TreeNode(2, c, null);
		TreeNode a = new TreeNode(1, null, b);

		TreeTraversals tt = new TreeTraversals();
		List<Integer> temp = new ArrayList<>();
		List<Integer> res = tt.preorderTraversal(aNode);
		for (Integer integer : res) {
			System.out.println(integer);
		}
	}

}
