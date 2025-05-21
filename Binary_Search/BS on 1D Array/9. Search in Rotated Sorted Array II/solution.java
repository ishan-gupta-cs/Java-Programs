public class solution {
    public static void main(String args[]) {
        int nums[] = { 2, 5, 6, 0, 0, 1, 2 }, target = 0;
        int idx = search(nums, target);
        System.out.println(idx);

        nums = new int[] { 2, 5, 6, 0, 0, 1, 2 };
        target = 3;
        idx = search(nums, target);
        System.out.println(idx);
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
            //Unresolvable ambiguity due to duplicates — so shrink the search window by 1 from both ends.
            else if (nums[mid] == nums[low] && nums[low] == nums[high]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
