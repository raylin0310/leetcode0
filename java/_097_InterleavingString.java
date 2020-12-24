/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._097_InterleavingString
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 交错字符串
 * @author lilin
 * @date 2020-12-24 10:06
 */
public class _097_InterleavingString {
	/*
	给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。

	两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
	
	s = s1 + s2 + ... + sn
	t = t1 + t2 + ... + tm
	|n - m| <= 1
	交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
	提示：a + b 意味着字符串 a 和 b 连接。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/interleaving-string
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	参考cn官方题解，详细解释

	这个题解更容易理解
	https://leetcode-cn.com/problems/interleaving-string/solution/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/
	 */

	public static boolean isInterleave(String s1, String s2, String s3) {
		int n = s1.length(), m = s2.length(), t = s3.length();

		if (n + m != t) {
			return false;
		}
		//我们定义 f(i, j) 表示 s1 的前 i 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i + j 个元素
		boolean[][] f = new boolean[n + 1][m + 1];

		f[0][0] = true;
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				int p = i + j - 1;
				if (i > 0) {
					f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
				}
				if (j > 0) {
					f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
				}
			}
		}

		return f[n][m];
	}

	//上面是下面这个的简化版，

	public static boolean isInterleave2(String s1, String s2, String s3) {
		if ((s1.length() + s2.length()) != s3.length()) {
			return false;
		}

		boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
		dp[0][0] = true;

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1))
						|| (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		}

		return dp[s2.length()][s1.length()];
	}

	// 滚动数组优化，相当于s1的放在第一列，s2放在第一排组成一个二维数组

	public static boolean isInterleave4(String s1, String s2, String s3) {
		int n = s1.length(), m = s2.length(), t = s3.length();

		if (n + m != t) {
			return false;
		}

		boolean[] f = new boolean[m + 1];

		f[0] = true;
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				int p = i + j - 1;
				if (i > 0) {
					f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
				}
				if (j > 0) {
					f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
				}
			}
		}

		return f[m];
	}


	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		//System.out.println(isInterleave5("aabcc", "dbbca", "aadbbcbcac"));
		//System.out.println(isInterleave2("aa", "ab", "aaba"));
		System.out.println(isInterleave2("", "", ""));

	}
}
