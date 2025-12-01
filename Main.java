import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " (" + age + " лет)";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ВЫБЕРИТЕ ЗАДАНИЕ");
            System.out.println("1. Коробка");
            System.out.println("2. Сравнимые объекты");
            System.out.println("3. Поиск максимума в коробках");
            System.out.println("4. Применение функции к списку");
            System.out.println("5. Фильтрация списка");
            System.out.println("6. Сокращение списка");
            System.out.println("7. Преобразование коллекций");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    executeTask1(scanner);
                    break;
                case 2:
                    executeTask2(scanner);
                    break;
                case 3:
                    executeTask3(scanner);
                    break;
                case 4:
                    executeTask4(scanner);
                    break;
                case 5:
                    executeTask5(scanner);
                    break;
                case 6:
                    executeTask6(scanner);
                    break;
                case 7:
                    executeTask7(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static void executeTask1(Scanner scanner) {
        Box<String> stringBox = new Box<>();

        while (true) {
            System.out.println("Меню работы с коробкой");
            System.out.println("1 - Проверить, пуста ли коробка");
            System.out.println("2 - Положить объект в коробку");
            System.out.println("3 - Взять объект из коробки");
            System.out.println("0 - Назад");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Коробка пуста: " + !stringBox.isFull());
                    break;
                case 2:
                    System.out.print("Введите строку для помещения в коробку: ");
                    String item = scanner.nextLine();
                    try {
                        stringBox.put(item);
                        System.out.println("Строка успешно помещена в коробку");
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        String content = stringBox.get();
                        System.out.println("Из коробки извлечено: " + content);
                    } catch (Exception e) {
                        System.out.println("Коробка пуста");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static void executeTask2(Scanner scanner) {
        while (true) {
            System.out.println("Меню работы с Сравнимыми объектами");
            System.out.println("1 - Сравнить строки по длине");
            System.out.println("2 - Сравнить числа");
            System.out.println("3 - Сравнить пользователей по возрасту");
            System.out.println("0 - Назад");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    compareStrings(scanner);
                    break;
                case 2:
                    compareNumbers(scanner);
                    break;
                case 3:
                    compareUsers(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static void compareStrings(Scanner scanner) {
        System.out.print("Введите первую строку: ");
        String first = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String second = scanner.nextLine();

        Compare<String> comparator = new Compare<>(first, other -> Integer.compare(first.length(), other.length()));
        int result = comparator.compare(second);

        System.out.println("Результат сравнения длин строк:");
        if (result > 0) {
            System.out.println("Первая строка длиннее");
        } else if (result < 0) {
            System.out.println("Первая строка короче");
        } else {
            System.out.println("Строки одинаковой длины");
        }
        System.out.println("Числовой результат: " + result);
    }

    private static void compareNumbers(Scanner scanner) {
        System.out.print("Введите первое число: ");
        int first = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int second = scanner.nextInt();
        scanner.nextLine();

        Compare<Integer> comparator = new Compare<>(first, other -> Integer.compare(first, other));
        int result = comparator.compare(second);

        System.out.println("Результат сравнения чисел:");
        if (result > 0) {
            System.out.println("Первое число больше");
        } else if (result < 0) {
            System.out.println("Первое число меньше");
        } else {
            System.out.println("Числа равны");
        }
        System.out.println("Числовой результат: " + result);
    }

    private static void compareUsers(Scanner scanner) {
        System.out.print("Введите имя первого пользователя: ");
        String name1 = scanner.nextLine();
        System.out.print("Введите возраст первого пользователя: ");
        int age1 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите имя второго пользователя: ");
        String name2 = scanner.nextLine();
        System.out.print("Введите возраст второго пользователя: ");
        int age2 = scanner.nextInt();
        scanner.nextLine();

        User user1 = new User(name1, age1);
        User user2 = new User(name2, age2);

        Compare<User> comparator = new Compare<>(user1, other -> Integer.compare(user1.getAge(), other.getAge()));
        int result = comparator.compare(user2);

        System.out.println("Результат сравнения пользователей:");
        if (result > 0) {
            System.out.println("Первый пользователь старше");
        } else if (result < 0) {
            System.out.println("Первый пользователь младше");
        } else {
            System.out.println("Пользователи одного возраста");
        }
        System.out.println("Числовой результат: " + result);
    }

    private static void executeTask3(Scanner scanner) {
        List<Box<? extends Number>> boxes = new ArrayList<>();

        System.out.print("Сколько коробок хотите создать? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Коробка " + (i + 1) + ":");
            System.out.print("Выберите тип (1 - Integer, 2 - Double, 3 - Float, 4 - Long): ");
            int typeChoice = scanner.nextInt();
            System.out.print("Введите значение: ");
            double value = scanner.nextDouble();
            scanner.nextLine();

            switch (typeChoice) {
                case 1:
                    Box<Integer> intBox = new Box<>();
                    intBox.put((int) value);
                    boxes.add(intBox);
                    break;
                case 2:
                    Box<Double> doubleBox = new Box<>();
                    doubleBox.put(value);
                    boxes.add(doubleBox);
                    break;
                case 3:
                    Box<Float> floatBox = new Box<>();
                    floatBox.put((float) value);
                    boxes.add(floatBox);
                    break;
                case 4:
                    Box<Long> longBox = new Box<>();
                    longBox.put((long) value);
                    boxes.add(longBox);
                    break;
                default:
                    System.out.println("Неверный выбор типа");
                    i--;
            }
        }

        try {
            double max = BoxOfBoxes.findMaxValue(boxes);
            System.out.println("Максимальное значение в коробках: " + max);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void executeTask4(Scanner scanner) {
        List<String> strings = new ArrayList<>();

        System.out.print("Сколько строк хотите ввести? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            strings.add(scanner.nextLine());
        }

        List<Integer> lengths = ListUpdate.applyToList(strings, new IFunction<String, Integer>() {
            public Integer apply(String element) {
                return element.length();
            }
        });

        System.out.println("Длины строк: " + lengths);
    }

    private static void executeTask5(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Сколько чисел хотите ввести? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }
        scanner.nextLine();

        System.out.println("Исходный список: " + numbers);

        List<Integer> evenNumbers = Filter.filter(numbers, new ITesting<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        });
        System.out.println("Четные числа: " + evenNumbers);

        List<Integer> greaterThanFive = Filter.filter(numbers, new ITesting<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number > 5;
            }
        });
        System.out.println("Числа больше 5: " + greaterThanFive);
    }

    private static void executeTask6(Scanner scanner) {
        System.out.println("1. Конкатенация строк");
        System.out.println("2. Сумма чисел");
        System.out.println("3. Количество элементов во вложенных списках");
        System.out.print("Выберите вариант: ");

        int variant = scanner.nextInt();
        scanner.nextLine();

        switch (variant) {
            case 1:
                List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                String concatenated = Reduce.reduce(strings, new IReducer<String>() {
                    @Override
                    public String reduce(String accumulator, String element) {
                        return accumulator + element;
                    }
                });
                System.out.println("Конкатенация строк: " + concatenated);
                break;

            case 2:
                List<Integer> numbers = Arrays.asList(1, -3, 7);
                Integer sum = Reduce.reduce(numbers, new IReducer<Integer>() {
                    @Override
                    public Integer reduce(Integer accumulator, Integer element) {
                        return accumulator + element;
                    }
                });
                System.out.println("Сумма чисел: " + sum);
                break;

            case 3:
                List<List<Integer>> listOfLists = Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(6, 7, 8, 9)
                );

                List<Integer> lengths = ListUpdate.applyToList(listOfLists, new IFunction<List<Integer>, Integer>() {
                    @Override
                    public Integer apply(List<Integer> list) {
                        return list.size();
                    }
                });

                Integer totalElements = Reduce.reduce(lengths, new IReducer<Integer>() {
                    @Override
                    public Integer reduce(Integer accumulator, Integer element) {
                        return accumulator + element;
                    }
                });

                System.out.println("Общее количество элементов: " + totalElements);
                break;

            default:
                System.out.println("Неверный выбор");
        }
    }

    private static void executeTask7(Scanner scanner) {
        System.out.println("1. Разделение чисел на положительные и отрицательные");
        System.out.println("2. Группировка строк по длине");
        System.out.println("3. Уникальные значения");
        System.out.print("Выберите вариант: ");

        int variant = scanner.nextInt();
        scanner.nextLine();

        switch (variant) {
            case 1:
                List<Integer> numbers = Arrays.asList(1, -3, 7);
                Map<String, List<Integer>> numberGroups = Collect.collect(
                        numbers,
                        () -> {
                            Map<String, List<Integer>> map = new HashMap<>();
                            map.put("positive", new ArrayList<>());
                            map.put("negative", new ArrayList<>());
                            return map;
                        },
                        (map, number) -> {
                            if (number > 0) {
                                map.get("positive").add(number);
                            } else if (number < 0) {
                                map.get("negative").add(number);
                            }
                        }
                );
                System.out.println("Положительные: " + numberGroups.get("positive"));
                System.out.println("Отрицательные: " + numberGroups.get("negative"));
                break;

            case 2:
                List<String> strings1 = Arrays.asList("qwerty", "asdfg", "zx", "qw");
                Map<Integer, List<String>> lengthGroups = Collect.collect(
                        strings1,
                        HashMap::new,
                        (map, str) -> {
                            map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
                        }
                );
                System.out.println("Группировка по длине: " + lengthGroups);
                break;

            case 3:
                List<String> strings2 = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
                Set<String> uniqueStrings = Collect.collect(
                        strings2,
                        HashSet::new,
                        (set, str) -> {
                            set.add(str);
                        }
                );
                System.out.println("Уникальные строки: " + uniqueStrings);
                break;

            default:
                System.out.println("Неверный выбор");
        }
    }
}