# Maximum Average Subarray I

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer array `nums` consisting of `n` elements, and an integer `k`.

Find a contiguous subarray whose  **length is equal to**  `k` that has the maximum average value and return  *this value*. Any answer with a calculation error less than `10-5` will be accepted.

 

 **Example 1:** 

```
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

```

 **Example 2:** 

```
Input: nums = [5], k = 1
Output: 5.00000

```

 

 **Constraints:** 

- n == nums.length
- 1 <= k <= n <= 105
- -104 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 73.92%)  
**Memory:** 69.8 MB (beats 10.45%)  
**Submitted:** 2026-09-05T14:20:54.973Z  

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for (int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        int maxsum=sum;
        for(int i=k; i<nums.length; i++)
        {
            sum-=nums[i-k];
            sum+=nums[i];
            maxsum=Math.max(maxsum, sum);
        }
        return(double) maxsum/k;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-average-subarray-i/)