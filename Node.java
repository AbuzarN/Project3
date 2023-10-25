//Syed Naqvi
//San190003
public class Node <generic extends Comparable<generic>>
{
    private generic Left;
    private generic Right;
    private generic Payload;
    public Node(generic dvd)
    {
        Payload=dvd;
    }
    public generic getLeft(){return Left;}
    public generic getRight(){return Right;}
    public generic getPayload(){return Payload;}

    public void setLeft(generic left){Left=left;}
    public void setRight(generic right){Right=right;}
    public void setPayload(generic payload){Payload=payload;}
}
