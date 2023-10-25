public class DVD {
    private string Title;
    private int Avalible;
    private int Rented;
    public DVD(string Title, int Avalible, int Rented)
    {
        this.Title = Title;
        this.Avalible = Avalible;
        this.Rented =Rented;   
    }
    public string getTitle(){return this.Title;}
    public int getAvalible(){return this.Avalible;}
    public int getRented(){return this.Rented;}

    public void setTitle(String Title){this.Title = Title;}
    public void setAvalible(int Avalible){this.Avalible=Avalible;}
    public void setRented(int Rented){this.Rented=Rented;}

}
