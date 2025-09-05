/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        List<Integer> list=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        Collections.sort(list);
        int n=list.size();
        Node dummy=new Node(-1);
        temp=dummy;
        for(int i=0;i<n;i++){
            Node newNode=new Node(list.get(i));
            temp.next=newNode;
            temp=newNode;
        }
        return dummy.next;
    }
}