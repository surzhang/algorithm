package hottop.top60;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: No160
 * @Description: 相交链表
 * @Author: zyk
 * @createTime: 2021/12/20 9:31
 * @version: 1.0
 */
public class No160 {
    //双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA==null||headB==null){
            return null;
        }
        ListNode p=headA,q=headB;
        while(p!=q){
            p = p==null?headB:p.next;
            q = q==null?headA:q.next;
        }
        return p;
    }

    //哈希表
    public ListNode getIntersectionNode2(ListNode head1, ListNode head2){
        Set<ListNode> visited =new HashSet<>();
        ListNode temp  =head1;
        while(temp!=null){
            visited.add(temp);
            temp=temp.next;
        }
        temp  =head2;
        while(temp!=null){
            if (visited.contains(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}
