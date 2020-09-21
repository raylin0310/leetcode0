/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._006_ZigZagConversion
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * @author lilin
 * @date 2020-9-21 10:25
 */
public class _006_ZigZagConversion {
	/*
	将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。

	比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
	
	L   C   I   R
	E T O E S I I G
	E   D   H   N
	之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
	
	请你实现这个将字符串进行指定行数变换的函数：
	
	string convert(string s, int numRows);
	示例1:
	
	输入: s = "LEETCODEISHIRING", numRows = 3
	输出: "LCIRETOESIIGEDHN"
	示例2:
	
	输入: s = "LEETCODEISHIRING", numRows =4
	输出:"LDREOEIIECIHNTSG"
	解释:
	
	L     D     R
	E   O E   I I
	E C   I H   N
	T     S     G
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/zigzag-conversion
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder("");
		}
		for (int i = 0; i < s.length(); i++) {
			int index = i % (2 * numRows - 2);
			index = index < numRows ? index : 2 * numRows - 2 - index;
			sb[index].append(s.charAt(i));
		}
		for (int i = 1; i < sb.length; i++) {
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
	}

	//把每一个字符放在对应行的StringBuilder里面，最后拼接
	public static String convert2(String s, int numRows) {

		if (numRows == 1) {
			return s;
		}

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++) {
			rows.add(new StringBuilder());
		}

		int curRow = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) {
				//到头或者到底了，方向反转
				goingDown = !goingDown;
			}
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows) {
			ret.append(row);
		}
		return ret.toString();
	}


	public static void main(String[] args) {
		System.out.println(convert2("LEETCODEISHIRING", 3));
	}
}
