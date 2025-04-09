import java.util.Arrays;
class kokoBanana{
    public static void main(String[] args) {
        int[] piles = {312884470};
        System.out.println(findHrs(piles, 312884469));
    }

    private static int findHrs(int[] piles, int k){
        int i = 0;
        int hrs = 0;
        while (true){
            piles[i] = Math.max(0, piles[i] - k);
            System.out.println("Updated to: " + piles[i]);
            if (piles[i] == 0){
                i++;
            }
            hrs++;
            if (i==piles.length){
                break;
            }
        }
        System.out.println("Hours: "+hrs + " k: " + k);
        return hrs;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int minSpeed = 0;
        int maxSpeed = 0;

        Arrays.sort(piles);

        for(int i=0; i<piles.length; i++){
            int[] pile_cpy = new int[piles.length];
            System.arraycopy(piles, 0, pile_cpy, 0, piles.length);
            int hrs = findHrs(pile_cpy, piles[i]);
            if (hrs > h){
                minSpeed = piles[i];
            }
            else if (hrs < h){
                maxSpeed = piles[i];
                break;
            }
            else if (hrs == h){
                return piles[i];
            }
        }

        
        //Perform BS
        while (minSpeed <= maxSpeed){
            int mid = (minSpeed + maxSpeed) / 2;

            if (findHrs(piles, mid) == h){
                return mid;
            }
            else if(findHrs(piles, mid) < h){
                maxSpeed = mid - 1;
            }
            else if(findHrs(piles, mid) > h){
                if (findHrs(piles, mid+1) < h){
                    return mid;
                }
                minSpeed = mid + 1;
            }
        }
        return -1;
    }
}