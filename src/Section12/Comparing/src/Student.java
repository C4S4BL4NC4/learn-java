public class Student implements Comparable <Student>{
    String name;

    @Override
    public String toString() {
        return name;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
