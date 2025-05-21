public class solution {
    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int n = rotateCount(nums);
        System.out.println(n);

        nums = new int[] { 3, 4, 5, 1, 2 };
        n = rotateCount(nums);
        System.out.println(n);
    }

    public static int rotateCount(int nums[]) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) {
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}

//In a rotated sorted array, the smallest element is the rotation point
