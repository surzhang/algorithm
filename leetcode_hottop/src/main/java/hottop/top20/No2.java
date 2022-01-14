package hottop.top20;

import model.ListNode;

/**
 * @ fileName:No2
 * @ description:两数相加,给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * @ author:zyk
 * @ createTime:2021/12/4 21:39
 * @ version:1.0.0
 */
public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //新链表头结点
        ListNode pre = new ListNode(0);
        //指向头结点
        ListNode cur = pre;
        //进位
        int carry = 0;
        //当二者全部为空跳出循环
        while (l1 != null || l2 != null) {
            //获取当前两个节点的值
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x+y+carry;
            //进位值
            carry = sum/10;
            //求余数
            sum = sum%10;
            //新建节点并赋值，存入新链表
            cur.next = new ListNode(sum);
            //新链表指针右移
            cur = cur.next;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (carry ==1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
