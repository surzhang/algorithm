package com.yun.linklist;

import com.yun.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName No142
 * @description :TODO 找出带环链表的入口节点
 * @date 2022/1/17 16:57
 */
public class No142 {
    //快慢指针
    public ListNode detectCycle(ListNode head){
        ListNode fast = head,slow=head;
        while(true){
            if (fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)break;
        }
        fast=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
