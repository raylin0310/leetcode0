import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 众数
 * 超过一半 次数
 */
public class _169_MajorityElement {
/*
	给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
	
	你可以假设数组是非空的，并且给定的数组总是存在多数元素。

	示例1：
	
	输入：[3,2,3]
	输出：3
	示例2：
	
	输入：[2,2,1,1,1,2,2]
	输出：2

	进阶：
	
	尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/majority-element
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int mid = nums.length / 2;
		for (int num : nums) {
			Integer count = map.getOrDefault(num,0);
			count++;
			if (count > mid) {
				return num;
			} else {
				map.put(num, count);
			}
		}
		return -1;
	}

	public static int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/*
	 * 投票法，前提是数组中一定有众数才行，
	 * 如果num等于候选数，票数加一
	 * 如果count为零，说明票数刚好抵消完，重新赋值候选数
	 * 如果num不等于候选数，票数减一
	 */

	public static int majorityElement3(int[] nums) {
		int count = 0;
		int candidate = 0;
		for (int num : nums) {
			if (num == candidate) {
				count++;
			} else if (count == 0) {
				candidate = num;
				count = 1;
			} else {
				count--;
			}
		}
		return candidate;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 1, 1, 2, 2};
		System.out.println(majorityElement3(nums));
	}
}
