//Subset with sum divisible by m
/*
Given a set of n non-negative integers, and a value m, determine if there is a subset of the given set with sum divisible by m.
*/
//Recursion method
class Solution
{
    public int DivisibleByM(int [] nums, int m)
    {
        if(recur(nums, nums.length-1, 0, m)==true)
            return 1;
        return 0;
    }
    public boolean recur(int[] nums, int index, int sum, int m){
        if(sum!=0 && sum%m==0)
	        return true;
        if(index<0)
	        return false;
        return (recur(nums, index-1, sum+nums[index], m) ||
            recur(nums, index-1, sum, m));
    }
}
