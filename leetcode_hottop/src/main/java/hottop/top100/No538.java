package hottop.top100;

import model.TreeNode;

/**
 * @FileName: No538
 * @Description: 二叉树的直径
 * @Author: zyk
 * @createTime: 2021/12/22 11:05
 * @version: 1.0
 */
public class No538 {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }


//.把二叉搜索树转换为累加树，反序中序遍历
    int sum = 0;
    public TreeNode convertBST(TreeNode root){
        if (root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }

}
