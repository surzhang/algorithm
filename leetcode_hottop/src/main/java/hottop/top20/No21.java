package hottop.top20;

import model.ListNode;

/**
 * @ fileName:No21
 * @ description:合并两个有序链表
 * @ author:zyk
 * @ createTime:2021/12/13 21:09
 * @ version:1.0.0
 */
public class No21 {//迭代法
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;
            }else{
                prev.next = l2;
                l2=l2.next;
            }
            //移动哨兵指针
            prev  = prev.next;
        }
        prev.next=l1==null?l2:l1;
        return prehead.next;
    }

    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //终止条件1
        if (l1 == null) {
            return l2;
            //end condition 2
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
