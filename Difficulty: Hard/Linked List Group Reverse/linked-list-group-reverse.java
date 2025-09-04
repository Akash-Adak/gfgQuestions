/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(k<=1 || head==null) return head;
        Node dummy =new Node(0);
        dummy.next=head;
        Node preGroup=dummy;
       
         while(true){
             Node start=preGroup.next;
             Node curr=start;
           int len=0;
         while(curr!=null && len<k){

             curr=curr.next;
             len++;
         }
       if(len<k){
            Node next=null,pre=null;
         curr=start;
           while(curr!=null){
                 next=curr.next;
                 curr.next=pre;
                 pre=curr;
                 curr=next;
                
             }
             preGroup.next=pre;
             break;
            
       }
       
         Node next=null,pre=null;
         curr=start;
             for(int i=0; i<k;i++){
                 next=curr.next;
                 curr.next=pre;
                 pre=curr;
                 curr=next;
                
             }
            
             preGroup.next=pre;
             start.next=curr;
             preGroup=start;
             
         }
         return dummy.next;
    }
}