package legacy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import legacy.nodes.TreeNode;


public class PostorderTraversal145 {
	
	
	
	public List<Integer> postOrderStack(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> s = new Stack<TreeNode>();
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

		PostorderTraversal145 bt145 = new PostorderTraversal145();
		List<Integer> temp = new ArrayList<>();
		List<Integer> res = bt145.postOrderStack(aNode);
		for (Integer integer : res) {
			System.out.println(integer);
		}
	}
}
