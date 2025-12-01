import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static <T> List<T> filter(List<T> list, ITesting<T> predicate) {
        if (list == null || predicate == null) {
            throw new IllegalArgumentException("Список и условие не могут быть null");
        }

        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}