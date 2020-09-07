/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._374_GuessNumberHigherOrLower
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 猜数字大小
 * @author lilin
 * @date 2020-9-7 15:01
 */
public class _374_GuessNumberHigherOrLower {
	/*
	猜数字游戏的规则如下：

	每轮游戏，系统都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
	如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。
	你可以通过调用一个预先定义好的接口guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
	
	-1 : 你猜测的数字比系统选出的数字大
	 1 : 你猜测的数字比系统选出的数字小
	 0 : 恭喜！你猜对了！
	
	
	示例 :
	
	输入: n = 10, pick = 6
	输出: 6
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int guessNumber(int n) {
		int left = 1;
		int right = n;
		while (left <= n) {
			int mid = left + (right - left) / 2;
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == 1) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private static int guess(int num) {
		if (num == 6) {
			return 0;
		}
		return num < 6 ? 1 : -1;
	}

	public static void main(String[] args) {
		System.out.println(guessNumber(5));
	}
}
