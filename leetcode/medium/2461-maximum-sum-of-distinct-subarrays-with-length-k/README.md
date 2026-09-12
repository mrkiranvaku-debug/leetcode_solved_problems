# Maximum Sum of Distinct Subarrays With Length K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` and an integer `k`. Find the maximum subarray sum of all the subarrays of `nums` that meet the following conditions:

- The length of the subarray is k, and
- All the elements of the subarray are distinct.

Return  *the maximum subarray sum of all the subarrays that meet the conditions**.*  If no subarray meets the conditions, return `0`.

 *A  **subarray**  is a contiguous non-empty sequence of elements within an array.* 

 

 **Example 1:** 

```
Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

```

 **Example 2:** 

```
Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.

```

 

 **Constraints:** 

- 1 <= k <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 31 ms (beats 94.29%)  
**Memory:** 98.5 MB (beats 77.93%)  
**Submitted:** 2026-09-12T04:26:32.620Z  

```java
import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        long sum = 0;
        long maxSum = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // If duplicate comes, remove elements from left
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add current element
            set.add(nums[right]);
            sum += nums[right];

            // Keep window size at most k
            if (right - left + 1 > k) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Window has exactly k distinct elements
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/)