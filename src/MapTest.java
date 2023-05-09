import java.util.Arrays;

public class MapTest {
    public static void main(String[] args) {
        MyMap m = new MyMap<>();
        System.out.println("Додаємо нові об’єкти в мапу. Якщо ключ уже існує, "
                + "змінюється його значення");
        m.add("Apple", 11);
        m.add("Super", 12);
        m.add("Super", 13);
        m.add("Oleg", 13);
        m.add(14, "Olya");
        m.add('s', "Alex");
        m.add(0.13, "Ivan");
        m.add('u', "Kate");

        System.out.println("Тепер наша мапа має розмір: " + m.size());
        System.out.println();
        System.out.println("Виводимо сет ключів:");
        System.out.println(Arrays.toString(m.keySet()));
        System.out.println("Виводимо сет значеннь:");
        System.out.println(Arrays.toString(m.valueSet()));
        System.out.println();
        System.out.println("Видаляємо елемент за ключем:");
        System.out.println("Елемент " + m.removeForKey(14).toString() + " видалено");
        System.out.println("Видаляємо елемент за значенням:");
        System.out.println("Елемент " + m.removeForValue("Kate").toString() + " видалено");
        System.out.println();
        System.out.println("Чи містить мапа ключ: ");
        System.out.println(m.containsKey("Oleg"));
        System.out.println("Чи містить мапа значення: ");
        System.out.println(m.containsValue(11));
        System.out.println();
        System.out.println("Виводимо повністю всю мапу:");
        System.out.println(m);
    }
}
