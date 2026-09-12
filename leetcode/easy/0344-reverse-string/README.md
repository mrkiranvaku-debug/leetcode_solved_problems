# Reverse String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array in-place with `O(1)` extra memory.

 

 **Example 1:** 

```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

```

 **Example 2:** 

```
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s[i] is a printable ascii character.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 47.8 MB (beats 96.56%)  
**Submitted:** 2026-09-12T04:52:45.143Z  

```java
class Solution {
    public void reverseString(char[] s) {
        int  first=0;
        int last=(s.length)-1;
        while (first<last){
            char temp=s[first];
            s[first]=s[last];
            s[last]=temp;
            first++;
            last--;
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-string/)