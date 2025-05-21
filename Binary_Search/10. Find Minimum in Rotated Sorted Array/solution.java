public class solution {
    public static void main(String[] args) {
        int nums[] = { 3, 4, 5, 1, 2 };
        int min = findMin(nums);
        System.out.println(min);

        nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        min = findMin(nums);
        System.out.println(min);

        nums = new int[] { 11, 13, 15, 17 };
        min = findMin(nums);
        System.out.println(min);
    }
    
    public static int findMin(int nums[]) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[mid];
    }
}
