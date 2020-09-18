/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._242_ValidAnagram
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 有效的字母异位词
 * @author lilin
 * @date 2020-9-18 10:19
 */
public class _242_ValidAnagram {
	/*
	给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

	示例1:
	
	输入: s = "anagram", t = "nagaram"
	输出: true
	示例 2:
	
	输入: s = "rat", t = "car"
	输出: false
	说明:
	你可以假设字符串只包含小写字母。
	
	进阶:
	如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/valid-anagram
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	//time: O(n+m)=O(n) space: O(1)

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}

		for (int num : count) {
			if (num != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
