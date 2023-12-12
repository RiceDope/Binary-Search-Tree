/**
 * An implementation of a Binary Search Tree.
 * 
 * @author Rhys Walker
 * @version 1.1
 * @since 2023-12-12
 */

import java.util.ArrayList;

public class BST {
    private Node root;
    public BST(){
        root = null;
    }

    /**
     * Insert an item into the tree
     * @param data An int that we want to store
     */
    public void addItem(int data){
        if (root == null){
            root = new Node(data, null);
        }
        else {
            insert(data);
        }
    }

    /**
     * A getter function to return the root node of the tree
     * @return The root node of the tree
     */
    public Node root(){
        return root;
    }

    /**
     * Called from the public function to insert an item into the tree
     * @param data The int we want to insert
     * @return The root node of the tree
     */
    private Node insert(int data){
        Node currentNode = root;
        while(true){
            if(data > currentNode.getData()){ // going right
                if (currentNode.getRight() == null){ // we have found our position
                    currentNode.setRight(new Node(data, currentNode)); // set right child to be new node
                    return root;
                }
                else{
                    currentNode = currentNode.getRight(); // set to right as that the way we are going
                }
            }
            else if(data < currentNode.getData()){ // going left
                if (currentNode.getLeft() == null){ // we have found our position
                    currentNode.setLeft(new Node(data, currentNode)); // set right child to be new node
                    return root;
                }
                else{
                    currentNode = currentNode.getLeft(); // set to right as that the way we are going
                }
            }
            else { // node is duplicate and not allowed
                return root;
            }
        }
    }

    /**
     * Finds the node from given data
     * @param data The data in the node we are looking for
     * @return the node that we are looking for, null if can't be found
     */
    public Node findNode(int data){
        Node currentNode = root;

        while(true){
            if (currentNode != null){ // null check

                if (data > currentNode.getData()){ // go right
                    currentNode = currentNode.getRight();
                }

                else if (data < currentNode.getData()){ // go left
                    currentNode = currentNode.getLeft();
                }

                else if (data == currentNode.getData()){ // if not more or less then we know we have found our node
                    return currentNode;
                }
            }

            else { // if null then node isn't in tree
                return null; // not in the tree
            }
        }
    }

    /**
     * Produces a list of items to the item we are looking for
     * @param data Value of what we are looking for
     * @return ArrayList of values to node
     */
    public ArrayList<Integer> listToNode(int data){
        Node currentNode = root;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(true){
            if (currentNode != null){ // make sure node is not null

                list.add(currentNode.getData());

                if (data > currentNode.getData()){ // go right
                    currentNode = currentNode.getRight();
                }

                else if (data < currentNode.getData()){ // go left
                    currentNode = currentNode.getLeft();
                }

                else if (data == currentNode.getData()){ // if not more or less then we know we have found our node
                    return list;
                }
            }
            else { // if node is null then node we are searching for isnt in tree
                return null;
            }
        }
    }

    /**
     * Traverse the tree using in order traversal
     * @return An arraylist of the nodes in order
     */
    public ArrayList<Node> inOrderTraversal(){

        // create the arraylist that is going to house the traversal
        ArrayList<Node> inOrderList = new ArrayList<Node>();

        inOrderList = checkNodeIO(root, inOrderList); // set the list equal to the returned
        return inOrderList; 
    }

    /**
     * Function to recursively check the node in order
     * @param node The node we are currently on
     * @param inOrderList The list to add to
     * @return ArrayList of in order
     */
    private ArrayList<Node> checkNodeIO(Node node, ArrayList<Node> inOrderList){

        // if null we have reached a leaf node
        if (node == null){
            return inOrderList;
        }

        inOrderList = checkNodeIO(node.getLeft(), inOrderList); // recursively check left

        inOrderList.add(node); // add the current node to the list

        inOrderList = checkNodeIO(node.getRight(), inOrderList); // recursively check right

        return inOrderList; // return the list
    }

    /**
     * Finds the parent of a given node
     * @param child The node whose parent we want to find
     * @return
     */
    public Node findParentNode(int childData){

        // get a list of nodes
        ArrayList<Integer> list = listToNode(childData);

        Node parent = findNode(list.get(list.size()-2));

        return parent;
    }

    /**
     * A function that will remove a given node from the tree based on the data given
     * 
     * @param data The data contained in the node we want to remove
     * @return The root node
     */
    public Node removeNode(int data){

        /*
        * Need to add check to see if node we are looking for is root node. If root node complete the steps as given below
        *
        * Then add a condition to remove a node if it has two children by using its in order successor to replace it.
        */

        // get the node we want to remove from the tree
        Node nodeToRemove = findNode(data);
        Node parent = findParentNode(nodeToRemove.getData());

        // check that there is only a right child
        if (nodeToRemove.getRight() != null && nodeToRemove.getLeft() == null){
            // we will just replace the current node with its right child

            // get our nodes only child
            Node child = nodeToRemove.getRight();

            if(parent.getData() < nodeToRemove.getData()){
                // if parent data is less than to remove then our node must be a right child
                parent.setRight(child);
            }
            else{
                // if parent is not less then must be more so we will set the left parent
                parent.setLeft(child);
            }
        }
        // check that there is only a left child
        else if (nodeToRemove.getRight() == null && nodeToRemove.getLeft() != null){
            // we will just replace current node with its left child

            // get our nodes only child
            Node child = nodeToRemove.getLeft();

            if(parent.getData() < nodeToRemove.getData()){
                // if parent data is less than to remove then our node must be a right child
                parent.setRight(child);
            }
            else{
                // if parent is not less then must be more so we will set the left parent
                parent.setLeft(child);
            }
        }
        else if (nodeToRemove.getRight() == null && nodeToRemove.getLeft() == null){
            // if no children just remove reference to the object

            if(parent.getData() < nodeToRemove.getData()){
                // if parent data is less than to remove then our node must be a right child
                parent.setRight(null);
            }
            else{
                // if parent is not less then must be more so we will set the left parent
                parent.setLeft(null);
            }
        }

        return root;
    }
}