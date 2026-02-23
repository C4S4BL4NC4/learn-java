public class ConstructorChallenge {

    private String name;
    private String email;
    private String phone;

    public ConstructorChallenge(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ConstructorChallenge() {
        this("UNKNOWN_NAME", "UNKNOWN_EMAIL", "UNKNOWN_PHONE");
    }

    public ConstructorChallenge(String name, String email) {
        this(name, email, "UNKNOWN_PHONE");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
