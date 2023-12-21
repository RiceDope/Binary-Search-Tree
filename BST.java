/**
 * An implementation of a Binary Search Tree.
 * 
 * @author Rhys Walker
 * @version 1.3
 * @since 2023-12-21
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
            root = new Node(data);
        }
        else {
            insert(data);
        }
    }

    /**
     * Insert a node into the tree
     * @param node The node we want to insert
     */
    public void addNode(Node node){
        if (root == null){
            root = node;
        }
        else {
            insertNode(node);
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
                    currentNode.setRight(new Node(data)); // set right child to be new node
                    return root;
                }
                else{
                    currentNode = currentNode.getRight(); // set to right as that the way we are going
                }
            }
            else if(data < currentNode.getData()){ // going left
                if (currentNode.getLeft() == null){ // we have found our position
                    currentNode.setLeft(new Node(data)); // set right child to be new node
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
     * Called from the public function to insert a node into the tree
     * @param node The node we want to insert into the tree
     * @return The root node of the tree
     */
    private Node insertNode(Node node){
        Node currentNode = root;
        while(true){
            if(node.getData() > currentNode.getData()){ // going right
                if (currentNode.getRight() == null){ // we have found our position
                    currentNode.setRight(node); // set right child to be new node
                    return root;
                }
                else{
                    currentNode = currentNode.getRight(); // set to right as that the way we are going
                }
            }
            else if(node.getData() < currentNode.getData()){ // going left
                if (currentNode.getLeft() == null){ // we have found our position
                    currentNode.setLeft(node); // set right child to be new node
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
     * Produces a list of integers to the item we are looking for
     * @param data Value of what we are looking for
     * @return ArrayList of values (int) to node
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
     * Produces a list of nodes to the item we are looking for
     * @param data Value of what we are looking for
     * @return ArrayList of values (Node) to node
     */
    public ArrayList<Node> nodesToNode(Node node){
        int data = node.getData();
        Node currentNode = root;
        ArrayList<Node> list = new ArrayList<Node>();
        while(true){
            if (currentNode != null){ // make sure node is not null

                list.add(currentNode);

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
     * Traverse the tree using pre order traversal
     * @return ArrayList of pre order traversal
     */
    public ArrayList<Node> preOrderTraversal(){

        // create a new arrayList to gether the terms
        ArrayList<Node> preOrderList = new ArrayList<Node>();

        // call the recursive function
        preOrderList = checkNodePO(root, preOrderList);

        // return our list
        return preOrderList;
    }

    /**
     * Function to recursively check the tree in pre order
     * @param node The node we are currently on
     * @param preOrderList The list to add to
     * @return ArrayList of pre order
     */
    private ArrayList<Node> checkNodePO(Node node, ArrayList<Node> preOrderList){

        // check we are not on a leaf node
        if (node == null){
            return preOrderList;
        }

        // add node to the list
        preOrderList.add(node);

        // check left and right subtree
        preOrderList = checkNodePO(node.getLeft(), preOrderList);
        preOrderList = checkNodePO(node.getRight(), preOrderList);

        // return the list
        return preOrderList;
    }

    /**
     * Finds the parent of a given node based on its data
     * @param child The node whose parent we want to find
     * @return The parent node
     */
    public Node findParentNode(int childData){

        // get a list of nodes
        ArrayList<Integer> list = listToNode(childData);

        Node parent = findNode(list.get(list.size()-2));

        return parent;
    }

    /**
     * Finds the parent of a given node
     * @param child The node whose parent we want to find
     * @return The parent node
     */
    public Node getNodesParent(Node child){

        // get a list of nodes
        ArrayList<Node> list = nodesToNode(child);

        Node parent = findNode(list.get(list.size()-2).getData());

        return parent;
    }

    /**
     * A function that will remove a given node from the tree based on the data given
     * 
     * @param data The data contained in the node we want to remove
     * @return The root node
     */
    public Node remove(int data){
        // get the node we want to remove from the tree
        Node nodeToRemove = findNode(data);

        if (nodeToRemove == root){

            System.out.println("This section is running");

            // find the in order successor
            ArrayList<Node> inOrder = inOrderTraversal();
            int indexOfOurItem = inOrder.indexOf(nodeToRemove);
            Node successor = inOrder.get(indexOfOurItem+1);

            // set the pointers for the root node
            successor.setLeft(nodeToRemove.getLeft());
            successor.setRight(nodeToRemove.getRight());

            // change the reference to the root of the tree
            root = successor;
        }
        else{
            // get the parent node of the node to remove
            Node parent = getNodesParent(nodeToRemove);

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
            else if (nodeToRemove.getRight() != null && nodeToRemove.getLeft() != null){

                // find the in order successor
                ArrayList<Node> inOrder = inOrderTraversal();
                int indexOfOurItem = inOrder.indexOf(nodeToRemove);
                Node successor = inOrder.get(indexOfOurItem+1);

                // set successors pointers to the children of our node
                successor.setLeft(nodeToRemove.getLeft());
                successor.setRight(nodeToRemove.getRight());

                // remove the successors parents pointer
                Node successorParent = getNodesParent(successor);
                if (getNodesParent(successor).getData() < successor.getData()){
                    // we are on right of parent
                    
                    successorParent.setRight(null);
                }
                else {
                    successorParent.setLeft(null);
                }

                // set the correct node for the parents
                if(parent.getData() < nodeToRemove.getData()){
                    // if parent data is less than to remove then our node must be a right child
                    parent.setRight(successor);
                }
                else{
                    // if parent is not less then must be more so we will set the left parent
                    parent.setLeft(successor);
                }

            }
        }

        return root;

    }

    /**
     * A function that will remove a given node from the tree based on the data given
     * 
     * @param node The node that we want to remove from the tree
     * @return The root node
     */
    public Node removeNode(Node node){
        // the node we want to remove
        Node nodeToRemove = node;

        if (nodeToRemove == root){

            System.out.println("This section is running");

            // find the in order successor
            ArrayList<Node> inOrder = inOrderTraversal();
            int indexOfOurItem = inOrder.indexOf(nodeToRemove);
            Node successor = inOrder.get(indexOfOurItem+1);

            // set the pointers for the root node
            successor.setLeft(nodeToRemove.getLeft());
            successor.setRight(nodeToRemove.getRight());

            // change the reference to the root of the tree
            root = successor;
        }
        else{
            // get the parent node of the node to remove
            Node parent = getNodesParent(nodeToRemove);

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
            else if (nodeToRemove.getRight() != null && nodeToRemove.getLeft() != null){

                // find the in order successor
                ArrayList<Node> inOrder = inOrderTraversal();
                int indexOfOurItem = inOrder.indexOf(nodeToRemove);
                Node successor = inOrder.get(indexOfOurItem+1);

                // set successors pointers to the children of our node
                successor.setLeft(nodeToRemove.getLeft());
                successor.setRight(nodeToRemove.getRight());

                // remove the successors parents pointer
                Node successorParent = getNodesParent(successor);
                if (getNodesParent(successor).getData() < successor.getData()){
                    // we are on right of parent
                    
                    successorParent.setRight(null);
                }
                else {
                    successorParent.setLeft(null);
                }

                // set the correct node for the parents
                if(parent.getData() < nodeToRemove.getData()){
                    // if parent data is less than to remove then our node must be a right child
                    parent.setRight(successor);
                }
                else{
                    // if parent is not less then must be more so we will set the left parent
                    parent.setLeft(successor);
                }

            }
        }

        return root;

    }
}
