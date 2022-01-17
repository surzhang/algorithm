package com.yun.linklist;

import com.yun.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName No141
 * @description :TODO 环形链表
 * @date 2022/1/17 16:57
 */
public class No141 {
    //快慢指针
    public boolean hasCycle(ListNode head){
        if (head==null){
            return false;
        }
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
