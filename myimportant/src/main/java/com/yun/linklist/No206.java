package com.yun.linklist;

import com.yun.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName No206
 * @description :TODO 翻转链表
 * @date 2022/1/17 16:57
 */
public class No206 {
    //方法1：递归
    public ListNode reverseList(ListNode head){
        //终止条件
        if (head==null||head.next==null){
            return head;
        }
        //调用单元,反转头结点之后的链表,返回头结点
        ListNode newHead = reverseList(head.next);
        //1<--2
        head.next.next=head;
        //null<--1
        head.next=null;
        //返回值
        return newHead;
    }
    //方法2：迭代
    public ListNode reverseList2(ListNode head) {
        //新的尾节点
        ListNode prev = null;
        //当前节点
        ListNode curr = head;
        while (curr != null) {
            //就是互换next,prev,curr
            ListNode next = curr.next;
            //将当前节点的next 指针改为指向前一个节点
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
