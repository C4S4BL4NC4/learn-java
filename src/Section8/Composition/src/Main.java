public class Main {

    public static void main(String[] args) {

        ComputerCase theCase = new ComputerCase("2202", "HP", "480");
        Monitor theMonitor = new Monitor("27inch Odyssey", "Samsung", 27, "2540 x 1440");
        Motherboard theMotherboard = new Motherboard("B550M", "ASRock", 2, 1, "v2.11");

        PersonalComputer thePC = new PersonalComputer("2208", "Dell", theMonitor, theCase, theMotherboard);

        thePC.getMonitor().drawPixelAt(10, 10, "green");
        thePC.getMotherboard().loadProgram("Windows OS");
        thePC.getComputerCase().pressPowerButton();
    }
}
