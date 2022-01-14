package wangyi;

import model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC16
 * @description :TODO 对称二叉树
 * @date 2022/1/11 14:37
 */
public class NC16 {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return issame(pRoot.left,pRoot.right);
    }
    boolean issame(TreeNode left, TreeNode right){
        if(left == null && right!= null){
            return false;
        }
        if(left != null && right ==null){
            return false;
        }
        if(left == null && right == null){
            return true;
        }
        if(left.val != right.val){
            return false;
        }
        boolean outside = issame(left.left,right.right);
        boolean inside  =issame(left.right,right.left);
        return inside&&outside;
    }

}
