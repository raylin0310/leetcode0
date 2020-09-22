/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._271_EncodeAndDecodeStrings
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _271_EncodeAndDecodeStrings
 * @author lilin
 * @date 2020-9-22 11:05
 */
public class _271_EncodeAndDecodeStrings {
	/*
	设计一种将字符串列表编码为字符串的算法
	编码后的字符串然后通过网络发送，并解码回原始的字符串列表

	Machine 1 (sender) has the function:

	string encode(vector<string> strs) {
	  // ... your code
	  return encoded_string;
	}
	Machine 2 (receiver) has the function:

	vector<string> decode(string s) {
	  //... your code
	  return strs;
	}


	So Machine 1 does:

	string encoded_string = encode(strs);


	and Machine 2 does:

	vector<string> strs2 = decode(encoded_string);


	机器2中的strs2应该与机器1中的strs相同。

	Implement the encode and decode methods.

	Note:

	The string may contain any possible characters out of 256 valid ascii characters.
	字符串可以包含256个有效的ascii字符中的任何可能的字符
	Your algorithm should be generalized enough to work on any possible characters.
	您的算法应被普遍化，以处理任何可能的字符。
	Do not use class member/global/static variables to store states.
	不要使用类成员/全局/静态变量来存储状态
	Your encode and decode algorithms should be stateless.
	您的编码和解码算法应该是无状态的。
	Do not rely on any library method such as eval or serialize methods.
	您的编码和解码算法应该是无状态的。
	You should implement your own encode/decode algorithm.
	您应该实现自己的编码/解码算法。
	 */

	// Encodes a list of strings to a single string.
	public static String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str.length()).append('/').append(str);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	/*
	编码一个字符串用长度+特殊字符+字符串来编码. 解码时找到那个特殊字符串,然后前面又有了字符串的长度, 这样就不用考虑是否出现过这个字符了.
	 */

	public static List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			int slash = s.indexOf('/', i);
			int size = Integer.valueOf(s.substring(i, slash));
			res.add(s.substring(slash + 1, slash + size + 1));
			i = slash + size + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("/abc6");
		list.add("123");
		list.add("d");
		System.out.println(list);
		String encode = encode(list);
		System.out.println(encode);
		List<String> res = decode(encode);
		System.out.println(res);

	}
}
