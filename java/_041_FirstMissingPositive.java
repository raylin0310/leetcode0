import java.util.Arrays;

/**
 * 缺失的第一个正数
 * @author lilin
 * @date 2020-3-11 10:51
 */
public class _041_FirstMissingPositive {
	/*
	给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
	示例1:
	
	输入: [1,2,0]
	输出: 3
	示例2:
	
	输入: [3,4,-1,1]
	输出: 2
	示例3:
	
	输入: [7,8,9,11,12]
	输出: 1

	提示：
	
	你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/first-missing-positive
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/

	/*
	 * [7,3,9,11,12]  索引作为哈希表(使用索引作为哈希键值)
	 * 首先把num[i]放在正确的位置上（num[0]放数字1，num[1]放数字2），如3应该放在index为2上面，交换3和9，
	 * 交换后，还要一直判断交换后的数字是否满足要求
	 * 如果num[i]超出了数组长度或者小于1，放在原地
	 * 第二轮循环时，如果num[i]不等于i+1，说明该位置缺少
	 *
	 * @see <a href="https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/"></a>
	 */

	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			// 如果num[3]=4，就是正确位置，即nums[i] = nums[nums[i] - 1]，如果num[3]=5，那么就把5放在正确的位置
			// 即把5放在num[4](num[5-1])，交换过后，原来num[5]的值就放到num[3]上，重复再判断
			while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				// swap
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		System.out.println("step1：" + Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public static void main(String[] args) {
		int[] nums = {1000, 3, 9, 11, 12};
		System.out.println(firstMissingPositive(nums));
	}
}
