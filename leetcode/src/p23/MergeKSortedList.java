package p23;

import nodes.ListNode;

public class MergeKSortedList {

	public ListNode merge2List(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode(-1);
		ListNode pre = preHead;
		while(l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				pre.next = l2;
				l2 = l2.next;
			}
			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			}
			pre = pre.next;
		}
		pre.next = l1 == null? l2 : l1;
		return preHead.next;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) return null;
		int k = lists.length;
		if (k == 1) return lists[0];
		int interval = 1;
		while (interval < k) {
			for (int i = 0; i < k - interval; i = i+ interval * 2) {
				lists[i] = merge2List(lists[i], lists[i + interval]);
			}
			interval *= 2;
		}
		return lists[0];
	}

	public static void main(String[] args) {
		
	}

}
