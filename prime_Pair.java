//we have given a range and from that range we need to find out prime number and from all these prime numbers we need to find the maximum difference
import java.io.*;
import java.util.*;
public class CandidateCode {
    public static ArrayList sieveOfEratosthenes(int l, int r)
    {
        boolean prime[] = new boolean[r + 1];
        for (int i = 0; i <= r; i++)
            prime[i] = true;
        for (int p = 2; p * p <= r; p++)
        {
            if (prime[p] == true)
            {
                for (int i = p * p; i <= r; i += p)
                    prime[i] = false;
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        for (int i = l; i <= r; i++)
        {
            if (prime[i] == true)
                ar.add(i);
        }
        return ar;
    }
    public static int diff(ArrayList<Integer> ar)
    {
        int diff = Integer.MIN_VALUE;
        int n = ar.size();
        int max_so_far = ar.get(n-1);
        for (int i = n - 2; i >= 0; i--)
        {
            if (ar.get(i) > max_so_far) {
                max_so_far = ar.get(i);
            }
            else {
                diff = Integer.max(diff, max_so_far -ar.get(i));
            }
        }
        return diff;
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while(test-- > 0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            ArrayList<Integer> arrlist=sieveOfEratosthenes(l, r);
            if(arrlist.size()==0){
                System.out.println(-1);
            }else if(arrlist.size()==1){
                System.out.println(0);
            }else{
                int temp=diff(arrlist);
                System.out.println(temp);
            }
        }
   }
}
