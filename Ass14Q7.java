import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class NextGreaterNode {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int[] result = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            int currVal = list.get(i);

            while (!stack.isEmpty() && stack.peek() <= currVal) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek();
            }

            stack.push(currVal);
        }

        return result;
    }

    public static void main(String[] args) {
        // Create the linked list [2, 1, 5]
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);

        NextGreaterNode solution = new NextGreaterNode();
        int[] result = solution.nextLargerNodes(head);

        System.out.println(Arrays.toString(result));
    }
}
