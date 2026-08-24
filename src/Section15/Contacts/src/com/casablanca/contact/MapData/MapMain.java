package com.casablanca.contact.MapData;

import com.casablanca.contact.Contact;
import com.casablanca.contact.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        System.out.println("MapMain.main");
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("------------------------");

        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }

        contacts.forEach((k, v) -> System.out.println("k = " + k + "v = " + v));
        System.out.println("------------------------------------------------");

        System.out.println(contacts.get("Charlie Brown"));
        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Unknown Contact");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("------------------------------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact dupe = contacts.put(contact.getName(), contact);
            if (dupe != null) {
//                System.out.println("duplicate = " + dupe);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(dupe));
            }
        }
        contacts.forEach((k, v) -> System.out.println("k = " + k + "v = " + v));

        System.out.println("------------------------------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact dupe = contacts.putIfAbsent(contact.getName(), contact);
            if (dupe != null) {
//                System.out.println("duplicate = " + dupe);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(dupe));
            }
        }
        contacts.forEach((k, v) -> System.out.println("k = " + k + "v = " + v));
    }
}
