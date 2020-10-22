/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._187_RepeatedDNASequences
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 重复的DNA序列
 * @author lilin
 * @date 2020-10-22 11:07
 */
public class _187_RepeatedDNASequences {
	/*
	所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

	编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
	
	示例：
	
	输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
	输出：["AAAAACCCCC", "CCCCCAAAAA"]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/repeated-dna-sequences
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> seen = new HashSet<>();
		HashSet<String> repeated = new HashSet<>();
		for (int i = 0; i < s.length() - 9; i++) {
			String temp = s.substring(i, i + 10);
			if (!seen.add(temp)) {
				repeated.add(temp);
			}
		}
		return new ArrayList<>(repeated);
	}

	public static void main(String[] args) {

	}
}
