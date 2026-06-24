public class MyLinkedList implements NodeList {

    ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        while (root.getValue() != null && root.getValue() != item.getValue()) {
            if (item.getValue() == root.getValue()) {
                return false;
            }
            root.next();
        }
        if (root.getValue() == null && root.getValue() != item.getValue()) {
            root.setValue(item.getValue());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root.next() != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
            System.out.println(root.getValue());
        }
    }
}
