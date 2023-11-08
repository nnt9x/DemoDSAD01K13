import java.util.ArrayList;
import java.util.List;

public class QueueADTImpl<T> implements QueueADT<T> {

    private int capacity;
    private List<T> items;

    public QueueADTImpl(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Kich thuoc hang doi phai duong");
        }
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    @Override
    public void enqueue(T t) {
        // Them vao cuoi hang doi
        if (isFull()) {
            System.out.println("Hang doi da day!");
        } else {
            items.add(t);
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Hang doi rong");
        }
        T t = items.get(0);
        items.remove(0);
        return t;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Hang doi rong");
        }
        return items.get(0);
    }

    @Override
    public boolean isEmpty() {
        if (items.isEmpty()) return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (items.size() == capacity) return true;
        return false;
    }
}
