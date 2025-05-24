public class solution {
     private static final int MOD = 1_000_000_007;

     public static void main(String[] args) {
         long n = 1;
         int ans = countGoodNumbers(n);
         System.out.println(ans);

         n = 4;
         ans = countGoodNumbers(n);
         System.out.println(ans);

         n = 50;
         ans = countGoodNumbers(n);
         System.out.println(ans);
     }
    
     /**
     * Counts the number of good digit strings of length n.
     * A digit string is good if:
     * - Digits at even indices (0-based) are even digits (0, 2, 4, 6, 8) → 5 choices
     * - Digits at odd indices are prime digits (2, 3, 5, 7) → 4 choices
     */

     /*
      * You're asked to count how many good digit strings of length n exist.
        A digit string is good if:
     
        At even indices (0-based): digits must be even → {0, 2, 4, 6, 8} → 5 options
     
        At odd indices: digits must be prime → {2, 3, 5, 7} → 4 options
     
        Example:
        If n = 4, positions are:
     
        index 0 → even index → 5 choices
     
        index 1 → odd index → 4 choices
     
        index 2 → even index → 5 choices
     
        index 3 → odd index → 4 choices
        
        total combinations = 5 × 4 × 5 × 4 = (5^2) × (4^2) = 400

      */
    
     public static int countGoodNumbers(long n) {
         long evenCount = (n + 1) / 2;
         long oddCount = n / 2;

         long evenWays = modPow(5, evenCount);
         long oddWays = modPow(4, oddCount);

         return (int) ((evenWays * oddWays) % MOD);
     }

    /**
     * Fast modular exponentiation function: calculates (x^n) % MOD
     * Uses recursive method with divide-and-conquer (exponentiation by squaring)
     * Time complexity: O(log n)
     */

    public static long modPow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        x %= MOD;
        if (n % 2 == 1) {
            return (x * modPow((x * x) % MOD, (n - 1) / 2)) % MOD;
        }
        else{
            return modPow((x * x) % MOD, n / 2);
        }
    }
}