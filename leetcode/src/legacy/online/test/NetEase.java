package legacy.online.test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NetEase {
	
	public static int strToInt(char c){	
		
		return (int)c-96;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String no = sc.nextLine();
        int lineNum = Integer.parseInt(no);
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < lineNum; i++) {
			String line = sc.nextLine();
			sb.append(line);
		}
        if (sb == null || sb.length() == 0) {
			System.out.println(0);
		}
        int len = sb.length();
        
//        if (sb.length() == 1) {
//			System.out.println(strToInt(sb.charAt(0)));
//		}
        int res = 0;
        for (int i = 0; i < len; i++) {
//			for (int j = 26-i; j >=26-len+2-len+i+2; j--) {
//				res = res + j*(strToInt(sb.charAt(i))-i);
//			}
        		int ratio = 1;
        		for (int j = 26-len+2; j <= 26-i; j++) {
        				ratio *= j;
				}
        		res = res + ratio * (strToInt(sb.charAt(i))-i);
		}
        //res = res+strToInt(sb.charAt(len-1))-len+1;
        System.out.println(res);
        
        Set<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(10);
        
        Object[] resSet = set.toArray();
        System.out.println(resSet[1]);
	}
}
