/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._077_Combinations
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * @author lilin
 * @date 2020-12-9 10:18
 */
public class _077_Combinations {
	/*
	给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

	示例:
	
	输入:n = 4, k = 2
	输出:
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/combinations
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	回溯，组合，带终止条件
	这个题解说的比较明白：https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/

	 */

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), n, k, 1);
		return res;
	}


	public static void dfs(List<List<Integer>> res, List<Integer> path, int n, int k, int start) {
		if (path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}
		// 遍历可能的搜索起点
		//下面可以优化，没有必要每次都遍历到n去，i <= n - (k - path.size()) + 1
		/*
		9 -（5-2） k=5,size=2，还差3个，倒退就是9 8 7，i必须<=7 ，即 i<=9 -（5-2）+1
		 */
		for (int i = start; i <= n; i++) {
			// 向路径变量里添加一个数
			path.add(i);
			// 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
			dfs(res, path, n, k, i + 1);
			// 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(combine(4, 2).toString());
	}
}
