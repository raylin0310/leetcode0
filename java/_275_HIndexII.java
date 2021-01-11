
/**
 * H 指数 II
 * @author lilin
 * @date 2020-3-24 15:02
 */
public class _275_HIndexII {
	/*
	与274不同的是，已经排好序
	进阶：
	
	这是H 指数的延伸题目，本题中的citations数组是保证有序的。
	你可以优化你的算法到对数时间复杂度吗？

	看官方图解容易理解
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/h-index-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/

	public static int hIndex(int[] citations) {
		int n = citations.length;
		int i = 0;
		while (i < n && citations[n - 1 - i] > i) {
			i++;
		}
		return i;
	}

	public static int hIndex2(int[] citations) {
		int idx = 0, n = citations.length;
		for(int c : citations) {
			if (c >= n - idx) {
				return n - idx;
			} else {
				idx++;
			}
		}
		return 0;
	}

	public static int hIndex3(int[] citations) {
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
		int[] nums = {0, 1, 3, 5, 6};
		System.out.println(hIndex3(nums));
	}
}
