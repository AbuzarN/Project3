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

    //insert function driver
    public void insert(Node<T> node)
    {insert2(root, node.getPayload()).getPayload();}
    //insert function
    public Node<T> insert2(Node<T> node, T dvd)
    {
        //if root is empty then set dvd as root
        if (root == null )
            {root = new Node<T>(null, null, dvd);}

        //if the curent node is null create a node with dvd as the payload
        if (node == null)
            {return new Node<T> (null,null,dvd);}

        //if dvd is < current node then go left
        if (dvd.compareTo(node.getPayload())<0)
            {node.setLeft(insert2(node.getLeft(),dvd));}

        //if dvd is > current node then go right
        else if (dvd.compareTo(node.getPayload())>0)
            {node.setRight(insert2(node.getRight(),dvd));}
      
      //this is to keep the program from whinning
      return node;
    }   
    //search function driver
    public T search (T dvd)
    {return search2(root, dvd);}
    //search function
    private T search2(Node<T> node, T dvd)
    {
        //if empty tree return null
        if (node == null)
            {return null;}

        //if searchVal is the node.val then return that node
        else if (node.getPayload().compareTo(dvd)==0)
            {return node.getPayload();}

        //if searchVal is < dvd go left
        else if (node.getPayload().compareTo(dvd)>0)
            {return search2(node.getLeft(), dvd);}

        //if searchVal is > dvd go right
        else if (node.getPayload().compareTo(dvd)<0)
            {return search2(node.getRight(), dvd);}

        //return null if all above fails
        return null;
    }
    //delete function driver
    public void delete(T dvd)
    {delete2(root,dvd);}
    //delete function
    private Node<T> delete2(Node<T> node, T dvd)
    {
        //if node is null then return that node 
        if (node == null)
            {return node;}

        //if curVal<node.val move left
        else if (dvd.compareTo(node.getPayload()) < 0) 
            {node.setLeft(delete2(node.getLeft(), dvd));} 

        //if curVal>node.val move right
        else if (dvd.compareTo(node.getPayload()) > 0) 
            {node.setRight(delete2(node.getRight(), dvd));} 

        //curVal=node.val
        else
        {
            //check if there are any more branches
            if (node.getLeft() == null) 
                {return node.getRight();} 
            
            else if (node.getRight() == null)
                {return node.getLeft();}    
            //set the current node to the the last leaf in the left branch in the subtree
            node.setPayload(leftBranchleaf(node.getRight()));
            //delete the node
            node.setRight(delete2(node.getRight(), node.getPayload()));
        }
        //return node
        return node;
    }
    //used to find the left most leaf in a subtree
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

   //transversal driver
   public void printInorder()
   {
      printInorder2(root);
   }
   //transversal method recursive to print the log
    public void printInorder2(Node<T> node)
    {
        if (node == null)
        {return;}
 
        // First recur on left child
        printInorder2(node.getLeft());
 
        // Then print the data of node
        System.out.println(node.toString());
 
        // Now recur on right child
        printInorder2(node.getRight());
    }
}