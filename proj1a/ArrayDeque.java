public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private int capacity;

    public ArrayDeque() {
        size = 0;
        capacity = 8;
        items = (T[]) new Object[capacity];
        nextFirst = 3;
        nextLast = 4;
    }

    private void resize() {
        if (size == capacity) {
            T[] newItems = (T[]) new Object[capacity * 2];
            int x = Math.floorMod(nextLast - 1, capacity);
            System.arraycopy(items, 0, newItems, 0, x + 1);
            System.arraycopy(items, nextLast, newItems, x + 1 + capacity,capacity - x - 1);
            items = newItems;
            nextFirst = nextFirst + capacity;
            capacity = capacity * 2;
        }
        if (size < capacity / 4 && capacity > 8) {
            int y = Math.floorDiv(capacity, 2);
            T[] newItems = (T[]) new Object[y];
            int z = Math.floorMod(nextLast - 1, capacity);
            if (nextLast > size) {
                System.arraycopy(items, nextFirst, newItems, 0, size + 2);
                nextFirst = 0;
                nextLast = nextFirst + size + 1;
            } else {
                System.arraycopy(items, 0, newItems, 0, z + 1);
                System.arraycopy(items, nextLast + y, newItems, capacity - y - 1, capacity-z-y-1);
                nextFirst = nextFirst - y;
            }
            items = newItems;
            capacity = capacity - y;
        }
    }

    public void addFirst(T item) {
        resize();
        size += 1;
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = capacity - 1;
        } else {
            nextFirst -= 1;
        }

    }

    public void addLast(T item) {
        resize();
        size += 1;
        items[nextLast] = item;
        if (nextLast == capacity - 1) {
            nextLast = 0;
        }
        else {
            nextLast += 1;
        }
    }


    public T get(int index) {
        return items[first(nextFirst + index)];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int last(int temp) {
        if (temp == 0) {
            return capacity - 1;
        }
        return temp - 1;
    }

    private int first(int temp) {
        if (temp >= capacity - 1) {
            return temp + 1 - capacity;
        }
        return temp + 1;
    }

    public T removeFirst() {
        resize();
        size = size - 1;
        T temp = items[first(nextFirst)];
        items[first(nextFirst)] = null;
        nextFirst = first(nextFirst);
        return temp;
    }

    public T removeLast() {
        resize();
        size = size - 1;
        T temp = items[first(nextLast)];
        items[first(nextLast)] = null;
        nextLast = first(nextLast);
        return temp;
    }

    public void printDeque() {
        int res = first(nextFirst);
        int ano = last(nextLast);
        while (res != ano) {
            System.out.print(items[res].toString() + " ");
            res = first(res);
        }
        System.out.print(items[res].toString());
    }

}
