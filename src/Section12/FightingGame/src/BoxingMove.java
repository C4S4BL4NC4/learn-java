public enum BoxingMove implements Move {
    JAB,
    CROSS,
    HOOK;
    
    public int damage() {
        return switch (this) {
            case JAB -> 5;
            case CROSS -> 8;
            case HOOK -> 10;
        };
    }
}
