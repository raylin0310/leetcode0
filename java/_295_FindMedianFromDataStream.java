/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._295_FindMedianFromDataStream
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.PriorityQueue;

/**
 * _295_FindMedianFromDataStream
 * @author lilin
 * @date 2020-8-24 14:27
 */
public class _295_FindMedianFromDataStream {
	/*
	中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

	例如，
	
	[2,3,4]的中位数是 3
	
	[2,3] 的中位数是 (2 + 3) / 2 = 2.5
	
	设计一个支持以下两种操作的数据结构：
	
	void addNum(int num) - 从数据流中添加一个整数到数据结构中。
	double findMedian() - 返回目前所有元素的中位数。
	示例：
	
	addNum(1)
	addNum(2)
	findMedian() -> 1.5
	addNum(3) 
	findMedian() -> 2
	进阶:
	
	如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
	如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/find-median-from-data-stream
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		 题解：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/you-xian-dui-lie-python-dai-ma-java-dai-ma-by-liwe/
		 由于我们只关心中位数，用两个优先队列，一个最大堆存储低位的数据，一个最小堆存储高位的数据
		 由于总个数可能为奇数，规定最小堆可以比低位的最大堆多存储一个数，这样，中位数就是最小堆的堆顶元素，直接peek
		 当总个数为偶数的时候，从两个堆中各取出堆顶的元素，即为中位数
		 1   2   3    4    5    6
		 |--最大堆-|   |--最小堆--|

		 另外，这里最大堆，有个技巧是，排序还是用的Int自然顺序，但是把元素取反放入，这样子就变成最大堆了
		 如上面数据，最后堆顶元素是 -3 和 4，中位数就是4-(-3) /2

	 */


	//低位
	private PriorityQueue<Long> small;
	//高位
	private PriorityQueue<Long> large;

	/** initialize your data structure here. */
	public _295_FindMedianFromDataStream() {
		small = new PriorityQueue<>();
		large = new PriorityQueue<>();
	}

	public void addNum(int num) {
		large.add((long)num);
		small.add(-large.poll());
		if (large.size() < small.size()) {
			large.add(-small.poll());
		}
	}

	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2;
	}

	public static void main(String[] args) {
		_295_FindMedianFromDataStream test = new _295_FindMedianFromDataStream();
		test.addNum(1);
		test.addNum(2);
		test.addNum(3);
		test.addNum(4);
		test.addNum(5);
		System.out.println(test.findMedian());
	}
}
