package wangyi;

import model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC66
 * @description :TODO 两个链表的第一个公共节点
 * @date 2022/1/11 14:33
 */
public class NC66 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}