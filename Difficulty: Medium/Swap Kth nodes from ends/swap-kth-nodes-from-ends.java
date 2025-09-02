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
    public Node swapKth(Node head, int k) {
        Node pNode = head;
        List<Node> nodeList = new ArrayList<>();
	
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        int len = nodeList.size();
        if(k >len) return head;
        int temp = nodeList.get(k - 1).data;
        nodeList.get(k - 1).data = nodeList.get(len - k).data;
        nodeList.get(len - k).data = temp;

        return head;
    }
}
