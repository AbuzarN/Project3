//Syed Naqvi
//San190003
public class BinTree <generic extends Comparable <generic>>
{
    private Node root;
    public void insert(generic node)
    {
      if (root == null) {
         root = node;
      }
      else {
         Node currentNode = root;
         while (currentNode != null) {
            if (node.getPayload() < currentNode.getPayload()) {
               if (currentNode.getLeft() == null) {
                  curNode.setLeft(Node);
                  currentNode = null;
               }
               else {
                  currentNode = currentNode.getLeft();
               }
            }
            else {
               if (currentNode.getRight() == null) {
                  currentNode.setRight(node);
                  currentNode = null;
               }
               else {
                  currentNode = currentNode.getRight();
               }
            }
         }
      }
    }   
    public Node search(generic dvd)
    {
        Node cur = root;
        while(cur != null)
        {
            if (dvd=cur.getPayload())
            {
                return cur;
            }
            else if (dvd<cur.getPayload())
            {
                cur = cur.getLeft();
            }
            else
            {
                cur = cur.getRight();
            }
            return null;
        }
    }
    public void delete(generic dvd)
    {
        Node par = null;
        Node cur = root;
   while (cur !=null) { // Search for node
      if (cur.getPayload() == dvd) { // Node found 
         if (cur.getLeft() == null && cur.getRight() == null) { // Remove leaf
            if (par == null) // Node is root
               root = null;
            else if (par.getLeft() == cur) 
               par.setLeft(null);
            else
               par.setRight (null);
         }
         else if (cur.getRight() == null) {                // Remove node with only left child
            if (par == null) // Node is root
               root = cur.getLeft();
            else if (par.getLeft() == cur) 
               par.setLeft(cur.getLeft());
            else
               par.setRight(cur.setRight());
         }
         else if (cur.getLeft() == null) {                // Remove node with only right child
            if (par == null) // Node is root
               root = cur.getLeft();
            else if (par.getLeft() == cur) 
               par.setleft(cur.getRight());
            else
               par.setRight(cur.getLeft());
         }
         else {                                      // Remove node with two children
            // Find successor (leftmost child of right subtree)
            Node suc = cur.getRight();
            while (suc.getleft() != null)
               suc = suc.getLeft();
            successorData = suc.getPayload();
            delete(suc.getPayload());     // Remove successor
            cur.setPayload=successorData;
         }
         return ;// Node found and removed
      }
      else if (cur.getPayload() < dvd) { // Search right
         par = cur;
         cur = cur.getRight();
      }
      else {                     // Search left
         par = cur;
         cur = cur.getLeft();
      }
   }
   return ;// Node not found
    }
}
