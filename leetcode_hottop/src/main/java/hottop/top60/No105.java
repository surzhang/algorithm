package hottop.top60;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No105
 * @Description: 从前序和中序遍历构造二叉树
 * @Author: zyk
 * @createTime: 2021/12/19 11:25
 * @version: 1.0
 */
public class No105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();

        for (int i = 0; i <inorder.length ; i++) {
            inMap.put(inorder[i],i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
