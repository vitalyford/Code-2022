class Node {
    Object obj;
    Node next;

    public Node() {
        obj = null;
    }

    public Node(Object obj) {
        this.obj = obj;
    }

    public String toString() {
        return obj.toString();
    }
}

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = tail = null;
    }

    public String toString() {
        String out = "";
        for (Node n = head; n != null; n = n.next, out += (n == null) ? "" : n.obj + " ")
            ;

        return out;
    }

    /**
     * This method adds an Object to the end of the LinkedList.
     * 
     * @param obj it can be of any type - super cool stuff.
     */
    public void add(Object obj) {
        Node node = new Node(obj);

        if (head == null && tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public static void main(String[] args) {
        LinkedList vitaly = new LinkedList();
        vitaly.add(13);
        vitaly.add(73);
        vitaly.add(95);
        vitaly.add(2);
        System.out.println(vitaly);

    }
}
