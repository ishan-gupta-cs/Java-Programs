public class solution {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };
        int idx = findPeakElement(nums);
        System.out.println(idx);
        nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };
        idx = findPeakElement(nums);
        System.out.println(idx);
    }
    
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
