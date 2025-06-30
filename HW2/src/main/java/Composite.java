import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private final List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void display() {
        for (Component child : children) {
            child.display(); System.out.print(" в контейнере: " + this.name);
        }
    }

    @Override
    public void add(Component component) {
        if (component == null)
            throw new NullPointerException();
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        if (component == null)
            throw new NullPointerException();
        children.remove(component);
    }

    public List<Component> getChildren() {
        return children;
    }
}