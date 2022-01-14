package wangyi;

import model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC40
 * @description :TODO
 * @date 2022/1/11 14:33
 */
public class NC40 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1=new LinkedList<>();
        Deque<Integer>stack2=new LinkedList<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        ListNode newHead=new ListNode(-1);
        int add=0;
        while (!stack1.isEmpty()||!stack2.isEmpty()||add!=0){
            int sum=add;
            sum+=stack1.isEmpty()?0:stack1.poll();
            sum+=stack2.isEmpty()?0:stack2.poll();
            add=sum/10;
            ListNode cur=new ListNode(sum%10);
            cur.next=newHead.next;
            newHead.next=cur;
        }
        return newHead.next;
    }

}
