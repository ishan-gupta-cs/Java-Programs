public class solution {
    public static void main(String args[]) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 }, target = 0;
        int idx = search(nums, target);
        System.out.println(target + " found at " + idx);

        nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 3;
        idx = search(nums, target);
        System.out.println(target + " found at " + idx);

        nums = new int[] { 1 };
        target = 0;
        idx = search(nums, target);
        System.out.println(target + " found at " + idx);
    }
    
    public static int search(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //left half sorted 
            else if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //right half sorted 
            else { //if(nums[high]>=nums[mid])
                if (nums[high] >= target && nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
