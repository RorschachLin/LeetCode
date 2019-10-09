package legacy.online.test;

import java.util.*;

public class TraverseMagicCastle {

	static int n;
	static int[] parent;
	static int l;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		l = in.nextInt();
		parent = new int[n];
		in.nextLine();
		for (int i = 1; i < n; i++)
			parent[i] = in.nextInt();
		System.out.println(work());
	}

	public static int work() {
		ArrayList<Integer> route = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addFirst(0);
		int rl = 0;
		while (queue.size() > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int index = queue.removeLast();
				boolean flag = false;
				for (int j = 1; j <= n - 1; j++) {
					if (parent[j] == index) {
						queue.addFirst(j);
						flag = true;
					}
				}
				if (!flag)
					route.add(rl);
			}
			rl++;
		}
		Collections.sort(route);
		int d = Math.min(l, route.get(route.size() - 1));
		return Math.min(n, 1 + d + (l - d) / 2);
	}
}
