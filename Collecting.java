import java.util.*;

public class Collecting {
    public static <T, P extends Collection<T>> P transform(
            List<T> sourceList,
            ICollectionCreate<P, T> factory,
            ICollectionResult<P, T> accumulator) {

        if (sourceList == null || factory == null || accumulator == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null");
        }

        P result = factory.create();
        for (T element : sourceList) {
            accumulator.result(result, element);
        }
        return result;
    }
}
