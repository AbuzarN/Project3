//Syed Naqvi
//San190003
//import files
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Main
{
    public static void main(String args[]) throws IOException
    {
       //create a String to use to open a file of that name
        String fileName = "sample_inventory.dat";
        FileInputStream Fstream = new FileInputStream(fileName);
        Scanner fScnr = new Scanner(Fstream);
        //create a binary tree
        BinTree <DVD> B = new BinTree <DVD>();
        
        //read the each line in the inventory 
        while (fScnr.hasNextLine())
        {
           //parse each line by ","
            String line =  fScnr.nextLine();
            String[] parts = line.split(",");
            
            //create a temporary DVD to be used as a Node
            DVD temp = new DVD( parts[0], Integer.parseInt(parts[1]) , Integer.parseInt(parts[2])); 
            //System.out.print(temp.getTitle()+" "+temp.getAvalible()+" "+temp.getRented());
            //System.out.println();

            //System.out.println("Inserteing: "+ parts[0]+parts[1]+parts[2]);
            
            //Node to insert in the tree
            Node <DVD>tempNode = new Node<DVD> (null, null, temp);
            //insert Node into tree
            B.insert(tempNode);   
            //System.out.println("");
        }

        //String logfile = scnr.nextLine();
        
        //create a string to read the log
        String logfile = "sample_transaction.log";
        FileInputStream logStream = new FileInputStream(logfile);
        Scanner logScnr = new Scanner(logStream);

        //Log raed
        //Read all log lines
        while(logScnr.hasNextLine())
        {
           //parse the log lines by " "
            String line = logScnr.nextLine();
            String[] parts = line.split(" ",2);
            //System.out.println(line);
            
            //cases for each action
            if (parts[0].compareTo("add")==0)
            {
                int num = Integer.parseInt(parts[1].substring(parts[1].indexOf(",")+1));
                parts[1]= parts[1].substring(0, parts[1].indexOf(","));

                DVD temp  = new DVD(parts[1],0,0);
                
                // if the DVD doesnt exist add it in
                if (B.search(new DVD(parts[1],0,0))==null)
                {
                    DVD insertTemp = new DVD(parts[1],num,0);
                    Node<DVD> tempNode= new Node<DVD>(null, null, insertTemp);
                    B.insert(tempNode);
                }
                else//update the node
                {
                    M(B, temp,num);
                }
                
            }
            //Same as add just removing
            else if (parts[0].compareTo("remove")==0)
            {
                int num = Integer.parseInt(parts[1].substring(parts[1].indexOf(",")+1));
                parts[1]= parts[1].substring(0, parts[1].indexOf(","));

                DVD temp  = new DVD(parts[1],0,0);
                //if the avalible + rented =0 then delete node
                if ( (B.search(temp)).getAvalible() + (B.search(temp)).getRented() - num <= 0)
                {
                    B.delete(temp);
                }
                else
                {
                    M(B,temp, -1 * num);
                }
            }
            //if rent then call the rent function
            else if (parts[0].compareTo("rent")==0)
            {
                DVD temp  = new DVD(parts[1],0,0);
                rent(B, temp);
            }
            //if return call the rent function but just subtract
            else if (parts[0].compareTo("return")==0)
            {
                DVD temp  = new DVD(parts[1],0,0);
                returnDVD(B,temp);
            }
        }
        //this prints the log
        B.printInorder(B.getRoot());
        //DVD search = new DVD("\"The Crow\"", 0, 100);
        //System.out.print(B.search(search));
        
        //closing scnaers
        logScnr.close();
        fScnr.close();
        Fstream.close();
    }
    //this finds the node and adds "add" to avalible
    public static void M(BinTree<DVD> B, DVD key, int add)
    {
        //Node tempNode = new Node(null,null,key);
        DVD temp = B.search(key);
        temp.setAvalible(temp.getAvalible()+add);
        //System.out.println(B.search(key));
    }
    // This searches the tree for the right DVD then moces num from avalible to rent
    public static void rent(BinTree<DVD> B, DVD key)
    {
        DVD temp = B.search(key);
        temp.setAvalible(temp.getAvalible()-1);
        temp.setRented(temp.getRented()+1);
        //System.out.println(B.search(key));
    }
    //this moves rented to avalible
    public static void returnDVD(BinTree<DVD> B, DVD key)
    {
        //System.out.println("start");
        DVD temp = B.search(key);
        temp.setAvalible(temp.getAvalible()+1);
        temp.setRented(temp.getRented()-1);
        //System.out.println(B.search(key));
    }
}