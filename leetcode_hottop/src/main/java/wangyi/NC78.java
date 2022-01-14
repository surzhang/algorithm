package wangyi;

import model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC78
 * @description :TODO 翻转链表
 * @date 2022/1/11 11:58
 */
public class NC78 {
    public ListNode ReverseList(ListNode head){
        ListNode pre = null;
        while(head!=null){
            //定义下一个节点
            ListNode next=head.next;
            //头结点指向null
            head.next=pre;
            //pre变为右节点
            pre = head;
            //链表头结点变为下一个节点
            head=next;
        }
        return pre;
    }
}
