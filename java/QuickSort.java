import java.util.Random;

public class QuickSort {

	public static void sort(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}

	public static void sort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int partition = partition(nums, left, right);
		sort(nums, left, partition - 1);
		sort(nums, partition + 1, right);
	}

	//快排partition函数

	Random random = new Random();

	public int randomPartition(int[] a, int l, int r) {
		// 随机
		int i = random.nextInt(r - l + 1) + l;
		ArrUtil.swap(a, i, r);
		return partition(a, l, r);
	}

	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int start = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] <= pivot) {
				ArrUtil.swap(nums, i, start++);
			}
		}
		return start - 1;
	}

	// 取第一个为pivot
	private static int partition2(int[] nums, int left, int right) {
		int pivot = nums[left];
		int pos = left;
		for (int i = left; i <= right; ++i) {
			if (nums[i] <= pivot) {
				ArrUtil.swap(nums, i, pos++);
			}
		}
		ArrUtil.swap(nums, --pos, left);
		return pos;
	}

	private static int partition3(int[] nums, int left, int right) {
		int pivot = nums[left];
		while (left < right) {
			while (left < right && nums[right] >= pivot) {
				right--;
			}
			nums[left] = nums[right];
			while (left < right && nums[left] <= pivot) {
				left++;
			}
			nums[right] = nums[left];
		}
		nums[left] = pivot;
		return left;
	}

	public static void main(String[] args) {
		int[] nums = {1, 9, 3, 9, 5,6,7,8,9};
		System.out.println(partition(nums, 0, nums.length - 1));
		ArrUtil.print(nums);
	}
}
