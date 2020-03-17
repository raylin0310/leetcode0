import java.util.Arrays;

/**
 * _41_FirstMissingPositive
 * @author lilin
 * @date 2020-3-11 10:51
 */
public class _41_FirstMissingPositive {
	/*
		Given an unsorted integer array, find the smallest missing positive integer.

		Example 1:

		Input: [1,2,0]
		Output: 3
		Example 2:

		Input: [3,4,-1,1]
		Output: 2
		Example 3:

		Input: [7,8,9,11,12]
		Output: 1
	*/

	/**
	 * [7,3,9,11,12]
	 * 首先把num[i]放在正确的位置上（num[0]放数字1，num[1]放数字2），如3应该放在index为2上面，交换3和9，
	 * 交换后，还要一直判断交换后的数字是否满足下标要求
	 * 如果num[i]超出了数组长度或者小于1，放在原地
	 * 第二轮循环时，如果num[i]不等于i+1，说明该位置缺少
	 */

	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				// swap
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		System.out.println("step1："+Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public static void main(String[] args) {
		int[] nums = {7, 3, 9, 11, 12};
		_41_FirstMissingPositive test = new _41_FirstMissingPositive();
		System.out.println(test.firstMissingPositive(nums));
	}
}
