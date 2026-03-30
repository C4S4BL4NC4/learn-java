public class Main {

    public static void main(String[] args) {
        Employee alex = new Employee("Alex", "11/01/1990", "01/01/2022");
        System.out.println(alex);
        System.out.println(alex.getAge());
        System.out.println(alex.collectPay());

        SalariedEmployee joe = new SalariedEmployee("Joe", "12/12/1989", "22/01/2022", 150000);
        System.out.println(joe);
        System.out.println(joe.getAge());
        System.out.println(joe.collectPay());
        joe.retire();
        System.out.println(joe.collectPay());

        HourlyEmployee aline = new HourlyEmployee("Aline", "01/05/1998", "16/02/2026", 50);
        System.out.println(aline);
        System.out.println(aline.collectPay());
        System.out.println(aline.getDoublePay());
    }
}
