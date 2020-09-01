/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._238_ProductOfArrayExceptSelf
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * _238_ProductOfArrayExceptSelf
 * @author lilin
 * @date 2020-8-28 14:30
 */
public class _238_ProductOfArrayExceptSelf {

	/*
	给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。

	示例:
	
	输入: [1,2,3,4]
	输出: [24,12,8,6]
	
	
	提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
	
	说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
	
	进阶：
	你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/product-of-array-except-self
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		思路：除自身以外数组的乘积 = 这个数左边的乘积 乘上 右边的乘积
	 */


	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		System.out.println("res[0]=1");
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
			System.out.println("res[" + i + "]=" + res[i]);
		}
		// res[i] = i坐标左边所有数字的乘积
		// 如res[3] = res[2] * num[2] (2下标所有的乘积即num[0]*num[1]，乘上num[2]，即res[3] = num[0]*num[1]*num[2])
		System.out.println("第一次循环后：");
		AU.print(res);
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}

	/*
		采用两边同时计算
	 */

	public static int[] productExceptSelf2(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, 1);
		int left = 1, right = 1;
		for (int i = 0; i < n; i++) {
			res[i] *= left;
			left *= nums[i];

			res[n - i - 1] *= right;
			right *= nums[n - i - 1];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		AU.print(productExceptSelf(nums));
		AU.print(productExceptSelf2(nums));
	}
}
