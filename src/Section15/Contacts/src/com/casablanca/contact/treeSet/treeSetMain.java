package com.casablanca.contact.treeSet;

import com.casablanca.contact.Contact;
import com.casablanca.contact.ContactData;

import java.util.*;

public class treeSetMain {
    public static void main(String[] args) {
        System.out.println("treeSetMain.main");

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        // MUST IMPLEMENT A SORT FROM COMPARATOR FOR THE TREE SET TO WORK IF OBJECT DOESN'T HAVE IT NATURALLY
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        // STRINGS AND NUMBER HAVE COMPARATOR NATURALLY IMPLEMENTED (COMPARATOR CAN BE SKIPPED(IMPELMENTED BY DEFUALT))
        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);


        System.out.println("--------------------------");
        var fullSet = new TreeSet<Contact>(mySort);
        fullSet.addAll(emails);

        var fullList = new ArrayList<Contact>(phones);
        fullList.sort(sorted.comparator());
        fullList.forEach(System.out::println);

        System.out.println("--------------------------");
        
    }
}
