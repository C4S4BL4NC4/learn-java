import java.util.ArrayList;
import java.util.List;

public class Layer<E extends Mappable> {

    String type;
    private List<E> layerElements = new ArrayList<>();

    public Layer(String type) {
        this.type = type;
    }

    public void addElement(E e) {
        if (!layerElements.contains(e)) layerElements.add(e);
    }

    public void addElements(E e) {}

    public void renderLayer() {}
}
