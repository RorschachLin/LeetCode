package legacy.medium;

import legacy.nodes.ListNode;

public class InsertionSortList147 {

	public ListNode insertionSortList1(ListNode head) {
		ListNode newHead = new ListNode(0);
		if (head == null) {
			return null;
		}
		
		ListNode current = head;
		
		ListNode pre = newHead;
		while (current != null) {
			ListNode next = current.next;
			pre = newHead;
			while (pre.next != null && pre.next.val < current.val) {
				pre = pre.next;
			}
			current.next = pre.next;
			pre.next = current;
			
			current = next;
		}
		return newHead.next;
	}

	public ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(9);
		ListNode b = new ListNode(76);
		ListNode c = new ListNode(0);
		ListNode d = new ListNode(30);
		ListNode e = new ListNode(80);
		a.next = b;
		b.next = c; 
		c.next = d;
		d.next = e;
		InsertionSortList147 isl147 = new InsertionSortList147();
		ListNode head = a;
		ListNode newHead = isl147.insertionSortList1(head);
		ListNode current = newHead;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}
}
