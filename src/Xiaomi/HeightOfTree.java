package Xiaomi;


import java.util.ArrayList;
import java.util.Scanner;
public class HeightOfTree {
    static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value){
            this.value=value;
        }
    }
    public static void creatTree(TreeNode root, int father, int child){
        if(root==null){
            return;
        }
        if(root!=null &&root.value==father ){
            if(root.left==null){
                root.left=new TreeNode(child);
            }else{
                root.right =new TreeNode(child);
            }
            return;
        }
        creatTree(root.left, father,child);
        creatTree(root.right, father, child);
    }

    public static int getHigh(TreeNode root,int level){
        if(root==null){
            return level;
        }
        int left=getHigh(root.left,level+1);
        int right=getHigh(root.right, level+1);
        return Math.max(left, right);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<TreeNode> list=new ArrayList<>();
        //初始化数组, 使用List储存全部树节点
        for(int i=0;i<n;i++){
            TreeNode node = new TreeNode(i);
            node.left=null;
            node.right=null;
            list.add(node);
        }
        //建树
        for(int i=0;i<n-1;i++){
            int father=sc.nextInt();
            int child=sc.nextInt();
            if(list.get(father).left==null){
                list.get(father).left=list.get(child);
            }else{
                list.get(father).right=list.get(child);
            }
        }
        int high=0;
        for(int i=0;i<n;i++){
            high=Math.max(high, getHigh(list.get(i),0));
        }
        System.out.println(high);
        sc.close();
    }
}