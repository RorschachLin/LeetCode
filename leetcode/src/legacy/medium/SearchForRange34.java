package legacy.medium;


public class SearchForRange34 {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		
		int left = 0, right = nums.length - 1;
		while(left < right){
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		res[0] = right;
		
		left = 0; right = nums.length - 1;
		while(left < right){
			//让mid的数值偏向右边
			int mid = (left + right) / 2 + 1;
			if (nums[mid] > target) {
				//System.out.println(mid);
				right = mid - 1;
			}else {
				//System.out.println(mid);
				left = mid;
			}
		}
		res[1] = left;
		if (nums[res[0]] != target || nums[res[1]] != target) {
			res[0] = -1;
			res[1] = -1;
		}
		return res;
	}

	public static void main(String[] args){
		SearchForRange34 sfr34 = new SearchForRange34();
		
		int[] test1 = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] res = sfr34.searchRange(test1, target);
		for(int i=0; i<res.length; i++){
			System.out.println(res[i]);
		}
	}
}
