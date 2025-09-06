/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                Node temp=slow;
        int length=0;
        while(temp.next!=slow){
            length++;
            temp=temp.next;
        }
        return length+1;
            }
        }
        
       return 0;
    }
}