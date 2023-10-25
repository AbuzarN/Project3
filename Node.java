public class Node <generic extends Comparable<generic>>
{
    private generic Left;
    private generic Right;
    private generic Payload;
    public Node(generic dvd)
    {
        payload=dvd;
    }
    public generic getLeft(){return Left;}
    public generic getRight(){return Right;}
    public generic getPayload(){return Payload;}

    public setLeft(generic left){Left=left;}
    public setRight(generic right){Right=right;}
    public setPayload(generic payload){Payload=payload;}
}
