/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._88_MergeSortedArray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 合并两个有序数组
 * @author lilin
 * @date 2020-9-1 17:24
 */
public class _088_MergeSortedArray {
	
	/*
	给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。

	说明:
	
	初始化nums1 和 nums2 的元素数量分别为m 和 n 。
	你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
	
	
	示例:
	
	输入:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	
	输出:[1,2,2,3,5,6]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/merge-sorted-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			//比较两个数组的末尾，把最大的放到末尾去
			nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 100, 101, 0, 0,0};
		int[] nums2 = {-1, 5, 6};
		int m = 4;
		int n = 3;
		merge(nums1, m, nums2, n);
		AU.print(nums1);
	}

}
