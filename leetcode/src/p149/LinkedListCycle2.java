package p149;

import nodes.ListNode;

public class LinkedListCycle2 {
	
	public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
		
        while(true) {
        	if(fast == null || fast.next == null) return null;
        	
        	
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast) break;
        }
        slow = head;
        
        while(slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        	
        }
        
		return slow;
    }
	
	
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(5);
		ListNode g = new ListNode(6);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		
		g.next = c;
		
		System.out.println(new LinkedListCycle2().detectCycle(a).val);
		
		
	}

}
