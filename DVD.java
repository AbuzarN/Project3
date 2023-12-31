//Syed Naqvi
//San190003

public class DVD implements Comparable<DVD>
{
   //given member vars
    private String Title;
    private int Avalible;
    private int Rented;
    //overriden constructors
    public DVD(String Title, int Avalible, int Rented)
    {
        this.Title = Title;
        this.Avalible = Avalible;
        this.Rented =Rented;   
    }
   
   //compareTo call
    @Override
    public int compareTo(DVD A)
    {
        return (this.getTitle()).compareTo(A.getTitle());
    }
    //toString call
    @Override
    public String toString(){
        System.out.printf("%-28s", this.getTitle().substring(1,this.getTitle().length()-1));
        System.out.printf("%-4s",getAvalible());
        System.out.print(getRented());
        return  "\n";
    }

   //accessors and mutators
    public String getTitle(){return this.Title;}
    public int getAvalible(){return this.Avalible;}
    public int getRented(){return this.Rented;}

    public void setTitle(String Title){this.Title = Title;}
    public void setAvalible(int Avalible){this.Avalible=Avalible;}
    public void setRented(int Rented){this.Rented=Rented;}
}