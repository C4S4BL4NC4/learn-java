package dev.lpa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // OLD WAY TO READ FILES
        try (FileReader oldReader = new FileReader("file.txt")) {
            char[] block = new char[1000];
            int data;
            while ((data = oldReader.read(block)) != -1) {
                var content = new String(block, 0, data);
                System.out.printf("---> [%d chars] %s%n", data, content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
            br.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
