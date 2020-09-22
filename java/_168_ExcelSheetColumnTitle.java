/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._168_ExcelSheetColumnTitle
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * Excel表列名称
 * @author lilin
 * @date 2020-9-22 11:28
 */
public class _168_ExcelSheetColumnTitle {
	/*
	给定一个正整数，返回它在 Excel 表中相对应的列名称。

	例如，

	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB
	    ...
	示例 1:

	输入: 1
	输出: "A"
	示例2:

	输入: 28
	输出: "AB"
	示例3:

	输入: 701
	输出: "ZY"

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/excel-sheet-column-title
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static String convertToTitle(int n) {
		n--;
		if (n >= 26) {
			int i = n / 26;
			int l = n % 26;
			return convertToTitle(i) + (char) (l + 'A');
		}
		char c = (char) (n + 'A');
		return Character.toString(c);
	}

	public static String convertToTitle2(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append((char) ('A' + n % 26));
			n /= 26;
		}
		return sb.reverse().toString();
	}


	public static void main(String[] args) {
		System.out.println(convertToTitle2(702));
		System.out.println(convertToTitle(702));
	}
}
