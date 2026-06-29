public interface Combatant<TMove extends Move> {
    String getName();
    int getHealth();
    void attack(Combatant<TMove> target, TMove move);
    boolean isAlive();
}
