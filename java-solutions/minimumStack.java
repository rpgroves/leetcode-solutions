class MinStack {

    private Node head;

    private static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null)
        {
            head = new Node(val, val, null);
            return;
        }
        else
        {
            int min = val;
            if(head.min < val)
                min = head.min;
            Node n = new Node(val, min, head);
            head = n;
        }
    }
    
    public void pop() {
        if(head != null)
        {
            if(head.next != null)
                head = head.next;
            else
                head = null;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
