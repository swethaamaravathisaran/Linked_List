// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;  // Edge case: Empty list, do nothing

        // Step 1: Find the middle of the list using slow and fast pointer technique
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;  // Start of second half
        slow.next = null;  // Break the link to split the list
        ListNode node = null;  // This will store the new reversed list head

        while (second != null) {
            ListNode temp = second.next;  // Store next node
            second.next = node;  // Reverse the link
            node = second;  // Move node forward
            second = temp;  // Move to the next node
        }

        // Step 3: Merge the two halves
        ListNode first = head;  // Pointer to first half
        second = node;  // Pointer to reversed second half

        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next; // Store next nodes
            first.next = second;  // Connect first node to second node
            second.next = temp1;  // Connect second node to first node's next
            first = temp1;  // Move first pointer forward
            second = temp2;  // Move second pointer forward
        }
    }
}
