import java.util.List;

public class Reduce{
    public static <T> T reduce(List<T> list, IReducer<T> reducer) {
        if (list == null || reducer == null) {
            throw new IllegalArgumentException("Список и reducer не могут быть null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым");
        }

        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = reducer.reduce(result, list.get(i));
        }
        return result;
    }
}