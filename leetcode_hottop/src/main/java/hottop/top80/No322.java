package hottop.top80;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No332
 * @Description: 打家劫舍2
 * @Author: zyk
 * @createTime: 2021/12/26 16:02
 * @version: 1.0
 */
public class No322 {
    //动态规划
    Map<TreeNode,Integer> f= new HashMap<>();
    Map<TreeNode,Integer> g= new HashMap<>();
    public int rob(TreeNode root){
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    private void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        //f是选中，g是不选中
        f.put(root, root.val + g.getOrDefault(root.left, 0)
                + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));

     
    }

    public int rob2(TreeNode root) {
        int[] rootStatus = dfs2(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs2(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs2(node.left);
        int[] r = dfs2(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
