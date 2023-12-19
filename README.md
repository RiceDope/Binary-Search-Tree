Changing parameters of some of the functions in BST to use Node rather than int. Functions using int will still be available but will be renamed.

Most have been changed. To fix any issues caused change the function names to have Int at the end e.g. "tree.findParentInt(DATA)".
Or change the input to the function to feature a node instead e.g. "tree.findParent(NODE)".

Changed the tree.remove(int data) function to node use tree.removeNode(Node node) both are available.

Added the tree.addNode(Node node) function this allows user to keep reference of the node they are wishing to add.
Node node = new Node(5);
tree.addNode(node);

// still have reference of node
tree.addItem(2);
System.out.println(node.getLeft().getData());

Last commit before merge :-)

-- Rhys --
