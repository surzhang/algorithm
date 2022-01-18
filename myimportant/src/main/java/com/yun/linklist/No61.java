package com.yun.linklist;

import com.yun.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName No61
 * @description :TODO 旋转链表
 * @date 2022/1/18 11:27
 */
public class No61 {
    public ListNode rotateRight(ListNode head,int k){
        if (head==null||k==0){
            return head;
        }
        //链表的长度
        int n = 0;
        //尾结点
        ListNode tail = null;
        for (ListNode p=head;p!= null;p=p.next ) {
            tail = p;
            n++;
        }
        k%=n;
        ListNode p = head;
        for (int i = 0; i <n-k-1 ; i++) {
            p=p.next;
        }
        //尾结点指向头结点
        tail.next=head;
        //头结点设置
        head=p.next;
        //新的尾结点
        p.next=null;
        //返回头结点
        return head;
    }
}
