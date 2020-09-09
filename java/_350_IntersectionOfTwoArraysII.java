/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._350_IntersectionOfTwoArraysII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 两个数组的交集 II
 * @author lilin
 * @date 2020-9-8 10:43
 */
public class _350_IntersectionOfTwoArraysII {
	/*
	给定两个数组，编写一个函数来计算它们的交集。

	示例 1：
	
	输入：nums1 = [1,2,2,1], nums2 = [2,2]
	输出：[2,2]
	示例 2:
	
	输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	输出：[4,9]
	
	
	说明：
	
	输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
	我们可以不考虑输出结果的顺序。
	进阶：
	
	如果给定的数组已经排好序呢？你将如何优化你的算法？ （双指针）
	如果nums1的大小比nums2小很多，哪种方法更优？
	如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？（采用hashmap方法，把num1循环放入map中，num2每次取一部分用来判断即可）
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	// HashMap, time : O(n), space : O(n);
	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				if (map.get(nums2[i]) > 0) {
					ret.add(nums2[i]);
					map.put(nums2[i], map.get(nums2[i]) - 1);
				}
			}
		}
		int[] res = new int[ret.size()];
		int k = 0;
		for (Integer num : ret) {
			res[k++] = num;
		}
		return res;
	}

	// Arrays.sort time : O(nlogn) space : O(n);
	public static int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> ret = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				ret.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] res = new int[ret.size()];
		int k = 0;
		for (Integer num : ret) {
			res[k++] = num;
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
