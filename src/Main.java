import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();
        List<String> list = Arrays.stream(words.split(" ")).collect(Collectors.toList());
        System.out.println("Количество слов в тексте: " + list.size());

        list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(10)
                .forEach(map -> System.out.println(map.getValue() + " — " + map.getKey()));
    }
}
