import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author lilin
 * @date 2020-2-18 10:52
 */
public class _001_TwoSum {
	/*
	给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
	
	你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

	示例:
	
	给定 nums = [2, 7, 11, 15], target = 9
	
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/two-sum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/

	public static int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return new int[]{-1, -1};
		}
		int[] res = {-1, -1};
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] array = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(array, target)));
	}
}


