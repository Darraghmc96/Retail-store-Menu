
/**
 * Write a description of class Music here.
 *
 * @author (Darragh mcmanus)
 * @version (a version number or a date)
 */
public class Music extends GoldenDiscs
{
    //instance variables
    private String type;
    private String artist;
    private int year;

    //blank object
    public Music()
    {
        super();
        this.type = "";
        this.artist ="";
        this.year = 0;

    }
    
    
    public Music(String type, String artist, int year, double price, int quantity, String name) {
        super(price, quantity, name);
        this.type = type;
        this.artist = artist;
        this.year = year;
    }

    //getters
    public String getType()
    {
        return this.type;
    }

    public String getArtist()
    {
        return this.artist;
    }

    public int getYear()
    {
        return this.year;
    }

    //setters
    public void setType(String type)
    {
        this.type = type;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    //toString
    public String toString()
    {
        return super.toString() +  "\ntype: " + this.type + "\n" + 
        "artist: " + this.artist + "\n" + 
        "year: " + this.year + "\n";

    }
}
