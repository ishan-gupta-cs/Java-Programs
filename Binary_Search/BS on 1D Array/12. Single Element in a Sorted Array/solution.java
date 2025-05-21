public class solution {
    public static void main(String args[]) {
        int nums[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        int idx = singleNonDuplicate(nums);
        System.out.println(idx);
        nums = new int[] { 3, 3, 7, 7, 10, 11, 11 };
        idx = singleNonDuplicate(nums);
        System.out.println(idx);
    }

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            }
            else {
                high = mid;
            }
        }
        return nums[high];
    }
}
