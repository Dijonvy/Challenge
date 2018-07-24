import java.util.NoSuchElementException;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addFirst(Node node) {
        if(isEmpty()) head = node;
        else {
            Node tmp = head;
            head = node;
            head.next = tmp;
        }
    }

    public void addLast(Node node) {
        if(isEmpty()) head = node;
        else {
            Node tmp = head;
            while(tmp.next != null) tmp = tmp.next;

            tmp.next = node;
        }
    }

    public Node removeNext(Node node) {
        if(isEmpty()) throw new NoSuchElementException();
        else if (node.next == null) {
            node = node.next;
            return node;
        }else {
            Node tmp = node.next;
            node.next = node.next.next;
            return tmp;
        }
    }

    public Node removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        else if (head.next == null) {
            head = null;
            return head;
        }
        else {
            Node tmp = head;
            while(tmp.next.next != null) tmp = tmp.next;

            Node result = tmp.next;
            tmp.next = null;
            return result;
        }
    }
}