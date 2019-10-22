package legacy.medium;

import nodes.ListNode;

public class SortLinkedList148 {

	public ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;

		}
		prev.next = null;

		// 递归分解链表直到每个分解了的链表只有一个元素为止
		ListNode l1 = sort(head);
		ListNode l2 = sort(slow); 
		// 递归的同时按顺序合并每一个分解的链表元素
		ListNode h = merge(l1, l2);

		return h;
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0), tempHead = temp;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}

		while (l1 != null) {
			temp.next = l1;
			l1 = l1.next;
			temp = temp.next;
		}

		while (l2 != null) {
			temp.next = l2;
			l2 = l2.next;
			temp = temp.next;
		}

		return tempHead.next;
	}

	public static void main(String[] args) {
		// test cases
		long startTime = System.nanoTime();
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(99);
		ListNode c = new ListNode(23);
		ListNode d = new ListNode(43);
		ListNode e = new ListNode(9);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		SortLinkedList148 sortLinkedList148 = new SortLinkedList148();
		ListNode res = sortLinkedList148.sort(a);
		res.printNode();

		long endTime = System.nanoTime();
		long exeTime = endTime - startTime;
		System.out.println("executing time: " + exeTime);
	}
}
