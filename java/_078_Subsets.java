/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._078_Subsets
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * @author lilin
 * @date 2020-12-8 10:16
 */
public class _078_Subsets {
	/*
	给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
	
	说明：解集不能包含重复的子集。
	
	示例:
	
	输入: nums = [1,2,3]
	输出:
	[
	  [3],
	 [1],
	 [2],
	 [1,2,3],
	 [1,3],
	 [2,3],
	 [1,2],
	 []
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/subsets
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路：回溯
		 */

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		dfs(res, new ArrayList<>(), nums, 0);
		return res;
	}

	/*
	对于数组中的每一个元素，其状态只有两种，在集合中和不在集合中，参考官方题解
	 */

	public static void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
		if (index == nums.length) {
			// 到达末尾了，复制一份加入res
			res.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[index]);
		dfs(res, list, nums, index + 1);
		//返回的时候，移除当前添加的元素，下面的移除不能放在return语句前面
		//原因为，第二个dfs跑的是‘不在集合中’状态的，这个是不需要去remove的
		list.remove(list.size() - 1);
		dfs(res, list, nums, index + 1);
	}

	/*
		这是最开始自己写的，核心思想跟上面一样：每个元素只有两种状态，但是我的写法每次调用helper方法，都会创建两个list
		对象，而上面的回溯，则是一直用的一个list对象
		关于回溯算法的解释：https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
	 */

	public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int i) {
		if (i == nums.length) {
			res.add(list);
			return;
		}
		List<Integer> l1 = new ArrayList<>(list);
		List<Integer> l2 = new ArrayList<>(list);
		l1.add(nums[i]);
		helper(res, l1, nums, i + 1);
		helper(res, l2, nums, i + 1);
	}


	public static List<List<Integer>> subsets3(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	/*
	这个图解比较清晰：https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
	接这个图：https://imgchr.com/i/rS0bV0
	 */

	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		// 这里的意思，是以num[i]为首元素去递归后面的元素，
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		// [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
		System.out.println(subsets3(nums).toString());
	}


}
