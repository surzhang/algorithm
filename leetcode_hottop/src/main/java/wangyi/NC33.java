package wangyi;

import model.ListNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC33
 * @description :TODO 合并两个排序链表
 * @date 2022/1/11 14:32
 */
public class NC33 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode moveNode = head;

        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                moveNode.next = list1;
                list1 = list1.next;
            }else{
                moveNode.next = list2;
                list2 = list2.next;
            }
            moveNode = moveNode.next;
        }
        if(list1!=null){
            moveNode.next = list1;
        }
        if(list2!=null){
            moveNode.next = list2;
        }
        return head.next;
    }
}
