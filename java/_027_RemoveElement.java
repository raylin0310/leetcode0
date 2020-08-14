
/**
 * _027_RemoveElement
 * @author lilin
 * @date 2020-3-5 11:22
 */
public class _027_RemoveElement {
/*
	Given an array nums and a value val, remove all instances of that value in-place and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

	The order of elements can be changed. It doesn't matter what you leave beyond the new length.

	给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。

	不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。


	Example 1:

	Given nums = [3,2,2,3], val = 3,

	Your function should return length = 2, with the first two elements of nums being 2.

	It doesn't matter what you leave beyond the returned length.
	Example 2:

	Given nums = [0,1,2,2,3,0,4,2], val = 2,

	Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

	Note that the order of those five elements can be arbitrary.

	It doesn't matter what values are set beyond the returned length.
*/
	/*
	 * @see <a href="https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/" ></a>
	 */

	public int removeElement(int[] nums, int val) {
		// nextPutIndex表示下一步将要放置的index，也就是新数组的长度
		int nextPutIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[nextPutIndex++] = nums[i];
			}
			// 如果相等，nextPut指针不动，i继续向前走
		}
		return nextPutIndex;
	}

	/*
	 * 双指针，结果无序
	 */
	public int removeElement2(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				n--;
			} else {
				i++;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
		int val = 2;
		int n = new _027_RemoveElement().removeElement(nums, val);
		System.out.println("n: " + n);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}
