class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddOneToLinkedList {
    public static ListNode addOne(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

        int carry = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (head != null) {
            int sum = head.val + carry;
            carry = sum / 10;
            head.val = sum % 10;
            node = head;
            head = head.next;
        }

        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        prev = null;
        current = dummy.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        dummy.next = prev;

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        head.next = node1;
        node1.next = node2;

        System.out.print("Input: ");
        printList(head);

        ListNode result = addOne(head);

        System.out.print("Output: ");
        printList(result);
    }
}
