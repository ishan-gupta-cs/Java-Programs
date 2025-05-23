public class solution {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        double ans = myPow(x, n);
        System.out.println(ans);
        x = 2.10000;
        n = 3;
        ans = myPow(x, n);
        System.out.println(ans);
        x = 2.00000;
        n = -2;
        ans = myPow(x, n);
        System.out.println(ans);
    }

    public static double myPow(double x, int n) {
        return calc(x, (long) n);  // cast to long to avoid overflow for Integer.MIN_VALUE
    }
    
    public static double calc(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
         // If exponent is negative, convert it to positive and take reciprocal
         if (n < 0) {
             return 1.0 / calc(x, -n);
         }
         // If n is even: x^n = (x^2)^(n/2)
         // This reduces the problem size by half
         //2^4 = (2^2)^2 = 16
        if (n % 2 == 0) {
            return calc(x * x, n / 2);
        }
        // If n is odd: x^n = x * (x^2)^((n-1)/2)
        // Multiply x once, then reduce the rest as even
        // 2^5 = 2*(2^2)^2 = 32
        else {
            return x * calc(x * x, (n - 1) / 2);
        }
    }
}
