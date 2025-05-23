public class solution {
    public static void main(String args[]) {
        String s = "42";
        int ans = myAtoi(s);
        System.out.println(ans);
        s = " -042";
        ans = myAtoi(s);
        System.out.println(ans);
        s = "1337c0d3";
        ans = myAtoi(s);
        System.out.println(ans);
    }

    public static int myAtoi(String s){
        long res = 0;
        int i = 0;
        int n = s.length();
        int sign = 1;
        //skipping leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        //Handling sign
        while (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        //Convert digit and stop at first non-digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');
            //handling overflow
            if (res * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (res * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign * res);
    }
}
