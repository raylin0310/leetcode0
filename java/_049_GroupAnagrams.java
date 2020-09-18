/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._049_GroupAnagrams
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 * @author lilin
 * @date 2020-9-18 10:25
 */
public class _049_GroupAnagrams {
	/*
	给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

	示例:

	输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
	输出:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	说明：

	所有输入均为小写字母。
	不考虑答案输出的顺序。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/group-anagrams
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	//      time : O(m * n)   m : strs 长度   n : strs中最大String的长度
	//     space : O(n) 或者 O(n^2) 结果不同

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			int[] count = new int[26];
			for (Character ch : str.toCharArray()) {
				count[ch - 'a']++;
			}
			// s = 1a1e1t
			String s = "";
			for (int i = 0; i < count.length; i++) {
				if (count[i] != 0) {
					s += count[i] + String.valueOf((char)(i + 'a'));
				}
			}
			if (map.containsKey(s)) {
				List<String> list = map.get(s);
				list.add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, list);
			}
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
	}
}
