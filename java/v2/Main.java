package v2;

public class Main {

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int[] nums2 = new int[len + 1];
        for (int i = 0; i < len; i++) {
            nums2[nums[i]] = 1;
        }
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                return i;
            }
        }
        return nums2.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }
}
