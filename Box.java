public class Box<T> {
    private T content;


    public boolean isFull() {
        return content != null;
    }

    public void put(T item) {
        if (isFull()) {
            throw new IllegalStateException("Коробка уже содержит объект");
        }
        this.content = item;
    }

    public T get() {
        T item = content;
        content = null;
        return item;
    }
}