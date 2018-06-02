package nodes;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public void printNode(){
		ListNode current = this;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}
}
