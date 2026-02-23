public record LPAStudent(String id, String name, String dateOfBirth, String classList) {
    // records are designed with the intent of being immutable.
    // For each component in the header java generates fields for it.
    // Also generates public accessor for each component.
}
