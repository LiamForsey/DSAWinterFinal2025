import org.example.BinarySearchTree;
import org.junit.jupiter.api.Test;  // This is the critical import
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {

    @Test
    void testInsertAndVisualize() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals("5 -> (3 -> (null, null), 7 -> (null, null))", bst.visualize());
    }

    @Test
    void testEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals("null", bst.visualize());
    }

    @Test
    void testSingleNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        assertEquals("10 -> (null, null)", bst.visualize());
    }
}