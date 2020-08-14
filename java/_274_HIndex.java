import java.util.Arrays;

/**
 * _274_HIndex
 * @author lilin
 * @date 2020-3-24 14:12
 */
public class _274_HIndex {
	/*
		Given an array of citations (each citation is a non-negative integer) of a researcher,
		write a function to compute the researcher's h-index.

		According to the definition of h-index on Wikipedia:
		"A scientist has index h if h of his/her N papers have at least h citations each,
		and the other N − h papers have no more than h citations each."

		给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。
		编写一个方法，计算出研究者的 h指数。

		h 指数的定义:
		“h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。
		（其余的N - h篇论文每篇被引用次数不多于 h 次。）”


		Example:

		Input: citations = [3,0,6,1,5]
		Output: 3
		Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
		received 3, 0, 6, 1, 5 citations respectively.
		Since the researcher has 3 papers with at least 3 citations each and the remaining
		two with no more than 3 citations each, her h-index is 3.
		Note: If there are several possible values for h, the maximum one is taken as the h-index.

	*/

	public int hIndex(int[] citations) {
		int n = citations.length;
		// hash数组
		int[] count = new int[n + 1];
		for (int citation : citations) {
			count[Math.min(citation, n)] += 1;
		}
		System.out.println(Arrays.toString(count));
		int sum = 0;
		for (int i = n; i > 0; i--) {
			sum += count[i];
			if (sum >= i) {
				return i;
			}
		}
		return 0;
	}

	/*          .  (x=y)
	 * |       .  /
	 * |        /
	 * |      /
	 * |    / .
	 * |  / .
	 * |/___________________________________
	 *
	 *  https://leetcode-cn.com/problems/h-index/solution/hzhi-shu-by-leetcode/
	 */

	public int hIndex2(int[] citations) {
		Arrays.sort(citations);
		// i表示文章个数
		int i = 0;
		while (i < citations.length && citations[citations.length - 1 - i] > i) {
			i++;
		}
		return i;
	}


	public static void main(String[] args) {
		_274_HIndex test = new _274_HIndex();
		int[] nums = {3, 0, 6, 1, 5};
		System.out.println(test.hIndex2(nums));
	}
}
