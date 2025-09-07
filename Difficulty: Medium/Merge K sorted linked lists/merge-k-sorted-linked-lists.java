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
    Node mergeKLists(Node[] arr) {
        // code here
        List<Node> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            ans.add(arr[i]);
        }
        return mergeKList(ans);
        
    }
     Node mergeKList(List<Node> arr) {
        // Add your code here.
        if(arr.size()==0) return null;
        return merge(arr,0,arr.size()-1);
    }
    
    private Node merge(List<Node> arr, int s,int e){
        if(s==e) return arr.get(s);
        
        int m=s+(e-s)/2;
        Node l1=merge(arr,s,m);
        Node l2=merge(arr,m+1,e);
        return mergeTwo(l1,l2);
    }
    
    private Node mergeTwo(Node l1,Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.data<l2.data){
            l1.next=mergeTwo(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwo(l1,l2.next);
            return l2;
        }
        
    }
}