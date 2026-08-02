class Solution {
    public void moveZeroes(int[] nums) {
        int write=0;
        for(int read=0;read<=(nums.length)-1; read++){
            
             if(nums[read]!=0){
                int temp=nums[read];
                nums[read]=nums[write];
                nums[write]=temp;
                write++;

                
            }
        }
    }
}