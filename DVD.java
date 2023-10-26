//Syed Naqvi
//San190003
public class DVD implements Comparable<DVD>
{
    private String Title;
    private int Avalible;
    private int Rented;
    public DVD(String Title, int Avalible, int Rented)
    {
        this.Title = Title;
        this.Avalible = Avalible;
        this.Rented =Rented;   
    }

    @Override
    public int compareTo(DVD A)
    {
        return (this.getTitle()).compareTo(A.getTitle());
    }
    @Override
    public String toString(){
        return "" + "Title: " + getTitle() + " Available: " + getAvalible() + " Rented: " + getRented();
    }


    public String getTitle(){return this.Title;}
    public int getAvalible(){return this.Avalible;}
    public int getRented(){return this.Rented;}

    public void setTitle(String Title){this.Title = Title;}
    public void setAvalible(int Avalible){this.Avalible=Avalible;}
    public void setRented(int Rented){this.Rented=Rented;}

}
