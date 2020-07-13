public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    public static int REFACTOR = 2;
    private int capacity;

    public ArrayDeque () {
        size = 0;
        capacity = 8;
        items = (T[]) new Object[capacity];
        nextFirst = 5;
        nextLast = 6;
    }

    private void resize() {
        if (size == capacity - 2) {
            T[] newItems = (T[]) new Object[capacity * 2];
            int x = Math.floorMod( nextLast - 1, capacity);
            System.arraycopy(items, 0, newItems, 0, x + 1 );
            System.arraycopy(items, nextLast, newItems, x + 1 + capacity, capacity  - x - 1);
            items = newItems;
            capacity = capacity * 2;
        }
    }

    public void addFirst(T item) {
        resize();
        size += 1;
        items[nextFirst] = item;
        if(nextFirst == 0) {
            nextFirst = capacity - 1;
        }else {
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


    public T get(int Index) {
        return items[Index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int Last( int temp) {
        if (temp == 0) {
            return capacity - 1;
        }
        return temp - 1;
    }

    public int First( int temp) {
        if (temp == capacity - 1) {
            return 0;
        }
        return temp + 1;
    }

    public T removeFirst() {
        size = size - 1;
        T temp = get(First(nextFirst));
        items[First(nextFirst)] = null;
        nextFirst = First(nextFirst);
        return temp;
    }

    public T removeLast() {
        size = size - 1;
        T temp = get(First(nextLast));
        items[First(nextLast)] = null;
        nextLast = First(nextLast);
        return temp;
    }

    public void printDeque() {
        int res = First(nextFirst);
        int ano = Last(nextLast);
        while(res != ano) {
            System.out.print(get(res).toString() + " ");
            res = First(res);
        }
        System.out.print(get(res));
    }

}
