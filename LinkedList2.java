// Create a LinkedList class that has a head and a tail.
// The head is the first node in the list.
// The tail is the last node in the list.
// The list is empty if the head and tail are null.
// The list is not empty if the head and tail are not null.
public class LinkedList2 {
    private Node head;
    private Node tail;
    private int size;
    public LinkedList2() {
        head = tail = null;
        size = 0;
    }
    // Method that removes the first node in the list.
    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    public String toString() {
        String out = "";
        for (Node n = head; n != null; n = n.next)
            out += n.obj + " ";
        return out;
    }
    public void add(Object obj) {
        Node node = new Node(obj);
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
}
