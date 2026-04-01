public class Printer {
    private int tonerLevel;
    private int pagesPrinted = 0;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if ( tonerAmount < 0) {
            this.tonerLevel = 0;
        } else if (tonerAmount > 100) {
            this.tonerLevel = 100;
        } else {
            this.tonerLevel = tonerAmount;
        }
        System.out.println("Current toner level: "+ this.tonerLevel);
        return this.tonerLevel;
    }

    public int printPages(int pages) {
        this.pagesPrinted = pages;
        if (duplex) {
            int sheets = pages/2;
            System.out.println("Duplex: required sheets: "+ sheets);
            return sheets;
        } else {
            System.out.println("is Not Duplex: required amount sheets: "+ pages);
            return pages;
        }
    }
}
