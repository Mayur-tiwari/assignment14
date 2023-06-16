class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListLoopRemoval {
    static Node removeLoop(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        if (slow != fast)
            return null;

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node2;

        int X = 2;

        if (X != 0) {
            Node curr = head;
            while (X > 1) {
                curr = curr.next;
                X--;
            }
            node3.next = curr;
        }

        System.out.println("Input:");
        printList(head);

        Node result = removeLoop(head);

        System.out.println("Output:");
        printList(result);
    }
}
