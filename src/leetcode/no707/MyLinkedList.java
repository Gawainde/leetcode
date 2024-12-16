package leetcode.no707;

//你可以选择使用单链表或者双链表，设计并实现自己的链表。
//
//单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
//
//如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
//
//实现 MyLinkedList 类：
//
//MyLinkedList() 初始化 MyLinkedList 对象。
//int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
//void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
//void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
//void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
//void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
//0 <= index, val <= 1000

public class MyLinkedList {

    //记录链表的虚拟头结点
    Node head;
    //记录链表中元素的数量
    int size;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(0);
    }

    public int get(int index) {
        //index从0开始   第0个节点是头节点
        if (index >= size || index < 0){
            return -1;
        }
        Node node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        //由于当前链表包含虚拟头结点（即把虚拟头结点当做第一个节点了） 因此找的是下一个节点的值
        return node.next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0){
            return;
        }
        Node node = this.head;
        //index从0开始   第0个节点是头节点
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node temp = new Node(val);
        temp.next = node.next;
        node.next = temp;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0){
            return;
        }
        Node node = this.head;
        //index从0开始   第0个节点是头节点！！
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        size--;
    }
}

class Node {
    int val;

    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
