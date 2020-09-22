/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._171_ExcelSheetColumnNumber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * Excel表列序号
 * @author lilin
 * @date 2020-9-22 18:02
 */
public class _171_ExcelSheetColumnNumber {
	/*
	给定一个Excel表格中的列名称，返回其相应的列序号。

	例如，
	
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
	    ...
	示例 1:
	
	输入: "A"
	输出: 1
	示例2:
	
	输入: "AB"
	输出: 28
	示例3:
	
	输入: "ZY"
	输出: 701
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/excel-sheet-column-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int titleToNumber(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res = res * 26 + (s.charAt(i) - 'A' + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("AA"));
	}
}
