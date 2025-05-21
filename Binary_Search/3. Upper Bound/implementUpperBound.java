public class implementUpperBound{
    public static void main(String args[]){
        int n = 5; 
        int nums1[] = {3,5,8,15,19};
        int x = 9;
        int idx = findUpperBound(n,nums1,x);
        System.out.println(idx);

        n = 4; 
        int nums2[] = {1,2,2,3};
        x = 2;
        idx = findUpperBound(n,nums2,x);
        System.out.println(idx);
    }

    public static int findUpperBound(int n,int nums[],int x){
        int low = 0;
        int high = n-1;
        int mid;
        int ans = n; // default if x is greater than all elements of nums
        while(low<=high){
            mid = low + (high - low)/2;
            if(nums[mid]>x){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}