
/**
 * _026_RemoveDuplicatesfromSortedArray
 * @author lilin
 * @date 2020-3-5 13:35
 */
public class _026_RemoveDuplicatesfromSortedArray {
/*
	Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

	给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

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
		// nextPutIndex表示下一步将要放置的index，也就是新数组的长度
		int nextPutIndex = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[nextPutIndex - 1] != nums[i]) {
				nums[nextPutIndex++] = nums[i];
			}
			//如果相等，nextPutIndex指针不动，i继续向后走
		}
		return nextPutIndex;
	}

	public static void main(String[] args) {
		_026_RemoveDuplicatesfromSortedArray test = new _026_RemoveDuplicatesfromSortedArray();
		//int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int[] nums = {1, 2, 3};
		int n = test.removeDuplicates(nums);
		System.out.println("n: " + n);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}
