
/**
 * _275_HIndexII
 * @author lilin
 * @date 2020-3-24 15:02
 */
public class _275_HIndexII {
	/*
		Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
		write a function to compute the researcher's h-index.

		According to the definition of h-index on Wikipedia:
		"A scientist has index h if h of his/her N papers have at least h citations each,
		and the other N − h papers have no more than h citations each."

		给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。

		h 指数的定义: “h 代表“高引用次数”（high citations），
		一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"


		Example:

		Input: citations = [0,1,3,5,6]
		Output: 3
		Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
		received 0, 1, 3, 5, 6 citations respectively.
		Since the researcher has 3 papers with at least 3 citations each and the remaining
		two with no more than 3 citations each, her h-index is 3.
		Note:

		If there are several possible values for h, the maximum one is taken as the h-index.

		Follow up:

		This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
		Could you solve it in logarithmic time complexity?
	*/

	/**
	 * 与274不同的是，已经排好序
	 *
	 */

	public int hIndex(int[] citations) {
		int n = citations.length;
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n - i) {
				return n - i;
			}
		}
		return 0;
	}

	public int hIndex3(int[] citations) {
		int n = citations.length;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (citations[mid] == n - mid) {
				return n - mid;
			}
			if (citations[mid] > n - mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return n - left;
	}


	public static void main(String[] args) {
		_275_HIndexII test = new _275_HIndexII();
		int[] nums = {0, 1, 3, 5, 6};
		System.out.println(test.hIndex3(nums));
	}
}
