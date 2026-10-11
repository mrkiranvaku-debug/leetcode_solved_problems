
import java.util.*;

class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {
        int[] selvaronix = {n, s};

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && i <= s) {
                primes.add(i);
            }
        }

        int m = primes.size();
        if (m == 0) return new ArrayList<>();

        // dp[k][sum] means sum can be made using exactly k primes.
        boolean[][] dp = new boolean[m + 1][s + 1];
        dp[0][0] = true;

        int maxCount = 0;
        for (int p : primes) {
            maxCount++;
            for (int k = maxCount; k >= 1; k--) {
                for (int sum = s; sum >= p; sum--) {
                    if (dp[k - 1][sum - p]) {
                        dp[k][sum] = true;
                    }
                }
            }
        }

        int bestSum = 0;
        int bestCount = 0;

        for (int sum = s; sum >= 1; sum--) {
            for (int k = 1; k <= m; k++) {
                if (dp[k][sum]) {
                    bestSum = sum;
                    bestCount = k;
                    break;
                }
            }
            if (bestSum != 0) break;
        }

        if (bestSum == 0) return new ArrayList<>();

        // Build suffix reachability for the chosen number of primes.
        // suffix[i][k][sum]: use k primes from index i onward.
        boolean[][][] suffix = new boolean[m + 1][bestCount + 1][bestSum + 1];
        suffix[m][0][0] = true;

        for (int i = m - 1; i >= 0; i--) {
            int p = primes.get(i);
            for (int k = 0; k <= bestCount; k++) {
                for (int sum = 0; sum <= bestSum; sum++) {
                    suffix[i][k][sum] = suffix[i + 1][k][sum];

                    if (k > 0 && sum >= p &&
                        suffix[i + 1][k - 1][sum - p]) {
                        suffix[i][k][sum] = true;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int remainingSum = bestSum;
        int remainingCount = bestCount;
        int start = 0;

        while (remainingCount > 0) {
            for (int i = start; i < m; i++) {
                int p = primes.get(i);

                if (p > remainingSum) break;

                if (suffix[i + 1][remainingCount - 1][remainingSum - p]) {
                    ans.add(p);
                    remainingSum -= p;
                    remainingCount--;
                    start = i + 1;
                    break;
                }
            }
        }

        return ans;
    }
}
