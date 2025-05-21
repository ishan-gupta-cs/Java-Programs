//x**n = m, find x
public class solution {
    public static int nthRoot(int N, int M) {
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long midPower = power(mid, N);

            if (midPower == M) {
                return mid;
            } else if (midPower < M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; 
    }

    // Function to compute x^n safely using long to avoid overflow
    private static long power(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
            if (result > Long.MAX_VALUE) break; 
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(3, 27)); 
        System.out.println(nthRoot(4, 69)); 
    }
}
