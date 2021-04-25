public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    static class QNode{
    TreeNode k;
    int idx;
    QNode(TreeNode k, int idx){
            this.k=k;
            this.idx=idx;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<QNode> q=new LinkedList<>();
        TreeMap<Integer, List<Integer>> tm=new TreeMap<>();
        int ind=0;
        q.add(new QNode(root, ind));
        tm.put(ind, new ArrayList<Integer>(Arrays.asList(root.val)));
        while(!q.isEmpty()){
            QNode cur=q.poll();
            TreeNode key=cur.k;
            int index=cur.idx;
            int tmpidx=index;
            //left
            if(key.left!=null){
                tmpidx=index-1;
                q.add(new QNode(key.left, tmpidx));
                if(tm.get(tmpidx)==null){
                    tm.put(tmpidx, new ArrayList<Integer>(Arrays.asList(key.left.val)));
                }else{
                    List<Integer> list=tm.get(tmpidx);
                    list.add(key.left.val);
                }
            }
            // right 
            if(key.right!=null){
                tmpidx=index+1;
                q.add(new QNode(key.right, tmpidx));
                if(tm.get(tmpidx)==null){
                    tm.put(tmpidx, new ArrayList<Integer>(Arrays.asList(key.right.val)));
                }else{
                    List<Integer> list=tm.get(tmpidx);
                    list.add(key.right.val);
                }
            }
        }
        List<List<Integer>> ansList=new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: tm.entrySet()){
            int mapk=entry.getKey();
            List<Integer> ans=new ArrayList<>();
            List<Integer> getlistmap=entry.getValue();
            for(Integer i: getlistmap){
                ans.add(i);
            }
            ansList.add(ans);
        }
        return ansList;
    }
}
