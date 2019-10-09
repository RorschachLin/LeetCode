package legacy.easy;

public class ReverseInteger7 {

	public int reverse(int x) {
		long res = 0;
		while(x != 0){
			res = res*10 + x%10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
			x = x/10;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		ReverseInteger7 ri7 = new ReverseInteger7();
		int target1 = 84695;
		int target2 = 0;
		int target3 = -91987345;
		int target4 = 1534236469;
		int res = ri7.reverse(target3);
		System.out.println(res);
	}
}
