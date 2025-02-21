class SqrRootBS{
    public static void main(String[] args){
        System.out.println(mySqrt(2147395599L));

    }

    public static long mySqrt(long x) {
        long min = 0L;
        long max = x;
        long target = x;
        long middle = 0L;

        if (x==0L){
            return 0;
        }
        else if (x==1L){
            return 1;
        }

        
        while (min <= max){
            middle = (min + max)/2;
            long m_sq = middle * middle;
            long res = m_sq - target;
            if (res > 0) {
                max = middle -1;
            }
            else{
                if (res == 0L){
                    return middle;
                }
                else if(res < 0L && (middle+1)*(middle+1) > target){
                    return middle;
                }
                else{
                    min = middle + 1;
                }
            }
        }
        return -1;
        
    }
}