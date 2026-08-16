class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        // make the array into binarry by 1 for odd and 0 for even
        int[] binarySubArray = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                binarySubArray[i]=0; // if even enter 0;
            }else{
                binarySubArray[i]=1; // if odd enter 1;
            }
        }

        return  fun(binarySubArray, k) - fun(binarySubArray, k - 1);
    }

    int fun(int[] nums, int goal) {
        if (goal < 0) {
            // If the goal is negative, return 0 since there can't be any
            // subarray with a negative sum in a binary array.
            return 0;
        }
        
        int l = 0, r = 0, sum = 0, count = 0;
        while (r < nums.length) {
            sum += nums[r];
            // If the sum exceeds the goal, shrink the window from the left
            while (sum > goal) {
                sum =sum - nums[l];
                l++;
            }
            //The number of subarrays with sum less than or equal to 'goal' ending at 'r' is (r - l + 1)
            count = count +(r - l + 1);
            r++;
        }
        return count;
    }
}
