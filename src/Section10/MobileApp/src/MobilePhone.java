import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(ArrayList<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact) {
        return !myContacts.contains(contact);
    }

    public boolean updateContact(Contact oldInfo, Contact newInfo) {
        if (!myContacts.contains(oldInfo) || oldInfo == newInfo) return false;
        else {
            oldInfo.setName(newInfo.getName());
            oldInfo.setPhoneNumber(newInfo.getPhoneNumber());
            return true;
        }
    }

    public boolean removeContact(Contact target) {
        if (!myContacts.contains(target)) {
            return false;
        } else {
            myContacts.remove(target);
            return true;
        }
    }

    public int findContact(Contact target) {
        if (!myContacts.contains(target)) return -1;
        else {
            return myContacts.indexOf(target);
        }
    }

    public int findContact(String targetName) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(targetName)) {
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact queryContact(String targetName) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(targetName)) {
                return contact;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println(
                (i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber()
            );
        }
    }
}
