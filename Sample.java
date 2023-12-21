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

        // adding node based on a reference to a node object
        Node node = new Node(90);
        tree.addNode(node);

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

        // get an array of nodes to a node given by reference
        ArrayList<Node> nodesToNode = tree.nodesToNode(node);
        // loop over nodes to node using .getData() to print out the data in the given node
        for (Node item : nodesToNode) {
            System.out.println(item.getData());
        }

        // find the parent node
        System.out.println(tree.findParentNode(10).getData());

        // get the parent node based on a reference to a node
        System.out.println(tree.getNodesParent(node));

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
        tree.remove(10);

        // remove a node based on a reference to that node
        tree.removeNode(node);

        // print tree in order to show the change
        ArrayList<Node> showChange = tree.inOrderTraversal();
        System.out.println("IN ORDER");
        for(Node item : showChange){
            System.out.println(item.getData());
        }
    }
    
}
