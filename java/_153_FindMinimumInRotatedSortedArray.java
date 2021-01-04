/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._153_FindMinimumInRotatedSortedArray
 * @copyr Copyr 2018 Thunisoft, Inc. All rs reserved.
 */

/**
 * 寻找旋转排序数组中的最小值
 * @author lilin
 * @date 2020-9-7 11:24
 */
public class _153_FindMinimumInRotatedSortedArray {
	/*
	假设按照升序排序的数组在预先未知的某个点上进行了旋转。

	( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
	
	请找出其中最小的元素。
	
	你可以假设数组中不存在重复元素。
	
	示例 1:
	
	输入: [3,4,5,1,2]
	输出: 1
	示例 2:
	
	输入: [4,5,6,7,0,1,2]
	输出: 0
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int findMin(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			int mid = (r - l) / 2 + l;
			if (nums[mid] < nums[r]) {
				// mid可能是最小值
				r = mid;
			} else {
				// else这里只存在num[mid] > num[r]，因为数组元素不重复
				// mid肯定不是最小值
				l = mid + 1;
			}
		}
		return nums[l];
	}

	public static void main(String[] args) {
		int[] nums = {3, 4, 5, 1, 2};
		int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
		int[] nums3 = {3, 1, 2};
		//System.out.println(findMin(nums));
		//System.out.println(findMin(nums2));
		System.out.println(findMin(nums));
	}
}
