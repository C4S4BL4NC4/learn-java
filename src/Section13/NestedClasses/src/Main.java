import domain.Employee;
import domain.EmployeeComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        List<Employee> list = new ArrayList<>(List.of(new Employee(1, "June", 2), new Employee(2, "Roka", 1), new Employee(3, "Alice", 3)));

        var comparator = new EmployeeComparator<>();
        list.sort(comparator);

        for (var e : list) {
            System.out.println(e);
        }
    }
}
