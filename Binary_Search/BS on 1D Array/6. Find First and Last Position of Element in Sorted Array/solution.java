public class solution {
    public static void main(String[] args) {
        int nums1[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int ans[] = searchRange(nums1, target);
        System.out.println("First and last position of " + target + " in nums1: [" + ans[0] + ", " + ans[1] + "]");

        int nums2[] = { 5, 7, 7, 8, 8, 10 };
        target = 6;
        ans = searchRange(nums2, target);   
        System.out.println("First and last position of " + target + " in nums2: [" + ans[0] + ", " + ans[1] + "]");

        int nums3[] = {};
        target = 0;
        ans = searchRange(nums3, target);
        System.out.println("First and last position of " + target + " in nums3: [" + ans[0] + ", " + ans[1] + "]");
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = firstOccurence(nums, target);
        res[1] = lastOccurence(nums, target);
        return res;
    }

    public static int firstOccurence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1; //if value found still keep on searching left
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1; //if value found still keep on searching right
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

/*  
In binary search:-
Once you find the target at index mid, you don't yet know whether it's the first, last, or a middle occurrence.
To find the first, you must continue searching left.
To find the last, you must continue searching right.
So, in one search, you can only go in one direction.
That is why we did not search in one go beacuse in one go we can go only in one direction
 */