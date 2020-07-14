public class LinkedListDeque<T> {
    private int size;
    private Node sentinel;

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node i, T h, Node j) {
            prev = i;
            item = h;
            next = j;
        }
    }

    public LinkedListDeque(T item) {
        size = 1;
        sentinel = new Node(null, null, null);
        Node newNode = new Node(sentinel, item, sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
    }

    public  LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        if (size > 0) {
            Node newNode = new Node(sentinel, item, sentinel.next);
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
        } else {
            Node newNode = new Node(sentinel, item, sentinel);
            sentinel.next = newNode;
            sentinel.prev = newNode;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size > 0) {
            Node newNode = new Node(sentinel.prev, item, sentinel);
            sentinel.prev.next = newNode;
            sentinel.prev = newNode;
        } else {
            Node newNode = new Node(sentinel, item, sentinel);
            sentinel.next = newNode;
            sentinel.prev = newNode;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size()  {
        return size;
    }

    public void printDeque() {
        while (sentinel.next.next.item != null) {
            System.out.print(sentinel.next.item + " ");
            sentinel.next = sentinel.next.next;
        }
        System.out.print(sentinel.next.item);
    }

    public T removeFirst() {
        size -= 1;
        T a = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return a;
    }

    public T removeLast() {
        size -= 1;
        T a = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return a;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node temp = sentinel;
        while(index > 0) {
            temp.next = temp.next.next;
            index -= 1;
        }
        return temp.next.item;
    }


}
