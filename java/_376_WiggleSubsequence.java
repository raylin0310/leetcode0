/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._376_WiggleSubsequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 摆动序列
 * @author lilin
 * @date 2020-9-3 15:10
 */
public class _376_WiggleSubsequence {
	/*
		如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
		
		例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)是正负交替出现的。
		相反, [1,4,7,2,5]和[1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
		
		给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
		
		示例 1:
		
		输入: [1,7,4,9,2,5]
		输出: 6 
		解释: 整个序列均为摆动序列。
		示例 2:
		
		输入: [1,17,5,10,13,15,10,5,16,8]
		输出: 7
		解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
		示例 3:
		
		输入: [1,2,3,4,5,6,7,8,9]
		输出: 2
		进阶:
		你能否用O(n) 时间复杂度完成此题?
		
		来源：力扣（LeetCode）
		链接：https://leetcode-cn.com/problems/wiggle-subsequence
		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	  动态规划题解：举个例子 [1,100,99,98,97,96，200]
	  第一段是上升，那么序列长度就是2，后面一直下降，假设num[i]=99，下降，那么序列长度就是2+1=3，即前面上升的序列长度加1
	  而后面的98、97，一直在下降，没有坡度差，所以最大序列长度还是2+1=3直到遇到200，开始上升
	 */

	public static int wiggleMaxLength(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int up = 1, down = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				up = down + 1;
			} else if (nums[i] < nums[i - 1]) {
				down = up + 1;
			}
		}
		return Math.max(up, down);
	}

	/*
	贪心算法题解：只考虑波峰和波谷，跳过了过渡元素
	 */

	public static int wiggleMaxLength2(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return n;
		}
		int prevdiff = nums[1] - nums[0];
		int ret = prevdiff != 0 ? 2 : 1;
		for (int i = 2; i < n; i++) {
			int diff = nums[i] - nums[i - 1];
			/*
			   1、当前是上升，那么前一段就要是下降，这样才能找到一个波谷
			   2、当前是下降，那么前一段必须是上升，这样才能找到一个波峰
			   3、不满足上面条件，则不动
			   这里判断prevdiff包含了等于，是为了兼容num[1]和num[0]相等的情况，后面就不会出现prevdiff等于0的情况了

			 */
			if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
				ret++;
				prevdiff = diff;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = {1, 7, 4, 9, 2, 5};
		int[] nums1 = {1, 7, 8, 9, 10};
		int r = wiggleMaxLength(nums1);
		System.out.println(r);
	}
}
