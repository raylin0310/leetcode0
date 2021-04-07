/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._179_LargestNumber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * _179_LargestNumber
 * 搜索关键词 ：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 拼成/排成 一个数 最小
 * @author lilin
 * @date 2020-9-21 10:15
 */
public class _179_LargestNumber {
	/*
	给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。


	示例 1:
	
	输入: [10,2]
	输出: 210
	示例2:
	
	输入: [3,30,34,5,9]
	输出: 9534330
	说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/largest-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		time : O(nlogn)
        space : O(n)
	 */

	public static String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] res = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(res, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		});
		AU.print(res);
		if (res[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String s : res) {
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}
}
