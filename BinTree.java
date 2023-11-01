//Syed Naqvi
//San190003
public class BinTree <T extends Comparable <T>>
{
   //Bintree member vars
    private Node<T> root = null;
    public BinTree(){}

    //constructor
    public BinTree(T node)
    {root = new Node<T>(null,null, node);}

    //insert function
    public void insert(Node<T> node)
    {insert2(root, node.getPayload()).getPayload();}

    public Node<T> insert2(Node<T> node, T dvd)
    {
      if (root == null )
      {
         root = new Node<T>(null, null, dvd);
      }
      if (node == null)
      {
         return new Node<T> (null,null,dvd);
      }
      if (dvd.compareTo(node.getPayload())<0)
      {node.setLeft(insert2(node.getLeft(),dvd));}
      
      else if (dvd.compareTo(node.getPayload())>0)
      {node.setRight(insert2(node.getRight(),dvd));}
      return node;
    }   
    //search function from zybooks
    public T search (T dvd)
    {return search2(root, dvd);}
    private T search2(Node<T> node, T dvd)
    {
        if (node == null)
        {return null;}

        else if (node.getPayload().compareTo(dvd)==0)
        {return node.getPayload();}

        else if (node.getPayload().compareTo(dvd)>0)
        {return search2(node.getLeft(), dvd);}

        else if (node.getPayload().compareTo(dvd)<0)
        {return search2(node.getRight(), dvd);}

        return null;
    }
    //delete function 
    public void delete(T dvd)
    {delete2(root,dvd);}
    
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
   public void printInorder()
   {
      printInorder(root);
   }
    public void printInorder(Node<T> node)
    {
        if (node == null)
        {return;}
 
        // First recur on left child
        printInorder(node.getLeft());
 
        // Then print the data of node
        System.out.println(node.toString());
 
        // Now recur on right child
        printInorder(node.getRight());
    }
}
