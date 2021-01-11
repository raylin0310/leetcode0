
/**
 * 公牛和母牛
 * @author lilin
 * @date 2021-1-11 10:51
 */
public class _299_BullsAndCows {
	/*

	你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
	
	你写出一个秘密数字，并请朋友猜这个数字是多少。
	朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
	朋友根据提示继续猜，直到猜出秘密数字。
	请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用B表示奶牛。
	
	xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
	yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
	请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
	你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。

	示例 1:
	
	输入: secret = "1807", guess = "7810"
	输出: "1A3B"
	解释: 1公牛和3奶牛。公牛是 8，奶牛是 0, 1和 7。
	示例 2:
	
	输入: secret = "1123", guess = "0111"
	输出: "1A1B"
	解释: 朋友猜测数中的第一个 1是公牛，第二个或第三个 1可被视为奶牛。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/bulls-and-cows
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/

	/*
	 * "1234"
	 * "5612"
	 *
	 * "56789"
	 * "89153"
	 *
	 * "1122"
	 * "1222"
	 */

	public static String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		// 计数器（数组hash表）
		int[] count = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				int s = secret.charAt(i) - '0';
				int g = guess.charAt(i) - '0';
				if (count[s]++ < 0) {
					cows++;
				}
				if (count[g]-- > 0) {
					cows++;
				}
			}
		}
		return bulls + "A" + cows + "B";
	}
	/*
		"1123", "0111"
		举例，s[1] == g[1]，不计入母牛中，那么开始计算出现数字，
		在s中，1出现了1次，2出现了1次，3出现了1次
		在g中，1出现了2次
		那么母牛的个数，就是Min(count_s[i],count_g[i])=1次
	 */

	public static String getHint2(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] sa = new int[10];
		int[] ga = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				bulls++;
			} else {
				sa[secret.charAt(i) - '0']++;
				ga[guess.charAt(i) - '0']++;
			}
		}
		for (int i = 0; i < 10; i++) {
			cows += Math.min(sa[i], ga[i]);
		}
		return bulls + "A" + cows + "B";
	}

	public static void main(String[] args) {
		//System.out.println(getHint2("1807", "7810"));
		System.out.println(getHint2("1123", "0111"));
		//System.out.println(getHint2("1122", "1222"));
	}

}
