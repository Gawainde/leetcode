package leetcode.no2;

@SuppressWarnings("all")
public class AddTwoNumbers {

    //给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    // 342 + 465
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        l11.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l2.next = l22;
        l22.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建一个结果节点temp和临时节点tail
        ListNode temp = null, tail = null;
        int flag = 0;
        // flag != 0 判断最高位是否需要进位 如109 + 209 当走到第三位时l1 l2的next节点均为null 但9 + 9需要进位
        while (l1 != null || l2 != null || flag != 0) {
            int flag1 = l1 != null ? l1.val : 0;
            int flag2 = l2 != null ? l2.val : 0;
            int sum = flag1 + flag2 + flag;
            //判断进位 flag > 0则需要进一位
            flag = sum / 10;
            if (temp == null){
                //结果节点temp和临时节点tail二者指向对象相同  注意：temp始终指向链表的头结点  tail后续会指向temp的下一个节点
                temp = new ListNode(sum % 10);
                tail = temp;
            } else {
                //tail.next的val为sum对10取余 （第一次循环）即temp.next的val也是该值（因为tail与temp指向的是同一个对象）
                //（第二次循环）此时tail指向的是temp.next对象 即tail.next = temp.next.next 如此循环
                tail.next = new ListNode(sum % 10);
                //将tail指向temp.next对象
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return temp;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
