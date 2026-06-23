public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return super.rightLink;
    }

    @Override
    ListItem previous() {
        return super.leftLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        rightLink = item;
        return super.rightLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        leftLink = item;
        return super.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        return Integer.compare((int) this.getValue(), (int) item.getValue());
    }
}
