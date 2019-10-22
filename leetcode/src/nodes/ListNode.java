package nodes;

/**
 * singly linked list
 * @author Bingxiong
 *
 */
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
	
	public String toString() {
		return this.val + "next node val=" + next.val;
	}
}
