public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void display();

    public void add(Component component) {
        if (component == null)
            throw new NullPointerException();
    }

    public void remove(Component component) {
        if (component == null)
            throw new NullPointerException();
    }
}