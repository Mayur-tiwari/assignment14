import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next, arb;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.arb = null;
    }
}

public class CopySpecialLinkedList {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> nodeMap = new HashMap<>();

        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.data));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copyNode = nodeMap.get(current);
            copyNode.next = nodeMap.get(current.next);
            copyNode.arb = nodeMap.get(current.arb);
            current = current.next;
        }

        return nodeMap.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.arb = head.next;
        head.next.arb = head.next.next.next;

        CopySpecialLinkedList solution = new CopySpecialLinkedList();
        Node copiedHead = solution.copyRandomList(head);

        Node current = copiedHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
