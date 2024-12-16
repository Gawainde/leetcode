package leetcode.no19;

public class RemoveNthFromEnd {

    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = removeNthFromEnd(node, 5);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode start = dummyHead, end = dummyHead;
        //移动start节点 距离为n
        while (n != 0){
            start = start.next;
            n--;
        }
        //此时start节点移动到最后 即为end节点所需移动的距离
        while (start.next != null){
            start = start.next;
            end = end.next;
        }
        //此时start移动到最后一个节点  end移动到倒数第n + 1个节点
        end.next = end.next.next;
        return dummyHead.next;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
