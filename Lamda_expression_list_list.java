import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public List<List<Integer>> lv(List<Integer> eff, List<Integer> speed){
        //System.out.println("KII");
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<eff.size();i++){
            ans.add(Arrays.asList(eff.get(i), speed.get(i)));
        }
        return ans;
    }
}
class C
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Integer> p=new ArrayList<>();
        p.add(8);p.add(80);
        p.add(16);p.add(98);p.add(28);
        p.add(34);
        p.add(3);
        p.add(15);
        List<Integer> r=new ArrayList<>();
         r.add(8);r.add(11);
        r.add(6);r.add(9);r.add(2);
        r.add(4);
        r.add(3);
        r.add(1);
        Solution s=new Solution();
        List<List<Integer>> ans=s.lv(p, r);
        Collections.sort(ans, (a, b) -> a.get(1) - b.get(1) );
        for(int i=0;i<ans.size();i++){
            System.out.print(p.get(i) +" ");
        }
        System.out.println();
        for(int i=0;i<ans.size();i++){
            System.out.print(r.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i).get(0) + "|" + ans.get(i).get(1) + " && ");
        }
	}
}
