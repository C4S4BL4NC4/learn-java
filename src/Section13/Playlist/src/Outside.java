public class Outside {
    public String x = "Outside Class";
    public class Inside {
        public String y = "Inside Class";

        void display() {
            System.out.println(x + " " + y);
        }
    }
}
