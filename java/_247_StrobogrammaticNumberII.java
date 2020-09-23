/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._247_StrobogrammaticNumberII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _247_StrobogrammaticNumberII
 * @author lilin
 * @date 2020-9-23 10:17
 */
public class _247_StrobogrammaticNumberII {
	/*
	中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。

	找到所有长度为 n 的中心对称数。
	示例 :
	输入:  n = 2
	输出: ["11","69","88","96"]

	输入:  n = 3
	输出: ["101","609","808","906","111","619","818","916","181","689","888","986"]
	 */

	public static List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	public static List<String> helper(int n, int m) {
		if (n == 0) {
			//返回一个空串
			return new ArrayList<>(Arrays.asList(""));
		}
		if (n == 1) {
			return new ArrayList<>(Arrays.asList("0", "1", "8"));
		}
		//因为长度差为2时，左右各一个
		List<String> h = helper(n - 2, m);
		ArrayList<String> res = new ArrayList<>();
		for (String s : h) {
			if (n != m) {
				//不是最后一次添加，补0
				res.add("0" + s + "0");
			}
			res.add("1" + s + "1");
			res.add("6" + s + "9");
			res.add("8" + s + "8");
			res.add("9" + s + "6");
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findStrobogrammatic(4));
	}
}
