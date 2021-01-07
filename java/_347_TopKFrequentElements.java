/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._347_TopKFrequentElements
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 * @author lilin
 * @date 2021-1-7 10:59
 */
public class _347_TopKFrequentElements {
	/*
	给定一个非空的整数数组，返回其中出现频率前k高的元素。

	示例 1:
	
	输入: nums = [1,1,1,2,2,3], k = 2
	输出: [1,2]
	示例 2:
	
	输入: nums = [1], k = 1
	输出: [1]

	提示：
	
	你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
	你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
	题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
	你可以按任意顺序返回答案。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/top-k-frequent-elements
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer>[] bucket = new List[nums.length + 1];
		for (int num : map.keySet()) {
			int freq = map.get(num);
			if (bucket[freq] == null) {
				bucket[freq] = new LinkedList<>();
			}
			bucket[freq].add(num);
		}

		List<Integer> res = new ArrayList<>();
		for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
			if (bucket[i] != null) {
				res.addAll(bucket[i]);
			}
		}
		int[] r = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			r[i] = res.get(i);
		}
		return r;
	}

	// PriorityQueue : time : O(nlogn) space : O(n)
	public List<Integer> topKFrequent2(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
				new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}

		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			// O(klogn)
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3};
		topKFrequent(nums, 2);
	}
}
