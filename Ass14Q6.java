class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void leftShift(int k) {
        if (head == null || k == 0)
            return;

        int length = getLength();
        k = k % length;

        if (k == 0)
            return;

        Node curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        Node newHead = curr.next;
        curr.next = null;

        curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        head = newHead;
    }

    public int getLength() {
        int length = 0;
        Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] values = {2, 4, 7, 8, 9};
        int k = 3;

        for (int value : values) {
            list.insert(value);
        }

        System.out.println("Original List:");
        list.display();

        list.leftShift(k);

        System.out.println("Left-shifted List:");
        list.display();
    }
}
