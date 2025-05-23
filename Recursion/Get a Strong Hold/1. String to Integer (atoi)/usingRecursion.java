public class usingRecursion {
    public static void main(String args[]) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -042"));
        System.out.println(myAtoi("1337c0d3"));
    }

    public static int myAtoi(String s) {
        return helper(s.trim(), 0, 0, 1, false);
    }

    private static int helper(String s, int i, long res, int sign, boolean signHandled) {
        if (i >= s.length()) {
            return (int)(sign * res);
        }

        char ch = s.charAt(i);

        if (!signHandled) {
            if (ch == '+') {
                return helper(s, i + 1, res, 1, true);
            } else if (ch == '-') {
                return helper(s, i + 1, res, -1, true);
            }
        }

        if (Character.isDigit(ch)) {
            res = res * 10 + (ch - '0');
            if (sign * res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return helper(s, i + 1, res, sign, true);
        }

        return (int)(sign * res);
    }
}
