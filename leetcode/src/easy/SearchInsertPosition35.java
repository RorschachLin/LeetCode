package easy;


public class SearchInsertPosition35 {
	//二分查找
	public int searchInsert(int[] nums, int target) {
		
		int left = 0, right = nums.length-1;
		while(left <= right){
			int mid = (left + right)/2;
			if (nums[mid] == target) {
				return mid;
			}else if (nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		String s1 = "ssg";
		String s2 = s1;
		System.out.println(s1);
		int[] a = { 1, 3, 5, 6 };
		int target = 0;
		SearchInsertPosition35 sip35 = new SearchInsertPosition35();
		int index = sip35.searchInsert(a, target);
		System.out.println(index);
	}
}
