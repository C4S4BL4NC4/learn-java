public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Generic Animal", "Huge", 400d);
        doAnimalStuff(animal, "slow");
        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");

        Fish neemo = new Fish("Goldfish", 0.25, 2, 3);
        doAnimalStuff(neemo, "fast");
    }

    public static void doAnimalStuff(Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("_ _ _ _");
    }
}
