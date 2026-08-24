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
        this.phones.add(phoneNumberFormatter(phone));
    }

    public Contact(String name, String email, long phone) {
        this(name, email);
        if (phone > 0) {
            this.phones.add(phoneNumberFormatter(phone));
        }
    }

    private String phoneNumberFormatter(long phoneNum) {
        String phoneNumStr = String.valueOf(phoneNum);
        if (phoneNumStr.length() == 10) {
            // (123)456-7890
            return (
                    "(" +
                            phoneNumStr.substring(0, 3) +
                            ")" +
                            phoneNumStr.substring(3, 6) +
                            "-" +
                            phoneNumStr.substring(6)
            );
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%-20s %-30s %-20s".formatted(name, emails, phones);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return 33 * getName().hashCode();
    }

    public Contact mergeContactData(Contact contact) {
        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);

        return newContact;
    }


}
