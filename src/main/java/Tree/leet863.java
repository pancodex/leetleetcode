package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 */

/**
 * 思路: 哈希表存储节点的父节点,通过dfs查找深度为k的节点
 */

public class leet863 {
    Map<Integer,TreeNode> parents = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //记录每个节点的父节点
        findParents(root);

        // 从target出发DFS,查找深度为k的节点
        findAns(target, null,0, k);

        return ans;
    }

    public void findParents(TreeNode node){
        if(node.left != null){
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if(node.right != null){
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k){
        if(node == null){
            return ;
        }
        if(depth == k){
            ans.add(node.val);
        }
        if(node.left != from){
            findAns(node.left,node,depth+1,k);
        }
        if(node.right != from){
            findAns(node.right,node,depth+1,k);
        }
        // 父节点不是from的话
        if(parents.get(node.val) != from){
            findAns(parents.get(node.val), node, depth+1, k);
        }

    }


}
