import java.util.ArrayList;
import java.util.List;

public class ListUpdate {
    public static <T, P> List<P> applyToList(List<T> list, IFunction<T, P> function) {
        if (list == null || function == null) {
            throw new IllegalArgumentException("Список и функция не могут быть пустыми");
        }

        List<P> result = new ArrayList<>();
        for (T element : list) {
            result.add(function.apply(element));
        }
        return result;
    }
}