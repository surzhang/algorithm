package hottop.top60;

import model.ListNode;

/**
 * @FileName: No206
 * @Description: 翻转链表
 * @Author: zyk
 * @createTime: 2021/12/20 9:32
 * @version: 1.0
 */
public class No206 {
    //定义新节点
    public ListNode reverseList(ListNode head){
        ListNode newhead =null;
        while(head!=null){
            //先定义下一个节点
            ListNode next = head.next;
            //节点指针指向前一个节点
            head.next = newhead;
            //新的链表节点右移
            newhead=head;
            //原来链表节点指针右移
            head=next;
        }
        return newhead;
    }

//递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
