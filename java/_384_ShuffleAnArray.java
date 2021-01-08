/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._384_ShuffleAnArray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱数组
 * @author lilin
 * @date 2021-1-7 13:53
 */
public class _384_ShuffleAnArray {

	static class Solution {

		private int[] nums;
		private Random rnd = new Random();

		public Solution(int[] nums) {
			this.nums = nums;
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return nums;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			if (nums == null) {
				return null;
			}
			int[] copy = Arrays.copyOf(nums, nums.length);
			for (int i = copy.length - 1; i > 0; i--) {
				int random = rnd.nextInt(i + 1);
				swap(copy, random, i);
			}
			return copy;
		}

		private void swap(int[] clone, int i, int j) {
			int temp = clone[i];
			clone[i] = clone[j];
			clone[j] = temp;
		}
	}
}
