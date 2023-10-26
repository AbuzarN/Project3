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

            System.out.println("Inserteing: "+ parts[0]+parts[1]+parts[2]);

            Node tempNode = new Node (null, null, temp);
            B.insert(tempNode);   
            System.out.println("");
        }
        String logfile = scnr.nextLine();
        logfile = "sample_transaction.log";
        FileInputStream logStream = new FileInputStream(logfile);
        Scanner logScnr = new Scanner(logStream);

        //Log raed
        while(logScnr.hasNextLine())
        {
            String line = logScnr.nextLine();
            String[] parts = line.split(" ");
            //System.out.println(line);
            if (parts[0].compareTo("add")==0)
            {
                int num = Integer.parseInt(parts[1].substring(parts[1].indexOf(",")+1));
                parts[1]= parts[1].substring(0, parts[1].indexOf(","));

                DVD temp  = new DVD(parts[1],0,0);
                if (B.search(new DVD(parts[1],0,0))==null)
                {
                    Node tempNode= new Node(null, null, temp);   
                    B.insert(tempNode);
                }
                else
                {
                    M(B, temp,num);
                }
                
            }
            else if (parts[0].compareTo("remove")==0)
            {
                DVD temp  = new DVD(parts[1],0,0);
                B.delete(temp);
            }
            else if (parts[0].compareTo("rent")==0)
            {
                DVD temp  = new DVD(parts[1],0,0);
                rent(B, temp);
            }
            else if (parts[0].compareTo("return")==0)
            {
                //System.out.println("return");
                DVD temp  = new DVD(parts[1],0,0);
                returnDVD(B,temp);
            }
        }


        //DVD search = new DVD("\"The Crow\"", 0, 100);
        //System.out.print(B.search(search));
        fScnr.close();
        Fstream.close();
    }
    public static void M(BinTree<DVD> B, DVD key, int add)
    {
        //Node tempNode = new Node(null,null,key);
        DVD temp = (DVD) B.search(key);
        temp.setAvalible(temp.getAvalible()+add);
        System.out.println(B.search(key));
    }
    public static void rent(BinTree<DVD> B, DVD key)
    {
        DVD temp = (DVD) B.search(key);
        temp.setAvalible(temp.getAvalible()-1);
        temp.setRented(temp.getRented()+1);
        System.out.println(B.search(key));
    }
    public static void returnDVD(BinTree<DVD> B, DVD key)
    {
        //System.out.println("start");
        DVD temp = (DVD) B.search(key);
        //temp.setAvalible(temp.getAvalible()+1);
        //temp.setRented(temp.getRented()-1);
        System.out.println(B.search(key));
    }
}