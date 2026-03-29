public class Main {

    // All classes inheriante from the class Object
    public static void main(String[] args) {
        System.out.println("The Object Class");

        Student max = new Student("Max", 21);
        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8, "Carol");
        System.out.println(jimmy.toString());

        // Returns a unique hashCode of student instance in hexadecimal form.
        System.out.println(max.toString());
    }
}

class Student {

    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // @Override
    // public String toString() {
    //     return super.toString();
    // }

    @Override
    public String toString() {
        return name + " is " + age;
    }
}

class PrimarySchoolStudent extends Student {

    private String parentName;

    PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return parentName + "'s kid, " + super.toString();
    }
}
