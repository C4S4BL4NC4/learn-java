public class DnaStrand {

    static void main(String[] args) {
        System.out.println(makeComplement("ATTGC"));
        System.out.println(makeComplement("GTAT"));
        System.out.println(makeComplement(""));
    }

    // In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". Your function
    // receives one side of the DNA (string, except for Haskell);
    // you need to return the other complementary side. DNA strand is never empty or there is
    // no DNA at all (again, except for Haskell).
    //More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)
    //Example: (input --> output)
    //"ATTGC" --> "TAACG"
    //"GTAT" --> "CATA"
    // G -> C :: C -> G
    // T -> A :: A -> T

    // SOLVED: 
    public static String makeComplement(String dna) {
        if (dna.isEmpty()) return null;
        String[] splitDna = dna.toUpperCase().split("");
        for (int i = 0; i < splitDna.length; i++) {
            switch (splitDna[i]) {
                case "A" -> splitDna[i] = "T";
                case "T" -> splitDna[i] = "A";
                case "G" -> splitDna[i] = "C";
                case "C" -> splitDna[i] = "G";
            }
        }
        return String.join("", splitDna);
    }
}
