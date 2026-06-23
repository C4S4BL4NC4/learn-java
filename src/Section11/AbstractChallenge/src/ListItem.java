public abstract class ListItem {

    protected ListItem leftLink, rightLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();

    abstract ListItem previous();

    abstract ListItem setNext(ListItem item);

    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo();

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
