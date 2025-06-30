import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComponentTest {

    Composite root;

    @BeforeEach
    void setUp() {
        root = new Composite("root");
    }

    @Test
    void testAddLeafToComposite() {
        Leaf leaf = new Leaf("leaf1");
        root.add(leaf);
        assertEquals(1, root.getChildren().size());
        assertTrue(root.getChildren().contains(leaf));
    }

    @Test
    void testRemoveLeafFromComposite() {
        Leaf leaf = new Leaf("leaf2");
        root.add(leaf);
        root.remove(leaf);
        assertFalse(root.getChildren().contains(leaf));
    }

    @Test
    void testNestedCompositeStructure() {
        Composite branch = new Composite("branch");
        Leaf leafA = new Leaf("leafA");
        Leaf leafB = new Leaf("leafB");

        branch.add(leafA);
        root.add(branch);
        root.add(leafB);

        assertEquals(2, root.getChildren().size());
        assertEquals(1, ((Composite) root.getChildren().get(0)).getChildren().size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"leafX", "leafY", "leafZ"})
    void testLeafNames(String name) {
        Leaf leaf = new Leaf(name);
        assertNotNull(leaf);
        assertDoesNotThrow(leaf::display);
    }

    @Test
    void testDisplayDoesNotThrow() {
        Leaf leaf = new Leaf("simpleLeaf");
        Composite container = new Composite("container");

        container.add(leaf);
        assertDoesNotThrow(container::display);
    }

    @Test
    void testEmptyCompositeDisplay() {
        Composite empty = new Composite("empty");
        assertDoesNotThrow(empty::display);
        assertTrue(empty.getChildren().isEmpty());
    }

    @Test
    void testAddNullComponent() {
        assertThrows(NullPointerException.class, () -> root.add(null));
    }

    @Test
    void testRemoveNonExistingComponent() {
        Leaf leaf = new Leaf("ghostLeaf");
        assertDoesNotThrow(() -> root.remove(leaf));
        assertFalse(root.getChildren().contains(leaf));
    }
}