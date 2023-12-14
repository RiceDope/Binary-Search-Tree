/**
 * Sample set of code to explain how to use the Binary-Search-Tree
 * @author Rhys Walker
 * @version 1.0
 * @since 2023-12-14
 */
import java.util.ArrayList;

public class Sample {
    
    public static void main(String[] args) {
        
        // create the tree
        BST tree = new BST();

        // Add a selection of nodes to the tree
        tree.addItem(50); // ROOT NODE
        tree.addItem(25);
        tree.addItem(75);
        tree.addItem(10);
        tree.addItem(40);
        tree.addItem(60);
        tree.addItem(90);

        /*
         *         TREE IN EXAMPLE
         *
         *               50
         *              /  \
         *             /    \
         *            /      \
         *           25      75
         *          /  \     / \
         *         /    \   /   \
         *       10     40 60    90    
         */

        // get the root node
        System.out.println(tree.root().getData());

        // find a specific node given its data
        System.out.println(tree.findNode(10));

        // get a list of integers to a given node
        System.out.println(tree.listToNode(10));

        // find the parent node
        System.out.println(tree.findParentNode(10).getData());

        // traverse the tree using in order traversal
        ArrayList<Node> inOrder = tree.inOrderTraversal();
        System.out.println("IN ORDER");
        for(Node item : inOrder){
            System.out.println(item.getData());
        }

        // traverse the tree using pre order traversal
        ArrayList<Node> preOrder = tree.preOrderTraversal();
        System.out.println("PRE ORDER");
        for(Node item : preOrder){
            System.out.println(item.getData());
        }

        // remove a node from the tree
        tree.removeNode(10);
    }
    
}
