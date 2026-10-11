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