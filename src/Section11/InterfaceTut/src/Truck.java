public class Truck implements Trackable{
    @Override
    public void track() {
        System.out.println( getClass() + "'s being tracked.");
    }
}
