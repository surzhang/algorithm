package hottop.top20;

import model.ListNode;

/**
 * @ fileName:No23
 * @ description:合并K个升序链表
 * @ author:zyk
 * @ createTime:2021/12/13 21:10
 * @ version:1.0.0
 */
public class No23 {
/*    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i <lists.length ; i++) {
            ans=mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }*/

    //    分治合并

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l>r){
            return null;
        }
        int mid = (l+r)>>1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists, mid, r));
    }


    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
