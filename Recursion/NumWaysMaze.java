class NumWaysMaze{
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        System.out.println(findNumWaysNM(n, m));
    }

    private static int factorial(int n){
        if (n<=1){
            return 1;
        }
        return n * factorial(n-1);
    }

    private static int findNumWays(int n){
        //for NXN grid, we'll always have (N-1) rights and (N-1) downs. So, we can generate the number of ways using (2*(n-1))! / (n-1)! * (n-1)
        int denom = factorial(n-1);
        int num = factorial(2*(n-1));
        return num / (denom * denom);
    }

    private static int findNumWaysNM(int n, int m){
        //for NXM grid, we'll always have (N-1) rights and (M-1) downs. So, we can generate the number of ways using ((m-1)+(n-1))! / (n-1)! * (m-1)
        int denom_n = factorial(n-1);
        int denom_m = factorial(m-1);
        int num = factorial((m-1) + (n-1));
        return num / (denom_n * denom_m);
    }
}