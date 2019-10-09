package legacy.medium;
/**
 * 最简便的方法是将0挪到数组左边，2挪到右边。
 * 这个类里面的方法是用冒泡排序实现
 * @author Bingxiong
 *
 */

public class SortColors75 {
	//2层循环冒泡排序
	public int[] sortColors(int[] nums){
		//int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length -1-i; j++) {
				if (nums[j] > nums[j+1]) {
//					int temp = nums[j];
//					nums[j] = nums[j+1];
//					nums[j+1] = temp;
					nums[j+1] = swap(nums[j], nums[j] = nums[j+1]);
				}
			}
		}
		
		return nums;
	}
	
	/**
	 * 调换数组里面2个数字
	 * @param a index of the array
	 * @param b index of the array
	 */
	public void swap(int[] nums, int a, int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	/**
	 * 调换2个数字 eg. a = getItself(b, b = a);
	 * @param itself
	 * @param dummy
	 * @return
	 */
	public int swap(int itself, int dummy){
		return itself;
	}
	
	
	public static void main(String[] args) {
		int[] test1 = {0,0,2,0,1,1,2,1,1,0,0,1,0,1,0,1,2,0};
		int[] test2 = {1,1,1,2,1,1,1,1,2,1,1,2,2};
		int[] test3 = {};
		int[] test4 = {1,2,3};
		SortColors75 sc75 = new SortColors75();
		int[] res = sc75.sortColors(test1);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
//		int a = 1; 
//		int b = 2;
//		sc75.swap(a, b);
//		System.out.println(b);
		
	}
}
