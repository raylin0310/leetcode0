
/**
 * _026_RemoveDuplicatesfromSortedArray
 * @author lilin
 * @date 2020-3-5 13:35
 */
public class _026_RemoveDuplicatesfromSortedArray {
/*
	Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

	Example 1:

	Given nums = [1,1,2],

	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

	It doesn't matter what you leave beyond the returned length.
	Example 2:

	Given nums = [0,0,1,1,1,2,2,3,3,4],

	Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

	It doesn't matter what values are set beyond the returned length.

*/
	//int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
	//int[] nums = {0, 0, 1, 2, 3, 4, 5};

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// j表示下一步将要放置的index，也就是新数组的长度
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[j - 1] != nums[i]) {
				nums[j++] = nums[i];
			}
		}
		return j;
	}

	public static void main(String[] args) {
		//int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int[] nums = {1, 2};
		int n = new _026_RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
		System.out.println("n: " + n);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}
