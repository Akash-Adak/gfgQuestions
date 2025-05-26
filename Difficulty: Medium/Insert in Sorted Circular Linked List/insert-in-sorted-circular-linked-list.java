/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here

        Node newNode = new Node(data);

        // If the list is empty, create a self-loop
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        Node prev = null;

        // Traverse to find the correct insert position
        while (curr.next != head && curr.data < data) {
            prev = curr;
            curr = curr.next;
        }

        // Insert at the correct position
        newNode.next = curr;
        if (curr.data >= data) { // Insert before curr (could be head)
            if (curr == head) { // Insert before head, update last node's pointer
                Node last = head;
                while (last.next != head) last = last.next;
                last.next = newNode;
                return newNode; // New head
            }
            prev.next = newNode;
        } else { // Insert at the last position
            curr.next = newNode;
            newNode.next = head;
        }

        return head; // Head remains unchanged
    }


}