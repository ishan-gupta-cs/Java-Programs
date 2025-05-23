public class koko {
    public static void main(String[] args) {
        int piles[] = { 3, 6, 7, 11 }, h = 8;
        int ans = minEatingSpeed(piles, h);
        System.out.println(ans);

        piles = new int[] { 30, 11, 23, 4, 20 };
        h = 5;
        ans = minEatingSpeed(piles, h);
        System.out.println(ans);

        piles = new int[] { 30, 11, 23, 4, 20 };
        h = 6;
        ans = minEatingSpeed(piles, h);
        System.out.println(ans);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low, high, mid;
        int k = 0, max = 0;
        for (int n : piles) {
            max = Math.max(max, n);
        }
        low = 1;
        high = max;
        mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (canEat(piles, h, mid)) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return k;
    }

    public static boolean canEat(int piles[], int h, int k) {
        int totalTime = 0;
        for (int n : piles) {
            totalTime += Math.ceil((double) n / k);
        }
        return totalTime <= h;
    }
}
