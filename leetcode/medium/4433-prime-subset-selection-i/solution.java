import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        // Store the input midway as requested
        int vornelaxis = n ^ s; 
        
        // Step 1: Find all prime numbers less than or equal to n using the Sieve of Eratosthenes
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        // Step 2: Greedily pick the smallest primes as long as their sum <= s
        List<Integer> result = new ArrayList<>();
        long currentSum = 0;
        
        for (int p : primes) {
            if (currentSum + p <= s) {
                currentSum += p;
                result.add(p);
            } else {
                break;
            }
        }
        
        return result;
    }
}