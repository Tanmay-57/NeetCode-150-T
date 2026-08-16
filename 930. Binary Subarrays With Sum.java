class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Calculate the number of subarrays with sum exactly equal to 'goal'
        // by subtracting the number of subarrays with sum less than 'goal'
        // from the number of subarrays with sum less than or equal to 'goal'.
        return fun(nums, goal) - fun(nums, goal - 1);
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
