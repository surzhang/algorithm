package hottop.top60;

import model.ListNode;

/**
 * @FileName: No142
 * @Description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（
 * 索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况
 * @Author: zyk
 * @createTime: 2021/12/20 9:30
 * @version: 1.0
 */
public class No142 {
    public ListNode detectCycle(ListNode head){
        ListNode fast =head,slow =head;
        while(true){
            if (fast==null||slow==null){
                return null;
            }
            fast=fast.next.next;
            slow =slow.next;
            if (fast==slow) {
                break;
            }
        }
        fast=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
