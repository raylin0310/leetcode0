/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._287_FindtheDuplicateNumber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _287_FindtheDuplicateNumber
 * @author lilin
 * @date 2020-5-15 10:18
 */
public class _287_FindtheDuplicateNumber {
/*
	给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

	相当于把10个苹果房间9个盒子里，至少有一个盒子会放两个苹果

	示例 1:

	输入: [1,3,4,2,2]
	输出: 2
	示例 2:

	输入: [3,1,3,4,2]
	输出: 3
	说明：

	不能更改原数组（假设数组是只读的）。
	只能使用额外的 O(1) 的空间。
	时间复杂度小于 O(n2) 。
	数组中只有一个重复的数字，但它可能不止重复出现一次。
	*/
	/*
	 * 思路：
	 *
	 * 这道题要求我们查找的数是一个整数，并且给出了这个整数的范围（在 1 和 n 之间，包括 1 和 n），并且给出了一些限制，于是可以使用二分查找法定位在一个区间里的整数；
	 *
	 * 说明：由于这个算法是空间敏感的，「用时间换空间」是反常规做法，算法的运行效率肯定不会高。
	 * space:O(1)，time:O(nlogn) ，二分查找logn，每一次二分需要遍历一次，所以是nlogn
	 * 	证明方法：假如数组为[1,2,2,3,5,4]，mid=(1+5)/2=3，那么，正常情况下，<=3的个数应该是3个，如果1/2/3其中任何一个数重复了，那么个数都会大于3
	 *  如果大于3了，说明重复的元素肯定在1、2、3中，那么下一次的mid就是mid=(1+3)/2=2
	 *  继续统计<=2的个数，发现是3，大于了2，说明重复的元素肯定在1、2中，那么下一次的mid=(1+2)/2=1，
	 *  继续统计小于1的个数，发现是1，那么重复的元素肯定不是1，所以left = mid + 1 = 2，
	 *   不满足条件，跳出，返回left=2就是答案
	 */

	/*
		time : O(nlogn)
		space : O(1)
	 */

	public static int findDuplicate(int[] nums) {
		int len = nums.length;
		int left = 1;
		int right = len - 1;
		while (left < right) {
			// 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
			int mid = (left + right) >>> 1;

			int cnt = 0;
			for (int num : nums) {
				if (num <= mid) {
					cnt += 1;
				}
			}
			// 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
			// 此时重复元素一定出现在 [1, 4] 区间里
			if (cnt > mid) {
				// 重复元素位于区间 [left, mid]
				right = mid;
			} else {
				// if 分析正确了以后，else 搜索的区间就是 if 的反面
				// [mid + 1, right]
				left = mid + 1;
			}
		}
		return left;
	}

	/*
		参考142题，链表入环
		time : O(n) space : O(1)
	 */

	public static int findDuplicate2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int slow = 0;
		int fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast) {
				break;
			}
		}
		int head = 0;
		while (true) {
			slow = nums[slow];
			head = nums[head];
			if (head == slow) {
				break;
			}
		}
		return slow;
	}

	/*
	  这种异或的解法的前提是，只有一个重复的数，并且1-n的数子每个都出现
	  异或 a^b=1  b^b=0   0^c=c
	  那么这个解法的原理是 (a^b^c^b) ^ (a^b^c) = b  a^a=0 然后抵消，最后只剩下0^b=b
	 */

	public static int findDuplicate3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int x1 = 0;
		for (int i = 1; i <= nums.length - 1; i++) {
			x1 = x1 ^ i;
		}
		for (int num : nums) {
			x1 = x1 ^ num;
		}
		return x1;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 4, 5};
		System.out.println(findDuplicate(nums));
	}
}
