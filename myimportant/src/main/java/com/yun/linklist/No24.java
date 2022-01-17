package com.yun.linklist;

import com.yun.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName No24
 * @description :TODO 两两交换链表中节点
 *  1.递归：关注三点：返回值，调用单元做了什么？终止条件，
 *  2.非递归，迭代，新建头节点
 * @date 2022/1/17 16:57
 */
public class No24 {
    //递归解法
    public ListNode swapPairs(ListNode head) {
        //终止条件
        if (head==null||head.next==null){
           return head;
        }
        //需要交换的节点head和next
        ListNode next = head.next;
        //head后链接交换完成的节点
        head.next=swapPairs(next.next);
        //next链接head
        next.next=head;
        //返回值
        return next;
    }
}
