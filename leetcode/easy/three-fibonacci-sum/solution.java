class Solution {
    public boolean threeFibonacciSum(int n) {
        if ((n & 1) != 0) return false; // Quick bitwise check for odd numbers
        
        int target = n >> 1; // Division by 2 via bit shift
        if (target <= 1) return true;
        
        int a = 0, b = 1;
        while (b < target) {
            int next = a + b;
            a = b;
            b = next;
        }
        
        return b == target;
    }
}