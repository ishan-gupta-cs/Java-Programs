public class implementLowerBound{
    public static void main(String args[]){
        int nums[] = {3,5,8,15,19};
        int x = 9;
        int idx = findLowerBound(nums,x);
        System.out.println(idx);
    }

    public static int findLowerBound(int nums[],int x){
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int ans = nums.length; // default if x is greater than all elements of nums
        while(low<=high){
            mid = low + (high - low)/2;
            if(nums[mid]>=x){
                ans = mid;
                high = mid - 1;
                return mid;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}