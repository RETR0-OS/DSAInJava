
public class powerSum {
    public static void main(String[] args) {
        int n = 10;
        int k = 2;
        int ans = powerSumCalc(n, k);
        System.out.println(ans);
    }

    static int powerSumHelper(int n, int k, int current) {
        // Base case: If the sum matches n, this is a valid solution
        if (n == 0) {
            return 1;
        }
        // If the sum exceeds n or the current number is too large, stop recursion
        if (n < 0 || Math.pow(current, k) > n) {
            return 0;
        }
        // Two choices: include current^k or skip it
        int include = powerSumHelper(n - (int)Math.pow(current, k), k, current + 1);
        int exclude = powerSumHelper(n, k, current + 1);

        return include + exclude;
    }

    static int powerSumCalc(int n, int k) {
        return powerSumHelper(n, k, 1); // Start with the smallest number, 1
    }

    ((n%10**i)/(10**i) - (n%(10**(i-1)))/(10 **(i-1)), i+1, s)
}
