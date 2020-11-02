/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._015_3Sum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author lilin
 * @date 2020-11-2 16:21
 */
public class _015_3Sum {
	/*
	给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

	注意：答案中不可以包含重复的三元组。
	
	示例：
	
	给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	
	满足要求的三元组集合为：
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/3sum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	类似167题
	优化版双指针，官方解答很详细
     time : O(n^2);
     space : O(n^2);
	 */

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				// 第一个数大于 0，后面的数都比它大，肯定不成立了
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int low = i + 1, high = nums.length - 1;
			int sum = 0 - nums[i];
			while (low < high) {
				if (nums[low] + nums[high] == sum) {
					res.add(Arrays.asList(nums[i], nums[low], nums[high]));
					while (low < high && nums[low] == nums[low + 1]) {
						//跳过连续的数
						low++;
					}
					while (low < high && nums[high] == nums[high - 1]) {
						high--;
					}
					low++;
					high--;
				} else if (nums[low] + nums[high] < sum) {
					low++;
				} else {
					high--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
