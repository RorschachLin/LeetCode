package p41;

public class FirsMissPositive {

	public static int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			// using while loop due to one swap may not be the one in correct place
			while (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
				swap(nums, nums[i] - 1, i);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
        return nums.length + 1;
    }
	
	// O(1) in space
	public static void swap(int[] nums, int index1, int index2) {
		if (index1 == index2) {
			return;
		}
		nums[index1] = nums[index1] ^ nums[index2];
		nums[index2] = nums[index1] ^ nums[index2];
		nums[index1] = nums[index1] ^ nums[index2];
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 3, 1, 4};
		
		int result = FirsMissPositive.firstMissingPositive(nums);
		System.out.println(result);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
