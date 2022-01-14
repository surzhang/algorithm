package hottop.top60;

import model.ListNode;

/**
 * @FileName: No141
 * @Description:
 * @Author: zyk
 * @createTime: 2021/12/19 11:26
 * @version: 1.0
 */
public class No141 {
    public boolean hasCycle(ListNode head) {
        if (head==null) {
            return false;
        }
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                return true;
            }
        }
        return false;
    }
}
