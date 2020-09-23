/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._248_StrobogrammaticNumberIII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _248_StrobogrammaticNumberIII
 * @author lilin
 * @date 2020-9-23 10:39
 */
public class _248_StrobogrammaticNumberIII {
	/*
	中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。

	写一个函数来计算范围在 [low, high] 之间中心对称数的个数。
	示例:
	输入: low = "50", high = "100"
	输出: 3
	解释: 69，88 和 96 是三个在该范围内的中心对称数
	注意:
	由于范围可能很大，所以 low 和 high 都用字符串表示。
	 */

	public static int strobogrammaticInRange(String low, String high){
		int res = 0;
		List<String> list = new ArrayList<>();
		for (int i = low.length(); i <= high.length(); i++) {
			list.addAll(helper(i, i));
		}
		for (String num : list) {
			//这里是字符串，所以要先长度相同
			if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) {
				System.out.println(num);
				continue;
			}
			res++;
		}
		return res;
	}

	private static List<String> helper(int cur, int max) {
		if (cur == 0) {
			return new ArrayList<>(Arrays.asList(""));
		}
		if (cur == 1) {
			return new ArrayList<>(Arrays.asList("1", "8", "0"));
		}

		List<String> res = new ArrayList<>();
		List<String> center = helper(cur - 2, max);

		for (String tmp : center) {
			if (cur != max) {
				res.add("0" + tmp + "0");
			}
			res.add("1" + tmp + "1");
			res.add("8" + tmp + "8");
			res.add("6" + tmp + "9");
			res.add("9" + tmp + "6");
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("result："+strobogrammaticInRange("50","100"));
	}

}
