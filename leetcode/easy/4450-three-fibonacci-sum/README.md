# Q1. Three Fibonacci Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer `n`.

The  **Fibonacci sequence**  starts with 0 and 1, and each subsequent number is the sum of the previous two numbers. Its first few terms are `0, 1, 1, 2, 3, 5, 8, 13,...`.

Return `true` if `n` can be expressed as the sum of  **three consecutive terms**  in the Fibonacci sequence, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  n = 16

 **Output:**  true

 **Explanation:** 

The three consecutive terms 3, 5, and 8 have a sum of `3 + 5 + 8 = 16`.

 **Example 2:** 

 **Input:**  n = 8

 **Output:**  false

 **Explanation:** 

Although `1 + 2 + 5 = 8`, these terms are not consecutive in the Fibonacci sequence. No three consecutive terms have a sum of 8.

 **Example 3:** 

 **Input:**  n = 2

 **Output:**  true

 **Explanation:** 

The first three terms have a sum of `0 + 1 + 1 = 2`.

 

 **Constraints:** 

- 1 <= n <= 109

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 42.5 MB (beats 75.00%)  
**Submitted:** 2026-10-11T02:47:03.305Z  

```java
class Solution {
    public boolean threeFibonacciSum(int n) {
        // If n is odd, it cannot be expressed as 2 * F_{k+2}
        if (n % 2 != 0) {
            return false;
        }
        
        int target = n / 2;
        
        if (target == 0 || target == 1) {
            return true;
        }
        
        int a = 0;
        int b = 1;
        
        while (b <= target) {
            if (b == target) {
                return true;
            }
            int next = a + b;
            a = b;
            b = next;
        }
        
        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/three-fibonacci-sum/)