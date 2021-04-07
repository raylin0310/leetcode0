/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._066_PlusOne
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 加一
 * @author lilin
 * @date 2020-10-23 9:47
 */
public class _066_PlusOne {
	/*
	给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	
	你可以假设除了整数 0 之外，这个整数不会以零开头。
	
	示例1:
	
	输入: [1,2,3]
	输出: [1,2,4]
	解释: 输入数组表示数字 123。
	示例2:
	
	输入: [4,3,2,1]
	输出: [4,3,2,2]
	解释: 输入数组表示数字 4321。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/plus-one
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
				//继续算上一位
			}
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}

	public static void main(String[] args) {
		int x = 23;
		int y = 19;

		for (int i = 0; i < (823 / x) + 1; i++) {
			for (int j = 0; j < ((823 - i * x) / y) + 1; j++) {
				if ((i < j) && (i * x + j * y == 823)) {
					System.out.println(i);
					System.exit(0);
				}
			}
		}
	}
}
