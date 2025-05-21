public class solution {
    public static void main(String args[]) {
        int n = 7,  x = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int count = Counting(n,x,array);
        System.out.println(x+" occurs "+count+" times in array");

        n = 8;  x = 2; array = new int[] {1, 1, 2, 2, 2, 2, 2, 3};
        count = Counting(n,x,array);
        System.out.println(x+" occurs "+count+" times in array");
    }

    public static int Counting(int n, int x, int arr[]) {
        int first = firstOccurence(arr, x);
        if (first == -1) {
            return 0;
        }
        int last = lastOccurence(arr, x);
        return last - first + 1;
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
