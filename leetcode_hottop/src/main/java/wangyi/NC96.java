package wangyi;

import model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC96
 * @description :TODO 判断一个链表是否为回文结构
 * @date 2022/1/11 14:34
 */
public class NC96 {
    public boolean isPail (ListNode head) {
        // write code here
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseList = reverse(slow);
        ListNode cur1 = reverseList, cur2 = head;
        while(cur1 != null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
