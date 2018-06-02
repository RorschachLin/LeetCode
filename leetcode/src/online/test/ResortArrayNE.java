/**
 * 重排数列网易编程
 * https://www.nowcoder.com/questionTerminal/a461395335c946c5b409e79847796cd0
 */
package online.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResortArrayNE {
	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int arrayNum = sc.nextInt();
        int[] arr;
        for(int i=0; i<arrayNum; i++){
            int arrayLen = sc.nextInt();
            arr = new int[arrayLen];
            for(int j=0; j<arrayLen; j++){
                arr[j] = sc.nextInt();
            }
            list.add(arr);
        }
        
        //----input finish
        for (int[] tarArr : list) {
        		List<Integer> exact4 = new ArrayList<>();
        		
        		List<Integer> exact2 = new ArrayList<>();
        		List<Integer> evenNum = new ArrayList<>();
        		List<Integer> res = new ArrayList<>();
			for (int i = 0; i < tarArr.length; i++) {
				if (tarArr[i] % 4 == 0) {
					exact4.add(tarArr[i]);
				}else if (tarArr[i]%4 != 0 && tarArr[i]%2 == 0) {
					exact2.add(tarArr[i]);
				}else {
					evenNum.add(tarArr[i]);
				}
			}
			if (evenNum.size() > exact4.size()) {
				System.out.println("No");
			}else {
				System.out.println("Yes");
			}
		}
        
	}
}
