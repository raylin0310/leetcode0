/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._204_CountPrimes
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.BitSet;

/**
 * 计数质数
 * @author lilin
 * @date 2020-11-2 14:59
 */
public class _204_CountPrimes {
	/*
	统计所有小于非负整数n的质数的数量。

	示例 1：
	
	输入：n = 10
	输出：4
	解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
	示例 2：
	
	输入：n = 0
	输出：0
	示例 3：
	
	输入：n = 1
	输出：0

	提示：
	
	0 <= n <= 5 * 106
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/count-primes
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	核心思路：厄拉多塞筛法 时间复杂度：O(nloglogn)

	首先从 2 开始，我们知道 2 是一个素数，那么 2 × 2 = 4, 3 × 2 = 6, 4 × 2 = 8... 都不可能是素数了。
	即如果一个数i是质数，那么2*i,3*i,4*i,5*i...n*i都不是质数
	 */

	public static int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];

		int res = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				res++;
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		return res;
	}

	//如果n特别大的话，可以用bitset来优化内存
	public static int countPrimes2(int n) {
		BitSet bitSet = new BitSet(n);
		int res = 0;
		for (int i = 2; i < n; i++) {
			if (!bitSet.get(i)) {
				res++;
				for (int j = 2; i * j < n; j++) {
					bitSet.set(i * j);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(4));

	}
}
