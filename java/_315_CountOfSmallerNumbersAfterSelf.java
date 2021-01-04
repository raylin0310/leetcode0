/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._315_CountOfSmallerNumbersAfterSelf
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 * @author lilin
 * @date 2020-9-8 10:56
 */
public class _315_CountOfSmallerNumbersAfterSelf {
	/*
	给定一个整数数组 nums，按要求返回一个新数组counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。

	示例：
	
	输入：nums = [5,2,6,1]
	输出：[2,1,1,0] 
	解释：
	5 的右侧有 2 个更小的元素 (2 和 1)
	2 的右侧仅有 1 个更小的元素 (1)
	6 的右侧有 1 个更小的元素 (1)
	1 的右侧有 0 个更小的元素
	
	
	提示：
	
	0 <= nums.length <= 10^5
	-10^4<= nums[i] <= 10^4
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	int[] temp;
	int[] indexs;
	int[] count;

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums.length < 1) {
			return res;
		}
		temp = new int[nums.length];
		indexs = new int[nums.length];
		count = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indexs[i] = i;
		}
		mergeAndCountSmaller(nums, 0, nums.length - 1);
		for (int i = 0; i < count.length; i++) {
			res.add(count[i]);
		}
		return res;
	}

	// 开始拆分
	public void mergeAndCountSmaller(int[] nums, int l, int r) {
		if (l == r) {
			//一个元素
			return;
		}
		int mid = l + (r - l) / 2;
		mergeAndCountSmaller(nums, l, mid);
		mergeAndCountSmaller(nums, mid + 1, r);
		if (nums[indexs[mid]] <= nums[indexs[mid + 1]]) {
			return;
		}
		mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
	}
	/*
	 这里跟剑指offer的51求逆序对不同的点是：
	 这里在计算count时，是以i节点开始的，也就是从左往右，也就是计算的左侧的num[i]（l<=i<=mid），
	 这样子count[indexs[k]]里面的indexs[k]才能正确的值
	 因为题目要求是的“counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量”
	 所以一定是以“左边”作为标准的
	 而51求逆序对，没有考虑下标，只计算了个数
	 */

	public void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
		for (int i = l; i <= r; i++) {
			//由于归并后的数组是有序的，复制一份原来无序的数组出来
			temp[i] = indexs[i];
		}
		//左侧开始下标
		int i = l;
		//右侧开始下标
		int j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				//左侧用尽
				indexs[k] = temp[j++];
			} else if (j > r) {
				//右侧用尽
				indexs[k] = temp[i++];
				count[indexs[k]] += (r - mid);
			} else if (nums[temp[i]] <= nums[temp[j]]) {
				//那么i大于j前面的元素
				indexs[k] = temp[i++];
				count[indexs[k]] += (j - mid - 1);
			} else {
				indexs[k] = temp[j++];
			}
		}
	}


	public static void main(String[] args) {
		int[] nums = {5, 2, 6, 1};
		int[] nums2 = {-1};
		_315_CountOfSmallerNumbersAfterSelf test = new _315_CountOfSmallerNumbersAfterSelf();
		List<Integer> res = test.countSmaller(nums2);
		AU.print(res);
	}
}

