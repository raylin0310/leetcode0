/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._209_MinimumSizeSubarraySum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * _209_MinimumSizeSubarraySum
 *
 * @author lilin
 * @date 2020-8-24 17:40
 */
public class _209_MinimumSizeSubarraySum {
	/*
	给定一个含有n个正整数的数组和一个正整数s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。


	示例：
	
	输入：s = 7, nums = [2,3,1,2,4,3]
	输出：2
	解释：子数组[4,3]是该条件下的长度最小的子数组。
	
	
	进阶：
	如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路见网站,也可以用滑动窗口
	 */

    // 滑动窗口，遇到求连续数组（子串）问题，都可以考虑滑动窗口方法，这道题能用下面方法做的原因是都是【正整数】，即sum总是递增的
	/*
	考虑既有整数也有负数的情况，这里参考325做前缀和map，然后判断map里面是否包含一个num<=sum-s
	 */

    public static int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                // res放在循环体里面计算的原因是：必须要满足sum>=s，才会有答案，也就是return做的判断
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static int minSubArrayLen1(int s, int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) {
                res = Math.min(res, i + 1);
            }
            Integer floor = map.floorKey(nums[i] - s);
            if (floor != null) {
                res = Math.min(res, i - map.get(floor));
            }
            map.put(nums[i], i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(15, nums));
        System.out.println(minSubArrayLen1(15, nums));
    }
}
