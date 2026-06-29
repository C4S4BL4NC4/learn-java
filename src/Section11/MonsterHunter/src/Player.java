import java.util.List;

public class Player implements ISaveable {

    private String name, weapon;
    private int hitPoints, strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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
        return List.of(
            getName(),
            String.valueOf(getHitPoints()),
            String.valueOf(getStrength()),
            getWeapon()
        );
    }

    @Override
    public List<String> read() {
        return List.of();
    }

    @Override
    public String toString() {
        return String.format(
            "Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'}%n",
            getName(),
            getHitPoints(),
            getStrength(),
            getWeapon()
        );
    }
}
