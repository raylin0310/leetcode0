import java.util.ArrayList;
import java.util.List;

/**
 * 众数II
 * @author lilin
 * @date 2020-3-24 10:46
 */
public class _229_MajorityElementII {
/*
	给定一个大小为n的整数数组，找出其中所有出现超过⌊ n/3 ⌋次的元素。
	
	进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

	示例1：
	
	输入：[3,2,3]
	输出：[3]
	示例 2：
	
	输入：nums = [1]
	输出：[1]
	示例 3：
	
	输入：[1,1,1,3,3,2,2,2]
	输出：[1,2]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/majority-element-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

	/*
	 * 结果最多不超过两个
	 * 1、如果投A（当前元素等于A），则A的票数++;
	 * 2、如果投B（当前元素等于B），B的票数++；
	 * 3、如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0，如果为0,则当前元素成为新的候选人；如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一。
	 *
	 * 最后会有这么几种可能：有2个大于n/3，有1个大于n/3，有0个大于n/3
	 * 遍历结束后选出了两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数，因为题目没有像169题保证一定有。
	 *
	 * 作者：jerry_nju
	 * 链接：https://leetcode-cn.com/problems/majority-element-ii/solution/169ti-sheng-ji-ban-xiang-jie-zhu-xing-jie-shi-tong/
	 * 来源：力扣（LeetCode）
	 */

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int num1 = 0, count1 = 0;
		int num2 = 0, count2 = 0;
		for (int num : nums) {
			if (num1 == num) {
				count1++;
			} else if (num2 == num) {
				count2++;
			} else if (count1 == 0) {
				num1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				num2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		// 跟169题不一样的是，这题没有保证一定存在大于1/3的数，所以必须验证
		for (int num : nums) {
			if (num1 == num) {
				count1++;
			} else if (num2 == num) {
				count2++;
			}
		}
		if (count1 > nums.length / 3) {
			result.add(num1);
		}
		if (count2 > nums.length / 3) {
			result.add(num2);
		}
		return result;
	}

	public static void main(String[] args) {
		_229_MajorityElementII test = new _229_MajorityElementII();
		int[] nums = {1, 1, 1, 4, 5, 6, 7, 8};
		System.out.println(test.majorityElement(nums).toString());
	}
}
