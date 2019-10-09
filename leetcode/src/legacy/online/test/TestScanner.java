package legacy.online.test;

import java.util.*;

public class TestScanner {

	public static void main(String[] args){
        List<int[]> arrays = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int arrayNum = sc.nextInt();
        int[] arr;
        for(int i=0; i<arrayNum; i++){
            int arrayLen = sc.nextInt();
            arr = new int[arrayLen];
            for(int j=0; j<arrayLen; j++){
                arr[j] = sc.nextInt();
            }
            arrays.add(arr);
        }
        for(int[] a:arrays){
            for(int i:a){
                System.out.println(i);
            }
        }
        String tString = "ssssseef";
        String s = tString.substring(tString.length()-1);
        System.out.println(s);
    }
}
