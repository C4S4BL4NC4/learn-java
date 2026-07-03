public enum BoxingMove implements Move {
    JAB,
    CROSS,
    HOOK,
    UNBLOCKABLE;
    
    public int damage() {
        return switch (this) {
            case JAB -> 5;
            case CROSS -> 8;
            case HOOK -> 10;
            case UNBLOCKABLE -> 55;
        };
    }
}
