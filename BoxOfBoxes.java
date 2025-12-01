import java.util.Collection;

public class BoxOfBoxes {
    public static double findMaxValue(Collection<Box<? extends Number>> boxes) {
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Коллекция коробок не может быть пустой");
        }

        double max = Double.NEGATIVE_INFINITY;
        boolean found = false;

        for (Box<? extends Number> box : boxes) {
            if (box == null) {
                throw new IllegalArgumentException("Коллекция содержит null-коробки");
            }

            if (box.isFull()) {
                Number number = box.get();
                if (number != null) {
                    double value = number.doubleValue();
                    if (value > max) {
                        max = value;
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Ни одна коробка не содержит числового значения");
        }

        return max;
    }
}