/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._11_ContainerWithMostWater
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _11_ContainerWithMostWater
 * @author lilin
 * @date 2020-5-9 14:11
 */
public class _11_ContainerWithMostWater {
/*
	给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
	在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
	找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

	说明：你不能倾斜容器，且 n 的值至少为 2。

	示例：
	输入：[1,8,6,2,5,4,8,3,7]
	输出：49

	*/

	/**
	 * @link https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
	 *  双指针
	 */

	public static int maxArea(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int max = -1;
		while (l < r) {
			max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(height));
	}
}






