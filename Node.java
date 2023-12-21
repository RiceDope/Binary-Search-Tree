/**
 * A basic implementation of a node in a binary search tree. It is only compatible with integers.
 * 
 * @author Rhys Walker
 * @version 1.2
 * @since 2023-12-14
 */

public class Node {
    private int data;
    private Node right;
    private Node left;

    /**
     * Constructor for a node in out binary tree
     * @param data The data to be stored in a given node
     * @param parent The parent node of our node. Will be null if is root node
     */
    public Node(int data){
        this.data = data;
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