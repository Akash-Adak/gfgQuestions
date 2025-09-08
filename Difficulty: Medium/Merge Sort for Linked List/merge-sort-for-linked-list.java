/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
public Node mergeSort(Node head) {
    // Base case: if head is null or only one element
    if (head == null || head.next == null) {
        return head;
    }

    // Step 1: Split the list into two halves
    Node middle = getMiddle(head);
    Node nextOfMiddle = middle.next;
    middle.next = null; // Break the list

    // Step 2: Recursively sort the halves
    Node left = mergeSort(head);
    Node right = mergeSort(nextOfMiddle);

    // Step 3: Merge the sorted halves
    return mergeTwoLists(left, right);
}

// Helper method to find the middle of the linked list
private Node getMiddle(Node head) {
    if (head == null) return head;

    Node slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

     private Node mergeTwoLists(Node list1, Node list2) {
      
        Node root=new Node(0);
         Node i=list1,j=list2,k=root;
        while(i!=null && j!=null){
            if(i.data<j.data) {
                k.next=i;
                k=k.next;
                i=i.next;
            }else{
                k.next=j;
                k=k.next;
                j=j.next;
            }
        }
        while(i!=null){
            k.next=i;
            i=i.next;
            k=k.next;
        }
        while(j!=null){
            k.next=j;
            j=j.next;
            k=k.next;
        }
        return root.next;
    }


}