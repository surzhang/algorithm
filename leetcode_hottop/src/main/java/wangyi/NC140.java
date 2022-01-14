package wangyi;


import model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC140
 * @description :TODO 给定一棵二叉树，分别按照二叉树先序，中序和后序打印所有的节点。
 * @date 2022/1/11 12:12
 */
public class NC140 {
    ArrayList<Integer> list = new ArrayList<>();

    public int[][] threeOrders (TreeNode root) {
        int[][] ret = new int[3][];

        dfs_1(root);
        ret[0] = list_arr();
        list.clear();

        dfs_2(root);
        ret[1] = list_arr();
        list.clear();

        dfs_3(root);
        ret[2] = list_arr();
        list.clear();

        return ret;
    }
    /*
    public void dfs_1 (TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        dfs_1(root.left);
        dfs_1(root.right);
    }
    */
    public void dfs_2 (TreeNode root) {
        if(root == null) return;
        //dfs_1(root.left);
        dfs_2(root.left);
        list.add(root.val);
        dfs_2(root.right);
    }

    public void dfs_3 (TreeNode root) {
        if(root == null) return;
        dfs_3(root.left);
        dfs_3(root.right);
        list.add(root.val);
    }
    public void dfs_1 (TreeNode root) {
        if(root==null)  return;
        TreeNode tmp = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tmp);  //根节点入栈
        while(!stack.isEmpty()) {
            //1.访问根节点
            TreeNode node=stack.pop();
            list.add(node.val);
            //2.如果根节点存在右孩子，则将右孩子入栈
            if(node.right != null) {
                stack.push(node.right);
            }
            //3.如果根节点存在左孩子，则将左孩子入栈
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public int[] list_arr(){
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
