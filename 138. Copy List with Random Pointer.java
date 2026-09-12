/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // Step 1: Create new nodes and interleave them with the original list
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Copy the random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // Point to the CLONE of the random node, which is the next node
                curr.next.random = curr.random.next; 
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        
        while (curr != null) {
            // Restore the original list
            curr.next = curr.next.next;
            
            // Advance the original list pointer
            curr = curr.next;
            
            // Extract the cloned list and advance its pointer
            if (newCurr.next != null) {
                newCurr.next = newCurr.next.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;
    }
}
