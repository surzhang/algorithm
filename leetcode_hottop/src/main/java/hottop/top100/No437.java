package hottop.top100;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No437
 * @Description: 路径总结3
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
 * @Author: zyk
 * @createTime: 2021/12/23 17:45
 * @version: 1.0
 */
public class No437 {
    public int pathSum(TreeNode root, int targetSum) {
        //深度优先搜索
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;

    }

    public  int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root==null){
            return 0;
        }
        int val = root.val;
        if (val==targetSum){
            ret++;
        }
        ret+=rootSum(root.left,targetSum-val);
        ret+=rootSum(root.right,targetSum-val);
        return ret;
    }


    //前缀和（理解）
    Map<Integer, Integer> map = new HashMap<>();
    int ans, t;
    public int pathSum2(TreeNode root, int _t) {
        if (root == null) {
            return 0;
        }
        t = _t;
        map.put(0, 1);
        dfs(root, root.val);
        return ans;
    }
    void dfs(TreeNode root, int val) {
        if (map.containsKey(val - t)) {
            ans += map.get(val - t);
        }
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) {
            dfs(root.left, val + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, val + root.right.val);
        }
        map.put(val, map.getOrDefault(val, 0) - 1);
    }


}
