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

	//deque里面放数组下标


	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length + 1 - k];
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				//保持队列里的元素总共不超过k个
				deque.poll();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				//deque.peekLast()即为马上要移除的元素，如果比当前小，则删掉，这样则保持队列的最后一个元素总是当前窗口内最大的
				deque.removeLast();
			}
			deque.offerLast(i);
			if ((i + 1) >= k) {
				res[i + 1 - k] = nums[deque.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		ArrayUtil.toString(maxSlidingWindow(nums,5));
	}
}
