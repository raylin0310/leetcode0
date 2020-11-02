/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._365_WaterAndJugProblem
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 水壶问题
 * @author lilin
 * @date 2020-11-2 14:45
 */
public class _365_WaterAndJugProblem {
	/*
	有两个容量分别为x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好z升 的水？

	如果可以，最后请用以上水壶中的一或两个来盛放取得的z升水。
	
	你允许：
	
	装满任意一个水壶
	清空任意一个水壶
	从一个水壶向另外一个水壶倒水，直到装满或者倒空
	示例 1: (From the famous "Die Hard" example)
	
	输入: x = 3, y = 5, z = 4
	输出: True
	示例 2:
	
	输入: x = 2, y = 6, z = 5
	输出: False
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/water-and-jug-problem
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	https://leetcode-cn.com/problems/water-and-jug-problem/solution/shui-hu-wen-ti-by-leetcode-solution/
	深度优先搜索
	 */

	public static boolean canMeasureWater(int x, int y, int z) {
		Deque<int[]> stack = new LinkedList<int[]>();
		stack.push(new int[]{0, 0});
		Set<Long> seen = new HashSet<Long>();
		while (!stack.isEmpty()) {
			if (seen.contains(hash(stack.peek()))) {
				stack.pop();
				continue;
			}
			seen.add(hash(stack.peek()));

			int[] state = stack.pop();
			int remain_x = state[0], remain_y = state[1];
			if (remain_x == z || remain_y == z || remain_x + remain_y == z) {
				return true;
			}
			// 把 X 壶灌满。
			stack.push(new int[]{x, remain_y});
			// 把 Y 壶灌满。
			stack.push(new int[]{remain_x, y});
			// 把 X 壶倒空。
			stack.push(new int[]{0, remain_y});
			// 把 Y 壶倒空。
			stack.push(new int[]{remain_x, 0});
			// 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
			stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
			// 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
			stack.push(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
		}
		return false;
	}

	public static long hash(int[] state) {
		return (long) state[0] * 1000001 + state[1];
	}

	public static void main(String[] args) {
		System.out.println(canMeasureWater(3,5,4));
	}
}
