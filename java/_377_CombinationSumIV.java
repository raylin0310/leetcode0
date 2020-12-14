/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._377_CombinationSumIV
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;

/**
 * 组合总和 Ⅳ
 * @author lilin
 * @date 2020-12-14 19:16
 */
public class _377_CombinationSumIV {
	/*
	给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

	示例:

	nums = [1, 2, 3]
	target = 4

	所有可能的组合为：
	(1, 1, 1, 1)
	(1, 1, 2)
	(1, 2, 1)
	(1, 3)
	(2, 1, 1)
	(2, 2)
	(3, 1)

	请注意，顺序不同的序列被视作不同的组合。

	因此输出为 7。
	进阶：
	如果给定的数组中含有负数会怎么样？
	问题会产生什么变化？
	我们需要在题目中添加什么限制来允许负数的出现？

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/combination-sum-iv
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	//time : < O(2^n) space : O(n)
	public static int combinationSum42(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		return helper(nums, target, map);
	}

	/*
	https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
	 */

	private static int helper(int[] nums, int target, HashMap<Integer, Integer> map) {
		if (target == 0) {
			return 1;
		}
		if (target < 0) {
			return 0;
		}
		if (map.containsKey(target)) {
			return map.get(target);
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += helper(nums, target - nums[i], map);
		}
		map.put(target, res);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(combinationSum42(nums, 4));
	}
}
