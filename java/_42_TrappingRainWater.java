/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._42_TrappingRainWater
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _42_TrappingRainWater
 * @author lilin
 * @date 2020-5-9 15:05
 */
public class _42_TrappingRainWater {
/*
	给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
	上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

	示例:

	输入: [0,1,0,2,1,0,1,3,2,1,2,1]
	输出: 6

	*/

	/*
		 0,1,0,2,1,0,1,3,2,1,2,1

		               *
		       *       * *   *
		   *   * *   * * * * * *
		 0 1 2 3 4 5 6 7 8 9 0 1

	 */


	public static int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int res = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				leftMax = Math.max(leftMax, height[left]);
				res += leftMax - height[left];
				left++;
			} else {
				rightMax = Math.max(rightMax, height[right]);
				res += rightMax - height[right];
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(trap(height));
	}
}
