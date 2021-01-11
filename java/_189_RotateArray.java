
import java.util.Arrays;

/**
 * 旋转数组
 * @author lilin
 * @date 2020-3-6 11:02
 */
public class _189_RotateArray {
/*

	给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

	示例 1:
	
	输入: nums = [1,2,3,4,5,6,7], k = 3
	输出: [5,6,7,1,2,3,4]
	解释:
	向右旋转 1 步: [7,1,2,3,4,5,6]
	向右旋转 2 步: [6,7,1,2,3,4,5]
	向右旋转 3 步: [5,6,7,1,2,3,4]
	示例2:
	
	输入：nums = [-1,-100,3,99], k = 2
	输出：[3,99,-1,-100]
	解释: 
	向右旋转 1 步: [99,-1,-100,3]
	向右旋转 2 步: [3,99,-1,-100]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/rotate-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

	/*
	[1,2,3,4,5,6,7]  k = 3

	[5,6,7,1,2,3,4]
	*/

	/*
	 * 挨个儿位移 时间复杂度 kn
	 */

	public static void rotate(int[] nums, int k) {
		if (k < 1) {
			return;
		}
		k = k % nums.length;
		for (int i = 0; i < k; i++) {
			int num0 = nums[nums.length - 1];
			int pre = nums[0];
			for (int j = 0; j < nums.length - 1; j++) {
				int temp = nums[j + 1];
				nums[j + 1] = pre;
				pre = temp;
			}
			nums[0] = num0;
		}
	}

	/*
	 * 旋转数组
	 */

	public static void rotate2(int[] nums, int k) {
		if (k < 1) {
			return;
		}
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				// 计数，解决循环移动问题，如length = 6,k =2
				count++;
			} while (start != current);
		}
	}

	/*
	 * 旋转数组，思路同上，当遇到环时，从start的下一个index继续开始，用移动次数<nums.length来控制结束
	 */

	public static void rotate4(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return;
		}
		int n = nums.length;
		k = k % n;
		if (k == 0) {
			return;
		}
		// 共移动次数，计数，解决循环移动问题，如length = 6,k =2
		int count = 0;
		int start = 0;
		int cur = start;
		int pre = nums[cur];
		while (count < n) {
			int next = (cur + k) % n;
			int temp = nums[next];
			nums[next] = pre;
			pre = temp;
			cur = next;
			if (cur == start) {
				start++;
				cur = start;
				pre = nums[cur];
			}
			count++;
		}
	}

	/*
	 * 输入: nums = [1,2,3,4,5,6,7], k = 3 result=[5,6,7,1,2,3,4]
	 * step1: [7,6,5,4,3,2,1]
	 * step2: [5,6,7,4,3,2,1]
	 * step3: [5,6,7,1,2,3,4]
	 */

	public void rotate3(int[] nums, int k) {
		if (k < 1) {
			return;
		}
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}


	public static void main(String[] args) {
		int[] nums = {-1, -100, 3, 99};
		int k = 2;
		rotate4(nums, k);
		System.out.println(Arrays.toString(nums));
	}

}
