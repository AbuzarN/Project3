//Syed Naqvi
//San190003
public class BinTree <T extends Comparable <T>>
{
    private Node<T> root = null;
    public BinTree(){}
    public BinTree(T node)
    {
      root = new Node<T>(null,null, node);
    }
    public void insert(Node<T> node)
    {
      if (root == null) {
         root = node;
      }
      else {
         Node<T> currentNode = root;
         while (currentNode != null) {
            if (node.getPayload().compareTo(currentNode.getPayload())<0) {
               if (currentNode.getLeft() == null) {
                  currentNode.setLeft(node);
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
    public T search(T dvd)
    {
        Node<T> cur = root;
        while(cur != null)
        {
         //System.out.println(((DVD)cur.getPayload()).getTitle());
            //System.out.println("dvd: "+((DVD)dvd).getTitle()+"/cur: "+((DVD)cur.getPayload()).getTitle()+"    "+ dvd.compareTo(cur.getPayload()));
            if (dvd.compareTo(cur.getPayload())==0)
            {
               //System.out.println("1");
                return cur.getPayload();
            }
            else if (dvd.compareTo(cur.getPayload())<0)
            {
               //System.out.println("2");
                cur = cur.getLeft();
            }
            else
            {
               //System.out.println("3");
                cur = cur.getRight();
            }
        }
        return null;
    }
    public void delete(T dvd)
    {
        Node<T> par = null;
        Node<T> cur = root;
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
            {
               root = cur.getLeft();
            }  
            else if (par.getLeft() == cur) 
            {
               par.setLeft(cur.getLeft());
            }
            else
            {
               par.setRight(cur.getRight());
            }
         }
         else if (cur.getLeft() == null) {                // Remove node with only right child
            if (par == null) // Node is root
               root = cur.getLeft();
            else if (par.getLeft() == cur) 
               par.setLeft(cur.getRight());
            else
               par.setRight(cur.getLeft());
         }
         else {                                      // Remove node with two children
            // Find successor (leftmost child of right subtree)
            Node<T> suc = cur.getRight();
            while (suc.getLeft() != null)
               suc = suc.getLeft();
            T successorData = suc.getPayload();
            delete(suc.getPayload());     // Remove successor
            cur.setPayload(successorData);
         }
         return ;// Node found and removed
      }
      else if (cur.getPayload().compareTo(dvd)<0) { // Search right
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
