class Compare<T> implements Comparable<T> {
    private T value;
    private java.util.function.Function<T, Integer> comparator;

    public Compare(T value, java.util.function.Function<T, Integer> comparator) {
        this.value = value;
        this.comparator = comparator;
    }

    @Override
    public int compare(T other) {
        return comparator.apply(other);
    }

    public T getValue() {
        return value;
    }
}