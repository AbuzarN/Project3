//Syed Naqvi
//San190003
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{
   //member vars
    private Node<T> left;
    private Node<T> right;
    private T payload;
    //constructor
    public Node(Node<T> left, Node<T> right, T dvd)
    {
        this.left =left;
        this.right =right;
        this.payload=dvd;
    }
    //accessors and mutators
    public Node<T> getLeft(){return this.left;}
    public Node<T> getRight(){return this.right;}
    public T getPayload(){return this.payload;}

    public void setLeft(Node<T> left){this.left=left;}
    public void setRight(Node<T> right){this.right=right;}
    public void setPayload(T payload){this.payload=payload;}

   //compareTo opperator
    @Override
    public int compareTo(Node<T> node){
        return this.getPayload().compareTo(node.getPayload());
    }
   //calls the DVD toString();
    @Override
    public String toString(){return payload.toString();}
}