package hottop.top20;

import model.ListNode;

/**
 * @ fileName:No19
 * @ description:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @ author:zyk
 * @ createTime:2021/12/13 20:41
 * @ version:1.0.0
 */
public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //哑结点
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i <length-n+1 ; i++) {
            cur=cur.next;
        }
        cur.next=cur.next.next;
        //结果链表
        ListNode ans = dummy.next;
        return ans;

    }

    private int getLength(ListNode head) {
        int length=0;
        while (head != null){
            ++length ;
            head=head.next;
        }
        return length;
    }


}
