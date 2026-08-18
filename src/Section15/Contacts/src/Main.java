import com.casablanca.contact.Contact;
import com.casablanca.contact.ContactData;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        List<Contact> emailContacts = ContactData.getData("email");
        List<Contact> phoneContacts = ContactData.getData("phone");

        printData("Emails List", emailContacts);
        printData("Phones List", phoneContacts);

        Set<Contact> emailContactsSet = new HashSet<>(emailContacts);
        Set<Contact> phoneContactsSet = new HashSet<>(phoneContacts);

        printData("Emails Set", emailContactsSet);
        printData("Phones Set", phoneContactsSet);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(70));
        System.out.println(header);
        System.out.println("-".repeat(70));
        contacts.forEach(System.out::println);
    }
}
