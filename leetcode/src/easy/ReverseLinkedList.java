package easy;


import nodes.ListNode;

public class ReverseLinkedList {
	public ListNode reverseListIterate(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;	//设置next指向原当前节点的下一个
	        head.next = newHead; 	//当前节点指向新head
	        newHead = head;		//当前节点成为新的head
	        head = next;		//当前节点向后移，变成新的当前节点，如果为空，跳出循环
		}
		return newHead;
	}
	
	public ListNode reverseListRecursion(ListNode head) {
		return recursion(head, null);
	}
	
	public ListNode recursion(ListNode head, ListNode newHead){
		if (head == null) {
			return newHead;
		}
		ListNode next = head.next;
		head.next = newHead;
		newHead = head;
		return recursion(next, newHead);
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		a.next = b;
		b.next = c; 
		c.next = d;
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		ListNode newHead = reverseLinkedList.reverseListRecursion(a);
		ListNode current = newHead;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}
}
