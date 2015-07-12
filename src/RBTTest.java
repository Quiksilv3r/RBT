
/**
 * Red Black Tree Test class 
 * @author Quiksilvr JThurst3
 *
 */

import java.util.Random;

public class RBTTest {

    // Random number generator
    static Random rand;

    public static void main(String[] args) {
        // create the random number generator
        rand = new Random();
        // create a new red-black tree
        RBT tree = new RBT();
        // print the tree
        tree.printTree();
        // insert random elements
        for(int i = 0; i < 100; i++) {
            insertRandomElementIntoTree(tree);
        }
    }

    // inserts a random element from 0 to 100 (exclusive) into the tree
    public static void insertRandomElementIntoTree(RBT tree) {
        int elem = rand.nextInt(100);
        System.out.println("inserting element " + elem + " into tree...");
        tree.printTree();
        tree.insert(elem);
        tree.printTree();
    }
}



