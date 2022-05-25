/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._152_MaximumProductSubarray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _152_MaximumProductSubarray
 *
 * @author lilin
 * @date 2020-8-28 15:12
 */
public class _152_MaximumProductSubarray {

	/*
	给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

	示例 1:
	
	输入: [2,3,-2,4]
	输出: 6
	解释:子数组 [2,3] 有最大乘积 6。
	示例 2:
	
	输入: [-2,0,-1]
	输出: 0
	解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/maximum-product-subarray
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 思路：动态规划
	 类似53题，但是负数乘以负数会变成正数，所以需要维护两个dp，一个最大值，一个最小值
	 */

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTemp = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            int minTemp = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            max = maxTemp;
            min = minTemp;
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct1(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTemp = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            int minTemp = Math.max(Math.min(max * nums[i], min * nums[i]), nums[i]);
            max = maxTemp;
            min = minTemp;
            res = Math.max(res, max);
        }
        return res;
    }
}
