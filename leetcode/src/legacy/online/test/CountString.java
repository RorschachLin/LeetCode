package legacy.online.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountString {
	public String transfer(String tar) {
		StringBuffer res = new StringBuffer();
		int counter = 1;
		for (int i = 0; i < tar.length(); i++) {
			if (i == tar.length() - 1) {
				res.append(String.valueOf(counter));
				res.append(tar.charAt(i));
				continue;
			}
			if (tar.charAt(i) == tar.charAt(i + 1)) {
				counter++;
			} else {
				res.append(String.valueOf(counter));
				res.append(tar.charAt(i));
				counter = 1;
			}
		}

		return res.toString();
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String target = sc.nextLine();
		CountString m = new CountString();
		String tar = "AAAABCCDAA";
		String res = m.transfer(tar);
		System.out.printf(res + "\n");
		int[] arr = {1,2,9};
		List<int[]> sList = new ArrayList<>();
		sList.add(arr);
		for (int[] is : sList) {
			for (int i : is) {
				System.out.println(i);
			}
		}
	}
}
