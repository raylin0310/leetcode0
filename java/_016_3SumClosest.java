/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._016_3SumClosest
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 *  最接近的三数之和
 * @author lilin
 * @date 2020-11-3 9:54
 */
public class _016_3SumClosest {
	/*
	给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。

	示例：
	
	输入：nums = [-1,2,1,-4], target = 1
	输出：2
	解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

	提示：
	
	3 <= nums.length <= 10^3
	-10^3<= nums[i]<= 10^3
	-10^4<= target<= 10^4
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/3sum-closest
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
     time : O(n^2);
     space : O(1);
	 */

	public static int threeSumClosest(int[] nums, int target) {
		int res = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[start] + nums[i] + nums[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
