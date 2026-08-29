package Linked_List_Questions;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        int diff = 0;
        temp1 = headA;
        temp2 = headB;
        if (len1 > len2) {
            diff = len1 - len2;
            int cnt = 0;
            while (cnt < diff) {
                temp1 = temp1.next;
                cnt++;
            }
        }

        if (len2 > len1) {
            diff = len2 - len1;
            int cnt = 0;
            while (cnt < diff) {
                temp2 = temp2.next;
                cnt++;
            }
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}