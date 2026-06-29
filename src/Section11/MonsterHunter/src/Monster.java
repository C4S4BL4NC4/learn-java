import java.util.List;

public class Monster implements ISaveable {

    private String name;
    private int hitPoints, strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        return List.of();
    }

    @Override
    public List<String> read() {
        return List.of();
    }

    @Override
    public String toString() {
        return String.format(
            "Monster{name='%s', hitPoints=%d, strength=%d}%n",
            getName(),
            getHitPoints(),
            getStrength()
        );
    }
}
