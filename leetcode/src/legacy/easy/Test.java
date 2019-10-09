package legacy.easy;

public class Test {
	public int[] twoSum(int[] nums, int target) {
		
		return null;
	}
	private static int x=100;
	public static void main(String[] args) {
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 =Integer.valueOf(59);
		Integer i04 = new Integer(59);
		System.out.println(i01 == i02);
		System.out.println(i01 == i03);
		System.out.println(i03 == i04);
		System.out.println(i02 == i04);
		Test tSum = new Test();
		tSum.x++;
		Test tSum2 = new Test();
		tSum2.x--;
		Test.x--;
		System.out.println(x);
		
		System.out.println(4%10);
		
		
		double a = 1.0;
		double b = 1.00;
		if (a == b) {
			System.out.println("a = b!");
		}
	}
}
