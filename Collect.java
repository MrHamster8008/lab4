import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

class Collect {
    public static <T, R> R collect(
            List<T> list,
            Supplier<R> supplier,
            BiConsumer<R, T> accumulator
    ) {
        if (list == null || supplier == null || accumulator == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null");
        }

        R result = supplier.get();
        for (T element : list) {
            accumulator.accept(result, element);
        }
        return result;
    }
}