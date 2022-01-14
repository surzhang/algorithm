package hottop.top60;

import model.TreeNode;

/**
 * @FileName: No124
 * @Description: 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。

 * @Author: zyk
 * @createTime: 2021/12/19 11:26
 * @version: 1.0
 */
public class No124 {
    //递归
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root==null){
            return 0;
        }
        //递归计算左右子节点的最大贡献值
        //只有在最大贡献值大于0时，才会选择对应的子节点
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);

        //节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewPath = root.val+leftGain+rightGain;
        //更新答案
        maxSum = Math.max(maxSum,priceNewPath);
        //返回节点的最大贡献值
        return root.val+Math.max(leftGain,rightGain);
    }

}
