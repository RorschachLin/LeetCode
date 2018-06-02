package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import nodes.ListNode;

public class Add2Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode p = l1;
		ListNode q = l2;
		ListNode resultHead = new ListNode(0);
		ListNode curr = resultHead;
		while (p != null || q != null) {
			int x = 0;
            int y = 0;
            if(p != null){
                x = p.val;
                p = p.next;
            }
			if(q != null){
                y = q.val;
                q = q.next;
            }
			
			int sum = x + y + carry;

			if (sum >= 10) {
				carry = 1;
				curr.next = new ListNode(sum % 10);
			} else {
				carry = 0;
				curr.next = new ListNode(sum);
			}
			curr = curr.next;
		}
		if(carry == 1){
            curr.next = new ListNode(1);
        }

		return resultHead.next;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c; 
		ListNode z = new ListNode(5);
		ListNode y = new ListNode(6);
		ListNode x = new ListNode(4);
		z.next = y;
		y.next = x; 
		Add2Numbers add2Numbers = new Add2Numbers();
		ListNode current = add2Numbers.addTwoNumbers(a, z);
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}

		

	}
}
