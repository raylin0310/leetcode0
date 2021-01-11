import java.util.Arrays;

/**
 * H 指数
 * @author lilin
 * @date 2020-3-24 14:12
 */
public class _274_HIndex {
	/*
	给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

	h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
	且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。

	例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
	示例：

	输入：citations = [3,0,6,1,5]
	输出：3
	解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
	     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。

	提示：如果 h 有多种可能的值，h 指数是其中最大的那个。

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
	 * 倒序来看比较容易理解
	 */

	public int hIndex2(int[] citations) {
		Arrays.sort(citations);
		// i表示文章个数
		int i = 0;
		// citations[citations.length - 1 - i] 就是倒序后的第一个数
		while (i < citations.length && citations[citations.length - 1 - i] > i) {
			i++;
		}
		return i;
	}


	public static void main(String[] args) {
		_274_HIndex test = new _274_HIndex();
		int[] nums = {0, 0, 1, 0, 0};
		System.out.println(test.hIndex2(nums));
	}
}
