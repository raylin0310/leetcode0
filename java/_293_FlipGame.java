/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._293_FlipGame
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _293_FlipGame
 * @author lilin
 * @date 2020-9-17 11:28
 */
public class _293_FlipGame {

	/*
	您正在和朋友一起玩以下翻转游戏: 给定一个仅包含这两个字符的字符串: + and -,
	您和您的朋友轮流翻转两个连续 "++" into "--".
	当一个人不再能采取行动时，游戏结束，因此另一个人将成为获胜者。

	编写一个函数，以计算一次有效移动后字符串的所有可能状态。

	For example, given s = "++++", after one move, it may become one of the following states:

	[
	  "--++",
	  "+--+",
	  "++--"
	]


	If there is no valid move, return an empty list [].

	这道题让我们把相邻的两个 ++ 变成 --
	*/

	public static List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
				res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "++++";
		AU.print(generatePossibleNextMoves(s));
	}
}
