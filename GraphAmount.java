import java.util.*;
class Solution
{
    static class Graph{
        int x;
        int y;
        long l;
        long a;
        Graph(int x, int y, long l, long a){
            this.x=x;
            this.y=y;
            this.l=l;
            this.a=a;
        }
    }
    public static long findGCD(long a, long b){
        if(b==0){
            return a;
        }
        return findGCD(b, a%b);
    }
    public static void solveGraph(ArrayList<ArrayList<Graph>> graph, 
        int startingCity, int destination, long weight, boolean[] visited
        , ArrayList<Long> ar){
        if(startingCity==destination){
            return;
        }
        visited[startingCity]=true;
        for(Graph g :graph.get(startingCity)){
            if(visited[g.y]==false){
                if(weight >= g.l){
                    ar.add(g.a);
                }
                solveGraph(graph, g.y, destination, weight, visited, ar);
            }
            ar.remove(new Long(g.a));
        }
        visited[startingCity]=false;
    }
    public static void solvegcd(ArrayList<Long> ar){
        Long ansgcd=0L;
        for(int i=0;i<ar.size();i++){
            ansgcd=findGCD(ar.get(i), ansgcd);
        }
        System.out.print(" "+ansgcd);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		for(int itr=1;itr<=testcases;itr++){
		   int nodes=sc.nextInt();
		   int query=sc.nextInt();
		   ArrayList<ArrayList<Graph>> graph=new ArrayList<>(nodes);
		   for(int i=0;i<nodes;i++){
		       graph.add(new ArrayList<Graph>());
		   }
		   for(int n=1;n<=nodes-1;n++){
		       int x=sc.nextInt();
		       int y=sc.nextInt();
		       Long loadLimit=sc.nextLong();
		       Long Amount=sc.nextLong();
		       graph.get(x-1).add(new Graph(x-1,y-1,loadLimit,Amount));
		       graph.get(y-1).add(new Graph(y-1,x-1,loadLimit,Amount));
		   }
		   System.out.print("Case #"+itr+":");
		   for(int q=1;q<=query;q++){
		       int startingCity=sc.nextInt();
		       long weight=sc.nextLong();
		       boolean[] visited=new boolean[nodes];
		       ArrayList<Long> ar=new ArrayList<>();
		       solveGraph(graph, startingCity-1, 0, weight, visited, ar);
		       for(int i=0;i<ar.size();i++){
		           System.out.print("query="+ar.get(i));
		       }
		       System.out.println("change");
		       solvegcd(ar);
		   }
		   System.out.println();
		}
	}
}
