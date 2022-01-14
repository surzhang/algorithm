package hottop.top80;

import model.TreeNode;

import java.util.LinkedList;

/**
 * @FileName: No226
 * @Description: 翻转二叉树
 * @Author: zyk
 * @createTime: 2021/12/26 16:07
 * @version: 1.0
 */
public class No226 {
    public TreeNode inverseTree(TreeNode root){
        if (root==null){
            return null;
        }
        TreeNode temp = root.right;
        root.left=root.right;
        root.left=temp;

        inverseTree(root.right);
        inverseTree(root.left);
        return root;
    }
//迭代
public TreeNode invertTree(TreeNode root) {
    if(root==null) {
        return null;
    }
    //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while(!queue.isEmpty()) {
        //每次都从队列中拿一个节点，并交换这个节点的左右子树
        TreeNode tmp = queue.poll();
        TreeNode left = tmp.left;
        tmp.left = tmp.right;
        tmp.right = left;
        //如果当前节点的左子树不为空，则放入队列等待后续处理
        if(tmp.left!=null) {
            queue.add(tmp.left);
        }
        //如果当前节点的右子树不为空，则放入队列等待后续处理
        if(tmp.right!=null) {
            queue.add(tmp.right);
        }

    }
    //返回处理完的根节点
    return root;
}
}
