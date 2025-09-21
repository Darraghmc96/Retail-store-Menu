
/**
 * Write a description of class Books here.
 *
 * @author (Darragh mcmanus)
 * @version (a version number or a date)
 */
public class Books extends GoldenDiscs
{
    //instance variables
    private String author;
    private String genre;
    private int pages;
    
    
    
    
    //blank object
    public Books()
    {
        super();
        this.author = "";
        this.genre = "";
        this.pages =0;
    }
    
    //object with data
    public Books(String author, String genre, int pages, double price, int quantity, String name)
    {
        super(price,quantity,name);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
    
    //getters
    public String getAuthor()
    {
        return this.author;
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public int pages()
    {
        return this.pages;
    }
    
    //setters
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    public void setPages(int pages)
    {
        this.pages = pages;
    }
    
    
    //toString
    public String toString()
    {
        return super.toString() +  "\nauthor: " + this.author + "\n" + 
        "genre: " + this.genre + "\n" + 
        "pages: " + this.pages + "\n";
        
    }
    
}
