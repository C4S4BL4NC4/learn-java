import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        String filename = "files/testing.csv";
        System.out.println("PWD: " + new File("").getAbsolutePath());
        testFile2(filename);
        for (var f : File.listRoots()) {
            System.out.println(f);
        }
    }

    private static void testFile(String filename) {
        FileReader reader = null;
        try {

            reader = new FileReader(filename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Executing anyways...");
        }
    }

    private static void testFile2(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            System.out.println("Good to go...");
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has entered bad data " + badData.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something went wrong when reading " + filename + ".");
        } finally {
            System.out.println("Executing anyways...");
        }
    }
}
