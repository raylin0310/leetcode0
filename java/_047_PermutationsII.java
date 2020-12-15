/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._047_PermutationsII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 * @author lilin
 * @date 2020-12-14 20:31
 */
public class _047_PermutationsII {
	/*
	给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

	示例 1：
	
	输入：nums = [1,1,2]
	输出：
	[[1,1,2],
	 [1,2,1],
	 [2,1,1]]
	示例 2：
	
	输入：nums = [1,2,3]
	输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

	提示：
	
	1 <= nums.length <= 8
	-10 <= nums[i] <= 10
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/permutations-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}

	//画出图形更好理解

	public static void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// 因为存在重复的数，所以这里用i而不是nums[i]
			if (used[i]) {
				continue;
			}
			// 不加 !used[i - 1] 会把第二层的第二个1给弄掉，也就是 第一个数取1，循环第二层的时候，第二个1
			// 跟 40题组合不同，组合是不允许重复的。即{2,4}和{4,2}是一个，所以每次dfs，下一层的start总是当前i+1
			// 而排列，每下一层都是从0开始
			// https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			path.add(nums[i]);
			dfs(res, path, nums, used);
			used[i] = false;
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		int[] nums2 = {1, 2, 2};
		System.out.println(permuteUnique(nums));
		System.out.println(permuteUnique(nums2));
	}
}
