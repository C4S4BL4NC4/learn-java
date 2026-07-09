public class Main {
    public static void main(String[] args) {
        Outside.Inside ins = new Outside().new Inside();
        ins.display();
    }
}
