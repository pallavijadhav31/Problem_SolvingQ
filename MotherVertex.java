import java.util.*;
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int v=7, e=8;
		int[][] a=new int[][]{{0,2},{5,2},{6,0},{4,1},{1,3},{6,4},{0,1},{5,6}};
		List<List<Integer>> graph=new ArrayList<>();
		for(int i=0;i<v;i++){
		   graph.add(new ArrayList<>());
		}
		for(int i=0;i<e;i++){
		    graph.get(a[i][0]).add(a[i][1]);
		}
		boolean[] visited=new boolean[graph.size()];
		for(int i=0;i<v;i++){
		    Arrays.fill(visited, false);
		    if(!visited[i]){
		        int count;
		        count=dfs(graph, i, visited, 0);
		        if(count==v-1){
		            System.out.println(i);
		        }
		    }
		}
	}
	public static int dfs(List<List<Integer>> graph, int ver, boolean[] visited,
	int count){
	    visited[ver]=true;
	    for(Integer nbr: graph.get(ver)){
	        if(!visited[nbr]){
	            //System.out.println(nbr);
	            count++;
	            count=dfs(graph, nbr, visited, count);
	        }
	    }
	    return count;
	}
}
