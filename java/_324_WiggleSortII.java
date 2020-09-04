/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._324_WiggleSortII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * 摆动排序 II
 * @author lilin
 * @date 2020-9-4 13:49
 */
public class _324_WiggleSortII {
	
	/*
	给定一个无序的数组nums，将它重新排列成nums[0] < nums[1] > nums[2] < nums[3]...的顺序。

	示例1:
	
	输入: nums = [1, 5, 1, 1, 6, 4]
	输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
	示例 2:
	
	输入: nums = [1, 3, 2, 2, 3, 1]
	输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
	说明:
	你可以假设所有输入都会得到有效的结果。
	
	进阶:
	你能用O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/wiggle-sort-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
		先对数组排序，分为大数部分和小数部分，再穿插排序，注意，降序插入
	 */

	public static void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int mid = (n - 1) / 2;
		int index = 0;
		int[] temp = new int[n];
		for (int i = 0; i <= mid; i++) {
			temp[index] = nums[mid - i];
			if (index + 1 < n) {
				temp[index + 1] = nums[n - 1 - i];
			}
			index += 2;
		}
		System.arraycopy(temp, 0, nums, 0, n);
	}


	/**
	 Original idx:   0    1    2    3    4    5
	 Mapped idx:     1    3    5    0    2    4
	 Array:          13   6    4    5    2    5
	 5    6    4   13    2    5
	 r
	 i
	 l
	 median = 5

	 nums[] = 5

	 大于中位数，左 - 右，奇
	 小于中位数，右 - 左，偶

	 time : O(n)
	 space : O(1)
	 * @param nums
	 */

	/*
		https://leetcode-cn.com/problems/wiggle-sort-ii/solution/yi-bu-yi-bu-jiang-shi-jian-fu-za-du-cong-onlognjia/
		可参考题解2，下面这个方法是题解3，有点难懂，
		题解2：先用快速选择，得到整个数组的中位数，再用#75题中的3-way-partition方法，中位数左边的都是小于中位数的，右边都是大于中位数的。
		这个过程是On的，这时候再用方法1的倒序插入就可以了
	 */

	public static void wiggleSort2(int[] nums) {
		int median = findKthLargest(nums, (nums.length + 1) / 2);
		int n = nums.length;
		int left = 0, right = n - 1;
		int index = 0;
		while (index <= right) {
			if (nums[newIndex(index, n)] > median) {
				AU.swap(nums, newIndex(left++, n), newIndex(index++, n));
			} else if (nums[newIndex(index, n)] < median) {
				AU.swap(nums, newIndex(right--, n), newIndex(index, n));
			} else {
				index++;
			}
		}
	}

	private static int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}

	//寻找第k大的数，即排序后，位于k-1下标的数字（快速选择算法）

	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (true) {
			int pos = partition(nums, left, right);
			if (pos + 1 == k) {
				return nums[pos];
			} else if (pos + 1 > k) {
				right = pos - 1;
			} else {
				left = pos + 1;
			}
		}
	}

	//快排partition函数

	private static int partition(int[] nums, int left, int right) {

		int pivot = nums[right];
		int start = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] <= pivot) {
				AU.swap(nums, i, start++);
			}
		}
		return start - 1;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3};
		wiggleSort2(nums);
		AU.print(nums);

		//测试partitionon

//		int[] nums = {1, 2, 3, 5, 6, 8, 9, 5, 4};
//		System.out.println(partition(nums, 0, nums.length - 1));
//		AU.print(nums);


	}
}
