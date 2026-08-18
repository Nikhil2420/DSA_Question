package Linked_List_Questions;

public class FlatteningALinkedList {

    public Node flatten(Node head) {

        if (head == null) return null;
        Node head2 = flatten(head.next);
        return mergeSortedLinkedList(head, head2);
    }

    public Node mergeSortedLinkedList(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                temp.bottom = temp1;
                temp = temp1;
                temp1 = temp1.bottom;
            } else {
                temp.bottom = temp2;
                temp = temp2;
                temp2 = temp2.bottom;
            }
        }

        if (temp1 != null) {
            temp.bottom = temp1;
            temp = temp1;
        }

        if (temp2 != null) {

            temp.bottom = temp2;
            temp = temp2;
        }
        return dummy.bottom;
    }
}