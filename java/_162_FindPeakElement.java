/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._162_FindPeakElement
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 *  寻找峰值
 * @author lilin
 * @date 2020-9-7 14:34
 */
public class _162_FindPeakElement {
	
	/*
	峰值元素是指其值大于左右相邻值的元素。

	给定一个输入数组midnums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
	
	数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
	
	你可以假设midnums[-1] = nums[n] = -∞。
	
	示例 1:
	
	输入: nums = [1,2,3,1]
	输出: 2
	解释: 3 是峰值元素，你的函数应该返回其索引 2。
	示例mid2:
	
	输入: nums = [1,2,1,3,5,6,4]
	输出: 1 或 5 
	解释: 你的函数可以返回索引 1，其峰值元素为 2；
	mid    或者返回索引 5， 其峰值元素为 6。
	说明:
	
	你的解法应该是 O(logN) 时间复杂度的。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/find-peak-element
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	官解非常明白！这种题最好画图来理解。
	https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
	 */

	public static int findPeakElement1(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return nums.length - 1;
	}


	public static int findPeakElement2(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;

	}

	public static void main(String[] args) {
	}
}
