//Syed Naqvi
//San190003
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Project3
{
    public static void main(String args[]) throws IOException
    {
        Scanner scnr = new Scanner (System.in);
        String fileName = scnr.next();
        fileName = "sample_inventory.dat";
        scnr.close();
        FileInputStream Fstream = new FileInputStream(fileName);
        Scanner fScnr = new Scanner(Fstream);
        BinTree <DVD> B = new BinTree <DVD>();
        while (fScnr.hasNextLine())
        {
            String line =  fScnr.nextLine();
            String[] parts = line.split(",");
            DVD temp = new DVD( parts[0], Integer.parseInt(parts[1]) , Integer.parseInt(parts[2])); 
            System.out.print(temp.getTitle()+" "+temp.getAvalible()+" "+temp.getRented());
            System.out.println();
            Node tempNode = new Node (null, null, temp);
            B.insert(tempNode);   
        }
        fScnr.close();
        Fstream.close();
    }
}