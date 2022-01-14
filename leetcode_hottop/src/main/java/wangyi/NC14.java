package wangyi;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC14
 * @description :TODO 之字型打印二叉树
 * @date 2022/1/11 14:33
 */
public class NC14 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot,1,list);
        for(int i=0;i<list.size();i++){
            if(i%2!=0){
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root==null)
            return;
        if(depth>list.size()){
            list.add(new ArrayList<Integer>());
        }
        list.get(depth-1).add(root.val);
        depth(root.left,depth+1,list);
        depth(root.right,depth+1,list);
    }
}
