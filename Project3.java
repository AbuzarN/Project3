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
        FileInputStream Fstream = new FileInputStream(fileName);
        Scanner fScnr = new Scanner(Fstream);
        BinTree <DVD> B = new BinTree <DVD>();
        while (fScnr.hasNextLine())
        {
            String line =  fScnr.nextLine();
            String[] parts = line.split(",");
            DVD temp = new DVD( parts[0], Integer.parseInt(parts[1]) , Integer.parseInt(parts[2])); 
            //System.out.print(temp.getTitle()+" "+temp.getAvalible()+" "+temp.getRented());
            //System.out.println();
            Node tempNode = new Node (null, null, temp);
            B.insert(tempNode);   
        }
        String logfile = scnr.nextLine();
        logfile = "sample_transaction.log";
        FileInputStream logStream = new FileInputStream(logfile);
        Scanner logScnr = new Scanner(logStream);

        while(logScnr.hasNextLine())
        {
            String line = logScnr.nextLine();
            String[] parts = line.split(" ");
            //System.out.println(line);
            if (parts[0].compareTo("add")==0)
            {
                DVD temp = B.search(new DVD(parts[1],0,0));
                if(temp!=null)
                {
                    temp.setAvalible(temp.getAvalible()+Integer.parseInt(parts[2]));
                }
                else
                {
                    Node tempNode =new Node(null,null,new DVD(parts[1],Integer.parseInt(parts[2]),0));
                    B.insert(tempNode);
                }
                System.out.println("add");
            }
            else if (parts[0].compareTo("remove")==0)
            {
                System.out.println("remove");
            }
            else if (parts[0].compareTo("rent")==0)
            {
                System.out.println("rent");
            }
            else if (parts[0].compareTo("return")==0)
            {
                System.out.println("return");
            }
        }


        DVD search = new DVD("\"The Crow\"", 0, 100);
        System.out.print(B.search(search));
        fScnr.close();
        Fstream.close();
    }
}