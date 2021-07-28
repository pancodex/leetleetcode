package Tree;


/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 思路：通过dfs  找出大于rootvalue的最小值,即为所有节点中第二小的值
 * ans初始化为-1，用于存放比根节点大的最小值
 * 遍历完二叉树后返回ans。
 */


public class leet671 {


    int ans;
    int rootvalue;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node){
        if(node==null){
            return ;
        }
        if(ans!=-1 && node.val >= ans){
            return ;
        }

        if(node.val>rootvalue){
            ans=node.val;
        }
        dfs(node.left);
        dfs(node.right);

    }



    public static void main(String[] args) {

    }
}

































