/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._215_KthLargestElementInAnArray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * @author lilin
 * @date 2021-1-6 16:43
 */
public class _215_KthLargestElementInAnArray {
	/*
	在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

	示例 1:
	
	输入: [3,2,1,5,6,4] 和 k = 2
	输出: 5
	示例2:
	
	输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
	输出: 4
	说明:
	
	你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	time : O(nlogk)
	space : O(k)
	 */

	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : nums) {
			Integer peek = minHeap.peek();
			if (peek != null && num < peek && minHeap.size() == k) {
				continue;
			}
			if (minHeap.size() == k) {
				minHeap.poll();
			}
			minHeap.offer(num);
		}
		return minHeap.peek();
	}

	public int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : nums) {
			minHeap.offer(num);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.poll();
	}


	// 利用快排算法的partition，时间复杂度高于用最小堆，但是空间复杂度比用最小堆好
	// 1,2,3,4  k=2 index=2 ,k=3 index=1  index=n-k
	//     * time：最坏：O(n^2) 平均：O(nlogn)
	//     * space : O(1)

	public static int findKthLargest3(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int left = 0;
		int right = nums.length - 1;
		while (true) {
			int pos = partition(nums, left, right);
			if (pos == n - k) {
				return nums[pos];
			} else if (pos > n - k) {
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
				int temp = nums[i];
				nums[i] = nums[start];
				nums[start] = temp;
				start++;
			}
		}
		return start - 1;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 5, 6, 4};
		System.out.println(topK(nums, 5));
	}

	/*
		topK问题，用最大堆，这里可以优化，如果k小于nums.length的一半，就用最大堆，如果大于了一半
		就用最小堆，倒着来，这样子空间复杂度要小一点，比如n=100，k=10，用最大堆的话，只需要维护最大为10的堆
		比如k=90，用最小堆的话，就要维护最大为90的堆，这时候用最小堆来做
	 */

	public static int topK(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int num : nums) {
			maxHeap.offer(num);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.poll();
	}
}
