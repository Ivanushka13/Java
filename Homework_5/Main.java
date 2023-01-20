import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        // Заполняем список пользователей
        users.add(new User(0, "Ivan", "Davydov", 19, "Armenian"));
        users.add(new User(2, "Mark", "Rybin", 11, "Russian"));
        users.add(new User(1, "Egor", "Sobolev", 21, "Russian"));
        users.add(new User(2, "Artem", "Egorov", 16, "American"));
        users.add(new User(1, "Igor", "Severov", 9, "American"));
        users.add(new User(3, "Boris", "Budaev", 25, "Russian"));
        users.add(new User(2, "Mishanya", "Parker", 18, "Japanese"));
        users.add(new User(3, "Leonid", "Petrov", 18, "Armenian"));

        System.out.println("Отсортированный по возрасту список пользователей:");
        // Сортируем список пользователей по возрасту
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(user -> System.out.println(user.getId() + " " + user.getFirstName() + " " +
                        user.getLastName() + " " + user.getAge() + " " + user.getNationality()));

        System.out.println();

        // Группируем пользователей по id
        System.out.println("Сгруппированный по id список пользователей:");
        Map<Long, List<User>> groupedByIdUsers = users.stream()
                .collect(Collectors.groupingBy(User::getId));

        for(Long id: groupedByIdUsers.keySet()) {
            System.out.println("ID = " + id + ":");
            for(User user: groupedByIdUsers.get(id)) {
                System.out.println(user.getId() + " " + user.getFirstName() + " " +
                        user.getLastName() + " " + user.getAge() + " " + user.getNationality());
            }
        }

        System.out.println();

        // Группируем список пользователей по национальности
        Map<String, List<User>> groupedByNationalityUsers = users.stream()
                .collect(Collectors.groupingBy(User::getNationality));

        // Выводим количество ключей в получившейся мапе
        System.out.println("Количество различных национальностей - " + groupedByNationalityUsers.keySet().size());
        groupedByNationalityUsers.keySet().forEach(System.out::println);

        System.out.println();

        System.out.println("Список пользователей с возрастом > 10 и первая буква имени != M:");
        // Выводим пользователей с возрастом > 10 и первая буква имени != M
        users.stream()
                .filter(user -> user.getAge() > 10 && user.getFirstName().toCharArray()[0] != 'M')
                .forEach(user -> System.out.println(user.getId() + " " + user.getFirstName() + " " +
                        user.getLastName() + " " + user.getAge() + " " + user.getNationality()));
    }
}
