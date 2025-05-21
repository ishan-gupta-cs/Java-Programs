public class solution {
    public static void main(String args[]) {
        int n = 36;
        int sqrt = floorSqrt(n);
        System.out.println(sqrt);
        n = 28;
        sqrt = floorSqrt(n);
        System.out.println(sqrt);
    }

    public static int floorSqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long low = 1;
        long high = n;
        long mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid * mid == n) {
                return (int) mid;
            } else if (mid * mid > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }
}