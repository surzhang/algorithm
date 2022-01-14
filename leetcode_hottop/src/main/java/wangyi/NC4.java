package wangyi;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC4
 * @description :TODO 判断链表中是否有环
 * @date 2022/1/11 14:32
 */
public class NC4 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    //快慢指针
    public boolean hasCycle2(ListNode head) {
        if (head==null)return false;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)return true;
        }
        return false;
    }

}
