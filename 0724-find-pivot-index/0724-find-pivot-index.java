class Solution {
    public int pivotIndex(int[] nums) {
        int total=0,i;
        for( i=0;i<nums.length;i++){
            total += nums[i];
        }
        int left_sum=0;
        for(i=0;i<nums.length;i++){
            if(left_sum == total - left_sum - nums[i]){
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}