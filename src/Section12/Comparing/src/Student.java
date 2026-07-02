public class Student implements Comparable{
    String name;

    @Override
    public String toString() {
        return name;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
