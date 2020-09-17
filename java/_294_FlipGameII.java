/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._294_FlipGameII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;

/**
 * _294_FlipGameII
 * @author lilin
 * @date 2020-9-17 11:37
 */
public class _294_FlipGameII {
	/*
	您正在和朋友一起玩以下翻转游戏: 给定一个仅包含这两个字符的字符串: + and -,
	您和您的朋友轮流翻转两个连续 "++" into "--".
	当一个人不再能移动时游戏结束，因此另一个人将成为获胜者

	编写一个函数来确定起始玩家是否可以保证获胜。

	Example:

	Input: s = "++++"
	Output: true
	Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
	Follow up:
	Derive your algorithm's runtime complexity.
	 */

	public static boolean canWin(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		//map的意思，当我持有这个key的时候，我的胜负是value，比如《----，false》,当我的字符串是----时，我已经输了
		HashMap<String, Boolean> map = new HashMap<>();
		return helper(s, map);
	}

	private static boolean helper(String s, HashMap<String, Boolean> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
				if (!helper(opponent, map)) {
					map.put(s, true);
					System.out.println("当我拿到" + s + "时，我就赢了！");
					return true;
				}
			}
		}
		System.out.println("当我拿到" + s + "时，我就输了！");
		map.put(s, false);
		return false;
	}


	public static void main(String[] args) {
		System.out.println(canWin("++++"));
	}
}
