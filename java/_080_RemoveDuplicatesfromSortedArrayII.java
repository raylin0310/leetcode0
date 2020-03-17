
/**
 * _080_RemoveDuplicatesfromSortedArrayII
 * @author lilin
 * @date 2020-3-5 14:28
 */
public class _080_RemoveDuplicatesfromSortedArrayII {
/*
	Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

	给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

	Example 1:

	Given nums = [1,1,1,2,2,3],

	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

	It doesn't matter what you leave beyond the returned length.
	Example 2:

	Given nums = [0,0,1,1,1,1,2,3,3],

	Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

	It doesn't matter what values are set beyond the returned length.
*/

	// {1,1,1,2,2,3};
	// {1,1,2,2,2,3};

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		// nextPutIndex表示下一步将要放置的index，也就是新数组的长度
		int nextPutIndex = 2;
		for (int i = 2; i < nums.length; i++) {
			if (nums[nextPutIndex - 2] != nums[i]) {
				nums[nextPutIndex++] = nums[i];
			}
			// 如果相等，nextPut指针不动，i继续向前走
		}
		return nextPutIndex;
	}

	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n > nums[i - 2]) {
				nums[i++] = n;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		//int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4};
		int[] nums = {1, 1, 1, 2, 2, 3};
		int n = new _080_RemoveDuplicatesfromSortedArrayII().removeDuplicates2(nums);
		System.out.println("n: " + n);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}
