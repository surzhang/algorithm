package wangyi;

import model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC3
 * @description :TODO 环形链表2
 * @date 2022/1/11 14:32
 */
public class NC3 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while(true){
            if (fast==null||fast.next==null) {
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)break;
        }
        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
