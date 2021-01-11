
/**
 * 移除元素
 * @author lilin
 * @date 2020-3-5 11:22
 */
public class _027_RemoveElement {
	/*
	给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
	
	不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
	
	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

	示例 1:
	
	给定 nums = [3,2,2,3], val = 3,
	
	函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
	
	你不需要考虑数组中超出新长度后面的元素。
	示例2:
	
	给定 nums = [0,1,2,2,3,0,4,2], val = 2,
	
	函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
	
	注意这五个元素可为任意顺序。
	
	你不需要考虑数组中超出新长度后面的元素。
	
	
	说明:
	
	为什么返回数值是整数，但输出的答案是数组呢?
	
	请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
	
	你可以想象内部操作如下:
	
	// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
	int len = removeElement(nums, val);
	
	// 在函数里修改输入数组对于调用者是可见的。
	// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
	for (int i = 0; i < len; i++) {
	  print(nums[i]);
	}
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-element
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/
	/*
	 * @see <a href="https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/" ></a>
	 */

	public static int removeElement(int[] nums, int val) {
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
	public static int removeElement2(int[] nums, int val) {
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
		int n = removeElement(nums, val);
		System.out.println("n: " + n);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}
