import java.util.*;
class Solution
{
    public static String lockdown(long t, long h, long j){
        if(h%j==0){
            return "YES";
        }
        else{
            long val=((t+1)-h)/j;
            if(val==h){
                return "YES";
            }else{
                return "NO";
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		long test=sc.nextLong();
		while(test-->0){
		    long tiles=sc.nextLong();
		    long holes=sc.nextLong();
		    long jumps=sc.nextLong();
		    System.out.println(lockdown(tiles, holes, jumps));
		}
	}
}
