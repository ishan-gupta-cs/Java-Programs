public class solution {
    public static void main(String args[]) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        System.out.println("Ceil of " + x + " is " + findCeil(arr, x));
        System.out.println("Floor of " + x + " is " + findFloor(arr, x));
        int y = 8;
        int nums2[] = {3,4,4,7,8,10};
        System.out.println("Ceil of " + y + " is " + findCeil(nums2, y));
        System.out.println("Floor of " + y + " is " + findFloor(nums2, y));
    }

    public static int findCeil(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return arr[mid];
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low < arr.length ? arr[low] : -1;
    }

    public static int findFloor(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return arr[mid];
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high >= 0 ? arr[high] : -1;
    }
}
