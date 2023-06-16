class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListSumZeroRemoval {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current != null && current.next != null) {
            int sum = 0;
            ListNode runner = current.next;

            while (runner != null) {
                sum += runner.val;

                if (sum == 0) {
                    current.next = runner.next;
                }

                runner = runner.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    // Helper method to convert an array to a linked list
    public ListNode arrayToList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return head;
    }

    public String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;

        while (current != null) {
            sb.append(current.val).append(" ");
            current = current.next;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LinkedListSumZeroRemoval solution = new LinkedListSumZeroRemoval();
        int[] nums = {1, 2, -3, 3, 1};
        ListNode head = solution.arrayToList(nums);

        ListNode result = solution.removeZeroSumSublists(head);
        String output = solution.listToString(result);
        System.out.println(output);
    }
}
