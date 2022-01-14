package hottop.top60;

import model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @FileName: No114
 * @Description: 二叉树展开为一个链表
 * @Author: zyk
 * @createTime: 2021/12/19 11:26
 * @version: 1.0
 */
public class No114 {
    //前序遍历1.递归
    public void flatten(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root,list);
        int size = list.size();
        for (int i=1;i<size;i++){
            TreeNode prev = list.get(i-1),cur=list.get(i);
            prev.left = null;
            prev.right=cur;
        }
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root!=null){
            list.add(root);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }

//方法二，迭代
    public void flatten2(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        //栈
        Deque<TreeNode>stack = new ArrayDeque<>();
        TreeNode node = root;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                list.add(node);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
        for (int i = 1; i <list.size() ; i++) {
            TreeNode prev  =list.get(i-1),curr = list.get(i);
            prev.left=null;
            prev.right=curr;
        }
    }

}
