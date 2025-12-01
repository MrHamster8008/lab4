public interface IReducer<T> {
    T reduce(T accumulator, T element);
}