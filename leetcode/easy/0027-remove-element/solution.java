class Solution {
    public int removeElement(int[] nums, int val) {
        int write=0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]!=val){


                 
                 nums[write]=nums[i];
                 write++;
            }
        }
        return write;
    }
}