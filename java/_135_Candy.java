/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._135_Candy
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * _135_Candy
 * @author lilin
 * @date 2020-8-11 10:01
 */
public class _135_Candy {
	/*
	 * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
	 *
	 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
	 *
	 * 每个孩子至少分配到 1 个糖果。
	 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
	 * 那么这样下来，老师至少需要准备多少颗糖果呢？
	 *
	 * 示例1:
	 *
	 * 输入: [1,0,2]
	 * 输出: 5
	 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
	 * 示例2:
	 *
	 * 输入: [1,2,2]
	 * 输出: 4
	 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
	 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/candy
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	    time : O(n)
        space : O(n)
	 */


	public static int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}
		System.out.println(Arrays.toString(candies));
		for (int i = candies.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}
		System.out.println(Arrays.toString(candies));
		return Arrays.stream(candies).sum();
	}

	public static int candy2(int[] ratings) {
		int n = ratings.length;
		int ret = 1;
		int inc = 1, dec = 0, pre = 1;
		for (int i = 1; i < n; i++) {
			if (ratings[i] >= ratings[i - 1]) {
				dec = 0;
				pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
				ret += pre;
				inc = pre;
			} else {
				dec++;
				if (dec == inc) {
					dec++;
				}
				System.out.println("des：" + dec);
				ret += dec;
				pre = 1;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 20, 18, 16, 15, 14};
		System.out.println("res=" + candy(nums));
		System.out.println("res=" + candy2(nums));
	}

}
