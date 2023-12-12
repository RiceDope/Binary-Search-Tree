/**
 * A basic implementation of a node in a binary search tree. It is only compatible with integers.
 * 
 * @author Rhys Walker
 * @version 1.1
 * @since 2023-12-11
 */

public class Node {
    private int data;
    private Node right;
    private Node left;
    private Node parent;

    /**
     * Constructor for a node in out binary tree
     * @param data The data to be stored in a given node
     * @param parent The parent node of our node. Will be null if is root node
     */
    public Node(int data, Node parent){
        this.data = data;
        this.parent = parent;
        this.right = null;
        this.left = null;
    }

    /**
     * Get the data from the node
     * @return The data from the node
     */
    public int getData(){
        return data;
    }

    /**
     * Set the parent pointer for the node
     * @param newParent The node that will be the new parent
     */
    public void changeParent(Node newParent){
        this.parent = newParent;
    }

    /**
     * Set the left pointer
     * @param left The node that will be left child
     */
    public void setLeft(Node left){
        this.left = left;
    }

    /**
     * Set the right pointer
     * @param right The node that will be right child
     */
    public void setRight(Node right){
        this.right = right;
    }

    /**
     * Gets the parent of our node
     * @return The parent of our node
     */
    public Node getParent(){
        return parent;
    }

    /**
     * Gets the right child of our node
     * @return The right child of our node
     */
    public Node getRight(){
        return right;
    }

    /**
     * Gets the left child of our node
     * @return The left child of our node
     */
    public Node getLeft(){
        return left;
    }
}