/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._239_SlidingWindowMaximum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * _239_SlidingWindowMaximum
 * @author lilin
 * @date 2020-8-21 11:19
 */
public class _239_SlidingWindowMaximum {
	/*
	给定一个数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。

	返回滑动窗口中的最大值。

	进阶：
	
	你能在线性时间复杂度内解决此题吗？

	示例:
	
	输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
	输出: [3,3,5,5,6,7] 
	解释: 
	
	  滑动窗口的位置                最大值
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	 1 [3  -1  -3] 5  3  6  7       3
	 1  3 [-1  -3  5] 3  6  7       5
	 1  3  -1 [-3  5  3] 6  7       5
	 1  3  -1  -3 [5  3  6] 7       6
	 1  3  -1  -3  5 [3  6  7]      7

	提示：
	
	1 <= nums.length <= 10^5
	-10^4<= nums[i]<= 10^4
	1 <= k<= nums.length
	通过次数69,518提交次数142,493
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/sliding-window-maximum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 队列里面放数组下标，因为涉及到位置判断，如果直接放value的话，则没法判断位置关系，而且我们也可以通过下标直接拿到value，
	 所以，对于数组而言，优先考虑存储下标

	 time : O(n)
     space : O(k)
	 */

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			// 1 [2 3] 4 5 ,此时要移除i=0的,即del=i-k=2-2=0
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				//保持队列里的元素总共不超过k个
				deque.pollFirst();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				//deque.peekLast()即最后一个元素，如果比当前小，则删掉，这样则保持队列的最后一个元素总是当前窗口内最大的
				deque.pollLast();
			}
			deque.offerLast(i);
			if ((i + 1) >= k) {
				// [1 2] 3 4 5 ，当i+1>=k，即1+1>=2的时候，就开始计算最大值
				res[i + 1 - k] = nums[deque.peekFirst()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		//ArrayUtil.toString(maxSlidingWindow(nums,5));
		int[] nums2 = {100, 50, 60, 30, 10};
		AU.print(maxSlidingWindow(nums2, 3));
	}
}
