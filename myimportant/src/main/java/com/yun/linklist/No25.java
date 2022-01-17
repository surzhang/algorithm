package com.yun.linklist;

import com.yun.model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName No25
 * @description :TODO K个一组翻转链表
 * @date 2022/1/17 16:57
 */
public class No25 {
    //递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            //find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        //返回值
        return head;
    }
}
