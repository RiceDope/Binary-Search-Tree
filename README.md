Changing parameters of some of the functions in BST to use Node rather than int. Functions using int will still be available but will be renamed.

Most have been changed. To fix any issues caused change the function names to have Int at the end e.g. "tree.findParentInt(DATA)".
Or change the input to the function to feature a node instead e.g. "tree.findParent(NODE)".

Changed the tree.remove(int data) function to node use tree.removeNode(Node node) both are available.

Added the tree.addNode(Node node) function this allows user to keep reference of the node they are wishing to add.

```Java
// create a node and add to tree
Node node = new Node(5);
tree.addNode(node);
tree.addItem(2);

// still have reference of node
System.out.println(node.getLeft().getData());
```

Merge Schedule:
- 24/12/2023 "Just before Christmas"
- Code to be reviewed and tested
- Sample-Code branch needs updating in line with current release
- Reorganisation of methods and potential renaming to come

ANYONE USING THIS BRANCH FUNCTION NAMES ARE SUBJECT TO CHANGE BEFORE COMMITING TO MAIN (For backwards compatibility)

-- Rhys --
