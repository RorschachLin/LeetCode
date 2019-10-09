package legacy.online.test;

import java.util.Scanner;

public class StringFragment {
	
    public double count(String tar){
        if(tar == null) return 0;
        double nums = 1;
        double total = 0;
        double count = 1;
        for(int i=0; i<tar.length(); i++){
            if(tar.charAt(i) == tar.charAt(i+1)){
                count ++;
            }else{
                total = total + count;
                nums++;
                count = 1;
            }
        }
        
        double res = total/nums;
        return res;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String tar = input;
		if (tar == null)
			System.out.printf("0");
		double nums = 1;
		double total = tar.length();
//		double count = 1;
		for (int i = 0; i < tar.length(); i++) {
			if (i == tar.length() - 1) {
				break;
			}
			if (tar.charAt(i) == tar.charAt(i + 1)) {
//				count++;
			} else {
//				total = total + count;
				nums++;
//				count = 1;
			}
		}

		double res = total / nums;
		res = (double) Math.round(res * 100.0)/100.0;
		System.out.println(res);
	}
}
