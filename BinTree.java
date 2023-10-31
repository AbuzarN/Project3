//Syed Naqvi
//San190003
public class BinTree <T extends Comparable <T>>
{
   //Bintree member vars
    private Node<T> root = null;
    public BinTree(){}
    //constructor
    public BinTree(T node)
    {
      root = new Node<T>(null,null, node);
    }
    //insert function from zybooks
    public void insert(Node<T> node)
    {
      
      if (root == null) {
         root = node;
      }
      else {
         Node<T> currentNode = root;
         while (currentNode != null) {

            //System.out.println( ((DVD)currentNode.getPayload()).getTitle() );

            if (node.getPayload().compareTo(currentNode.getPayload())<0) {
               if (currentNode.getLeft() == null) 
               {
                  //System.out.println("2");  
                  currentNode.setLeft(node);
                  currentNode = null;
               }
               else 
               {
                  //System.out.println("2");
                  currentNode = currentNode.getLeft();
               }
            }
            else {
               if (currentNode.getRight() == null) 
               {
                  //System.out.println("3");
                  currentNode.setRight(node);
                  currentNode = null;
               }
               else 
               {
                  //ystem.out.println("3");
                  currentNode = currentNode.getRight();
               }
            }            
         }
      }
    }   
    //search function from zybooks
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
      delete2(getRoot(),dvd);
    }
    //delete function 
    private Node<T> delete2(Node<T> node, T dvd)
    {
      if (node == null)
      {return node;}

      else if (dvd.compareTo(node.getPayload()) < 0) 
      {node.setLeft(delete2(node.getLeft(), dvd));} 

      else if (dvd.compareTo(node.getPayload()) > 0) 
      {node.setRight(delete2(node.getRight(), dvd));} 

      else
      {
          if (node.getLeft() == null) 
          {return node.getRight();} 
          
          else if (node.getRight() == null)
          {return node.getLeft();}    

          node.setPayload(leftBranchleaf(node.getRight()));
          node.setRight(delete2(node.getRight(), node.getPayload()));
      }

      return node;
    }
    private T leftBranchleaf(Node<T> node) 
    {
        T leaf = node.getPayload();
        while (node.getLeft() != null) 
        {
            leaf = node.getLeft().getPayload();
            node = node.getLeft();
        }
        return leaf;
    }

   //transversal method recursive to print the log
    public void printInorder(Node<T> node)
    {
        if (node == null)
            return;
 
        // First recur on left child
        printInorder(node.getLeft());
 
        // Then print the data of node
        System.out.println(node.toString());
 
        // Now recur on right child
        printInorder(node.getRight());
    }
   //return root function for recursive log
    public Node<T> getRoot()
    {
      return root;
    }
}
