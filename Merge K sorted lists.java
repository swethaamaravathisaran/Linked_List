// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> ans=new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode list:lists)
        {
            if(list!=null)
            {
                ans.add(list);
            }
        }
        ListNode curr=new ListNode(0);
        ListNode temp=curr;
        while(ans.size()>0)
        {
            ListNode rem=ans.poll();
            temp.next=rem;
            temp=rem;
            rem=rem.next;
            if(rem!=null)
              ans.add(rem);
        }
        return curr.next;
        
    }
}
