
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

	示例 1：
	
	输入：nums = [1,1,1,2,2,3]
	输出：5, nums = [1,1,2,2,3]
	解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
	示例 2：
	
	输入：nums = [0,0,1,1,1,1,2,3,3]
	输出：7, nums = [0,0,1,1,2,3,3]
	解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

	// {1,1,1,2,2,3};
	// {1,1,2,2,2,3};

	public static int removeDuplicates(int[] nums) {
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

	public static void main(String[] args) {
		//int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4};
		int[] nums = {1, 1, 1, 2, 2, 3};
		int n = removeDuplicates(nums);
		System.out.println("n: " + n);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}
