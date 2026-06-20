import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Animal animal = new Animal("animal", "big", 100);
        Dog jon = new Dog("Husky", "big", 100);
        jon.makeNoise();
        doAnimalStuff(jon);
        System.out.println("\n\n");

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Fish("Goldfish", "small", 10));
        animals.add(new Dog("German Sheppard", "big", 50));
        animals.add(new Fish("Cleaner", "small", 10));
        animals.add(new Dog("wolf", "big", 100));
        animals.add(jon);

        for (Animal animal : animals) {
            doAnimalStuff(animal);
        }
    }

    private static void doAnimalStuff(Animal animal) {
        animal.move("slow");
        animal.makeNoise();
    }
}
