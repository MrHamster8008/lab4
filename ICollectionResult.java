import java.util.Collection;

public interface ICollectionResult<P extends Collection<T>, T> {
    void result(P collection, T element);
}
