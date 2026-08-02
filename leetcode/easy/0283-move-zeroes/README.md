# Move Zeroes

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

 **Note**  that you must do this in-place without making a copy of the array.

 

 **Example 1:** 

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [0]

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -231 <= nums[i] <= 231 - 1

 

 **Follow up:**  Could you minimize the total number of operations done?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 92.12%)  
**Memory:** 47.8 MB (beats 57.85%)  
**Submitted:** 2026-08-02T03:40:54.274Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/move-zeroes/)