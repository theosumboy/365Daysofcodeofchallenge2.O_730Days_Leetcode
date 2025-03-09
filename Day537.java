class Solution {
    public int[] closestPrimes(int left, int right) {
        // Create a boolean array to mark prime numbers
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true); // Initially assume all numbers are prime

        isPrime[1] = false; // 1 is not a prime number

        // Use the Sieve of Eratosthenes to mark non-prime numbers
        for (int i = 2; i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= right; j += i) {
                    isPrime[j] = false; // Mark multiples of i as non-prime
                }
            }
        }
        

        // Store all prime numbers within the given range
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) primes.add(i);
        }

        // Initialize the answer array with default values (-1, -1) 
        // in case no valid prime pair is found
        int[] ans = {-1, -1};
        int diff = Integer.MAX_VALUE; // Variable to store the minimum prime gap

        // Iterate through the prime list to find the closest pair
        for (int j = primes.size() - 1; j > 0; j--) { // Iterate from the last element
            int d = primes.get(j) - primes.get(j - 1); // Difference between adjacent primes
            if (d <= diff) { // If we find a smaller gap or the same gap but a smaller first element
                diff = d;
                ans = new int[]{primes.get(j - 1), primes.get(j)};
            }
        }

        return ans; // Return the closest prime pair
    }
}
