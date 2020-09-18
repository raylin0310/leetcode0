/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._290_WordPattern
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;

/**
 * 单词规律
 * @author lilin
 * @date 2020-9-18 10:11
 */
public class _290_WordPattern {
	/*
	给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。

	这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
	
	示例1:
	
	输入: pattern = "abba", str = "dog cat cat dog"
	输出: true
	示例 2:
	
	输入:pattern = "abba", str = "dog cat cat fish"
	输出: false
	示例 3:
	
	输入: pattern = "aaaa", str = "dog cat cat dog"
	输出: false
	示例4:
	
	输入: pattern = "abba", str = "dog dog dog dog"
	输出: false
	说明:
	你可以假设pattern只包含小写字母，str包含了由单个空格分隔的小写字母。 
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/word-pattern
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static boolean wordPattern(String pattern, String s) {
		String[] ss = s.split("\\s");
		if (ss.length != pattern.length()){
			return false;
		}
		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			Character k = pattern.charAt(i);
			String v = ss[i];
			if (map.containsKey(k)){
				if (!map.get(k).equals(v)){
					return false;
				}
			}else {
				if (map.containsValue(v)){
					return false;
				}else {
					map.put(k,v);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog cat cat dog"));
		System.out.println(wordPattern("abba","dog cat cat fish"));
	}
}
