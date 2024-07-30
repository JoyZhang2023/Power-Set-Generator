//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Generate power set");

        powerSetGenerator();

        }

    public static void powerSetGenerator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the set:");

        int n = scanner.nextInt();

        scanner.nextLine(); // Consume newline



        Set<String> inputSet = new HashSet<>();

        System.out.println("Enter the elements of the set:");

        for (int i = 0; i < n; i++) {

            inputSet.add(scanner.nextLine());

        }



        List<Set<String>> powerSet = generatePowerSet(inputSet);

        System.out.println("Power Set:");

        for (Set<String> subset : powerSet) {

            System.out.println(subset);

        }

    }

public static List<Set<String>> generatePowerSet(Set<String> originalSet) {

    List<Set<String>> powerSet = new ArrayList<>();

    if (originalSet.isEmpty()) {

        powerSet.add(new HashSet<>());

        return powerSet;

    }



    List<String> list = new ArrayList<>(originalSet);

    String head = list.get(0);

    Set<String> rest = new HashSet<>(list.subList(1, list.size()));



    for (Set<String> set : generatePowerSet(rest)) {

        Set<String> newSet = new HashSet<>();

        newSet.add(head);

        newSet.addAll(set);

        powerSet.add(newSet);

        powerSet.add(set);

    }



    return powerSet;

}


}
