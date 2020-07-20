import javafx.beans.binding.ObjectBinding;

public class ArrayDeque<T> implements Deque<T>{
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static int INIT_CAPACITY = 8;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[INIT_CAPACITY];
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize() {
        if (size == items.length) {
            expand();
        }
        if (size < items.length / 4 && items.length > 8) {
            reduce();
        }
    }

    private void resizeHelper(int capacity) {
        T[] temp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextFirst);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = plusOne(i, temp.length)) {
            items[nextLast] = temp[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = temp[end];
        nextLast = plusOne(nextLast);
    }

    private void expand() {
        resizeHelper(items.length * 2);
    }

    private void reduce() {
        resizeHelper(items.length / 2);
    }

    @Override
    public void addFirst(T item) {
        resize();
        size += 1;
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);

    }
    @Override
    public void addLast(T item) {
        resize();
        size += 1;
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int temp = Math.floorMod(plusOne(nextFirst) + index, items.length);
        return items[temp];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int minusOne(int index) {
        return Math.floorMod(index - 1, items.length);
    }

    private int plusOne(int index) {
        return Math.floorMod(index + 1, items.length);
    }

    private int plusOne(int index, int length){
        return Math.floorMod(index + 1, length);
    }

    @Override
    public T removeFirst() {
        resize();
        size = size - 1;
        T temp = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        return temp;
    }

    @Override
    public T removeLast() {
        resize();
        size = size - 1;
        T temp = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        return temp;
    }

    @Override
    public void printDeque() {
        for (int index = plusOne(nextFirst); index != nextLast; index = plusOne(index)) {
            System.out.print(items[index]);
            System.out.print(" ");
        }
        System.out.println();
    }

}
