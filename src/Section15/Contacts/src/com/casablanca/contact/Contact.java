package com.casablanca.contact;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    String name;
    Set<String> emails = new HashSet<>();
    Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this.name = name;
    }

    public Contact(String name, String email) {
        this(name);
        this.emails.add(email);
    }

    public Contact(String name, long phone) {
        this(name);
        this.phones.add(String.valueOf(phone));
    }

    public Contact(String name, String email, long phone) {
        this(name, email);
        if (phone != null) {
            this.phones.add(phoneNumberFormatter(phone));
        }
    }

    private String phoneNumberFormatter(long phoneNum) {
        String phoneNumStr = String.valueOf(phoneNum);
        if (phoneNumStr.length() == 10) {
            // (123)456-7890
            return "(" + phoneNumStr.substring(0, 3) + ")"
                    + phoneNumStr.substring(3, 6) + "-"
                    + phoneNumStr.substring(6);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }

    Contact mergeContactData(Contact contact) {

        return null;
    }
}
