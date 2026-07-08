package domain;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator<T extends Employee>
            implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    private int id, yearStarted;
    private String name;

    public Employee(int id, String name, int yearStarted) {
        this.id = id;
        this.yearStarted = yearStarted;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", yearStarted=" + yearStarted +
                ", name='" + name + '\'' +
                '}';
    }
}
