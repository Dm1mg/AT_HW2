public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Это элемент: "+ this.name);
    }
}