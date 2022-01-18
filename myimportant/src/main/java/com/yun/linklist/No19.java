package com.yun.linklist;

import com.yun.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author zyk
 * @version 1.0
 * @fileName No19
 * @description :TODO 删除链表倒数第n个节点
 * @date 2022/1/18 11:14
 */
public class No19 {
    //方法1，计算链表长度O(L)O(1)
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 0; i < length - n + 1; i++) {
            cur = cur.next;
        }
        //直接指针改变即可
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    //方法2，栈
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        //deque本质上是双端队列，这里用作栈
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //出栈
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    //方法3，双指针，一个走得快，一个走得慢
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
