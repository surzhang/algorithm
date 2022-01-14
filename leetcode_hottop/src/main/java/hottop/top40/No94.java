package hottop.top40;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No94
 * @Description:
 * @Author: zyk
 * @createTime: 2021/12/19 11:25
 * @version: 1.0
 */
public class No94 {
    //二叉树的中序遍历，迭代
    public List<Integer>inorderTraversal(TreeNode root){
        List<Integer>res = new ArrayList<>();
        //栈
        Deque<TreeNode>stk = new LinkedList<>();
        while (root!=null||!stk.isEmpty()){
            while(root!=null){
                //根节点入栈
                stk.push(root);
                root=root.left;
            }
            //弹出栈顶元素
            root=stk.pop();
            //将值放到结果集中
            res.add(root.val);
            //遍历右节点
            root=root.right;
        }
        return res;
    }


    //递归解法
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer>res =new ArrayList<>();
        inorder(root,res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
