package swordOffer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _61_扑克牌中的顺子 {
	/*
	从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
	2～10为数字本身，A为1，J为11，Q为12，K为13，
	而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public boolean isStraight(int[] nums) {
		Set<Integer> repeat = new HashSet<>();
		int max = 0, min = 14;
		for(int num : nums) {
			if(num == 0) {
				continue; // 跳过大小王
			}
			max = Math.max(max, num); // 最大牌
			min = Math.min(min, num); // 最小牌
			if(repeat.contains(num)) {
				return false; // 若有重复，提前返回 false
			}
			repeat.add(num); // 添加此牌至 Set
		}
		return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
	}

	public boolean isStraight2(int[] nums) {
		int joker = 0;
		Arrays.sort(nums); // 数组排序
		for(int i = 0; i < 4; i++) {
			if(nums[i] == 0) {
				joker++; // 统计大小王数量
			} else if(nums[i] == nums[i + 1]) {
				return false; // 若有重复，提前返回 false
			}
		}
		return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
	}

}
