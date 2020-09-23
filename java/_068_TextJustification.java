/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._068_TextJustification
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐
 * @author lilin
 * @date 2020-9-23 13:44
 */
public class _068_TextJustification {
	/*
	给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。

	你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
	
	要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
	
	文本的最后一行应为左对齐，且单词之间不插入额外的空格。
	
	说明:
	
	单词是指由非空格字符组成的字符序列。
	每个单词的长度大于 0，小于等于maxWidth。
	输入单词数组 words至少包含一个单词。
	示例:
	
	输入:
	words = ["This", "is", "an", "example", "of", "text", "justification."]
	maxWidth = 16
	输出:
	[
	 "This  is  an",
	 "example of text",
	 "justification. "
	]
	示例2:
	
	输入:
	words = ["What","must","be","acknowledgment","shall","be"]
	maxWidth = 16
	输出:
	[
	 "What  must  be",
	 "acknowledgment ",
	 "shall be    "
	]
	解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
	    因为最后一行应为左对齐，而不是左右两端对齐。       
	     第二行同样为左对齐，这是因为这行只包含一个单词。
	示例3:
	
	输入:
	words = ["Science","is","what","we","understand","well","enough","to","explain",
	        "to","a","computer.","Art","is","everything","else","we","do"]
	maxWidth = 20
	输出:
	[
	 "Science is what we",
	  "understand   well",
	 "enough to explain to",
	 "a computer. Art is",
	 "everything else we",
	 "do         "
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/text-justification
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<String> fullJustify(String[] words, int L) {
		List<String> res = new ArrayList<>();
		int index = 0;
		while (index < words.length) {
			int count = words[index].length();
			int last = index + 1;
			while (last < words.length) {
				if (words[last].length() + count + 1 > L) {
					break;
				}
				count += 1 + words[last].length();
				last++;
			}
			StringBuilder builder = new StringBuilder();
			builder.append(words[index]);
			int diff = last - index - 1;
			if (last == words.length || diff == 0) {
				for (int i = index + 1; i < last; i++) {
					builder.append(" ");
					builder.append(words[i]);
				}
				for (int i = builder.length(); i < L; i++) {
					builder.append(" ");
				}
			} else {
				int spaces = (L - count) / diff;
				int r = (L - count) % diff;
				for (int i = index + 1; i < last; i++) {
					for (int k = spaces; k > 0; k--) {
						builder.append(" ");
					}
					if (r > 0) {
						builder.append(" ");
						r--;
					}
					builder.append(" ");
					builder.append(words[i]);
				}
			}
			res.add(builder.toString());
			index = last;
		}
		return res;
	}

	public static void main(String[] args) {
		String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
				"to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
		System.out.println(fullJustify(words, 20));
	}
}
