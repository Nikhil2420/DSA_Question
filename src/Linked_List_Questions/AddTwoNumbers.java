package Linked_List_Questions;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode newTail = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int rem = sum % 10;
            ListNode node = new ListNode(rem);
            if (newHead == null && newTail == null) {
                newHead = node;
                newTail = node;
            } else {
                newTail.next = node;
                newTail = node;
            }
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = carry + l1.val;
            int rem = sum % 10;
            ListNode node = new ListNode(rem);
            carry = sum / 10;
            newTail.next = node;
            newTail = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = carry + l2.val;
            int rem = sum % 10;
            ListNode node = new ListNode(rem);
            carry = sum / 10;
            newTail.next = node;
            newTail = node;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            newTail.next = node;
            newTail = node;
        }
        return newHead;
    }

    /*
        another way---->
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){

            int x = (l1!=null) ? l1.val : 0;
            int y= (l2!=null) ? l2.val :0 ;
            int sum=x+y+carry;
            carry=sum/10;
            temp.next=new ListNode(sum%10);
            temp=temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}