/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._249_GroupShiftedStrings
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 移位字符串分组
 * @author lilin
 * @date 2020-9-18 11:16
 */
public class _249_GroupShiftedStrings {
	/*
	给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，
	比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：

	"abc" -> "bcd" -> ... -> "xyz"
	给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。

	示例：

	输入: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
	输出:
	[
	  ["abc","bcd","xyz"],
	  ["az","ba"],
	  ["acef"],
	  ["a","z"]
	]
	 */

	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strings) {
			// 计算与字符‘a’偏移后的字符串
			int offset = str.charAt(0) - 'a';
			String key = "";
			for (int i = 0; i < str.length(); i++) {
				char c = (char) (str.charAt(i) - offset);
				if (c < 'a') {
					c += 26;
				}
				key += c;
			}
			System.out.println(key);
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);  // 不排序也行
			res.add(list);
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(groupStrings(strs));
		char s = 'a' - 2 + 26; // y
		System.out.println(s);
	}
}
