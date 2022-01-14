package wangyi;

import model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC72
 * @description :TODO 二叉树的镜像
 * @date 2022/1/11 14:36
 */
public class NC72 {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        TreeNode tmp;
        if(pRoot == null) return pRoot;
        tmp = pRoot.right;
        pRoot.right = pRoot.left;
        pRoot.left = tmp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
