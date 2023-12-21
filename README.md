# Changing parameters
Here the main goal was to change some of the parameters of the code. This was to feature alternate versions of the functions that worked previously.

### Example
```Java
// returns an ArrayList<Integer>
tree.listToNode(5);

// returns an ArrayList<Node>
tree.nodesToNode(6);
```

*The benefit of this is that rather than getting an array of integers we now get an array of nodes. before we would need to then use the ``` tree.findNode(tree.listToNode(5).get(tree.listToNode(5).size()-1))).getData()``` in order to get the parents nodes data and it would be quite time consuming and complicated to look at. It just removes the '''tree.findNode() call'''*

This is just one example of improvements that have been made. Check the Sample-Code branch for a full list of functions and sample use cases.

--Rhys--