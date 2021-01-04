

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

	private static int partition(int[] nums, int left, int right) {
		// 这里选取pivot的值，可以用随机数选择Index
		int pivot = nums[right];
		int start = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] <= pivot) {
				AU.swap(nums, i, start++);
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
				AU.swap(nums, pos++, i);
			}
		}
		AU.swap(nums, --pos, left);
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
		int[] nums = {1, 2, 3, 4, 5};
		System.out.println(partition2(nums, 0, nums.length));
		AU.print(nums);
	}
}
