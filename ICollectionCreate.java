import java.util.Collection;

public interface ICollectionCreate<P extends Collection<T>, T> {
    P create();
}
