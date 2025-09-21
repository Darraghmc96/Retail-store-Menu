
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Driver here.
 *
 * @author (Darragh mcmanus)
 * @version (a version number or a date)
 */
public class Driver
{

    String delay;
    //declare array list
    ArrayList<GoldenDiscs> products;
    /** menu variables **/
    int menuOption =0;
    public Driver()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");
        /** menu variables  **/
        int custMenu = 0;
        int staffOpt = 0;

        /** password variables **/
        String password;
        boolean passwordCorrect = false;
        int attempt = 0;

        //create array list
        products = new ArrayList<GoldenDiscs>();

        do{
            menuOption = stockControl();

            if (menuOption==1)
            {
                do{
                    custMenu = customerMenu();
                    if (custMenu==1)
                    {
                        booksDisplay();
                    }

                    if (custMenu==2)
                    {
                        musicDisplay();
                    }

                    if (custMenu==3)
                    {
                        purchaseBooks();
                    }

                    if (custMenu==4)
                    {
                        purchaseMusic();
                    }

                    if(custMenu ==5)
                    {
                        discount();
                    }

                }while (custMenu !=6);
            }
            else if (menuOption==2)
            {

                do {
                    System.out.print("\f");
                    System.out.println("Enter the password to enter the staff menu");
                    System.out.println("==========================================");
                    password = scan.nextLine();
                    if (password.equalsIgnoreCase("TU914"))
                    {
                        passwordCorrect = true;
                    }
                    else
                    {
                        System.out.println("error wrong password!");
                    }

                }while (!password.equalsIgnoreCase("TU914"));

                
                if (passwordCorrect == true)
                {

                    do{
                        System.out.println("\f");
                        staffOpt = staffMenu();
                        if (staffOpt==1)
                        {
                            newBooks();
                        }

                        if (staffOpt==2)
                        {
                            newMusic();
                        }

                        if (staffOpt==3)
                        {
                            updateStock();
                        }

                    }while( staffOpt !=4);
                }
            }

            else if (menuOption == 3)
            {
                exitMenu();
            }

        }while (menuOption !=3);

    }

    public int stockControl()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        System.out.println("============================");
        System.out.println("Golden Discs - Stock control");
        System.out.println("============================");
        System.out.println("1.   Customer Menu  ");
        System.out.println("2.   Staff menu  ");
        System.out.println("3.   Exit the programme  ");
        System.out.println("=============================");

        System.out.println("enter a menu option!");
        menuOption = scan.nextInt();
        scan.nextLine(); // clear scanner 

        return menuOption;

    }

    public void exitMenu()
    {
        /** EXIT SYSTEM **/

        System.out.println("\f");
        System.out.println("thank you for using the menu, have a good day!!");
        System.out.println("===============================================");
    }

    public int customerMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        System.out.println("============================");
        System.out.println("Golden Discs - Customer Menu");
        System.out.println("============================");
        System.out.println("1.   Books for sale (Display)  ");
        System.out.println("2.   Music for Sale (Display)  ");
        System.out.println("3.   Purchase Book(s) ");
        System.out.println("4.   Purchase Music ");
        System.out.println("5.   Discount check  ");
        System.out.println("6.   Return to stock control menu  ");
        System.out.println("=============================");

        System.out.println("enter a menu option!");
        menuOption = scan.nextInt();
        scan.nextLine(); // clear scanner 

        return menuOption;
    }

    /** customer menu option 1 **/
    public void booksDisplay()
    {
        System.out.print("\f");
        System.out.println("Book Stock display");
        System.out.println("===================");

        if (products.isEmpty() )
        {
            System.out.println("we're sorry there are no items in stock");
            System.out.println("Sorry for the inconvenience");

        }
        else{
            for (GoldenDiscs books: products)  /** iterator */
            { 
                if (books instanceof Books)
                {
                    System.out.println(books.toString());
                }
            }
        }
        delayClear();
    }

    /** customer menu option 2 **/
    public void musicDisplay()
    {
        System.out.print("\f");
        System.out.println("Music Stock display");
        System.out.println("===================");

        if (products.isEmpty() )
        {
            System.out.println("we're sorry there are no items in stock");
            System.out.println("Sorry for the inconvenience");

        }
        else{
            for (GoldenDiscs music: products)  /** iterator */
            {
                if (music instanceof Music)
                {
                    System.out.println(music.toString());
                }
            }  

        }

        delayClear();
    }

    /** customer menu option3 **/
    public void purchaseBooks()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        String name;
        double price;
        int quantity;
        String author;
        String genre;
        int pages;

        double total;
        boolean bookFound =false;
        System.out.println("Purchase Books");
        System.out.println("==============");

        if (products.isEmpty() )
        {
            System.out.println("we're sorry there are no items in stock");
            System.out.println("Sorry for the inconvenience");

        }else
        {

            System.out.println("Enter the name of the book you wish to purchase");
            name = scan.nextLine();

            System.out.println("Enter the price of the book you wish to purchase");
            price = scan.nextDouble();
            scan.nextLine(); // clear scanner

            System.out.println("Enter the author of the book");
            author = scan.nextLine();

            System.out.println("Enter the genre of the books");
            genre = scan.nextLine();

            System.out.println("Enter the amount of pages in the book");
            pages = scan.nextInt();
            scan.nextLine(); // clear scanner 

            Books b =null;
            for (GoldenDiscs books: products)  /** iterator **/
            {
                if (books instanceof Books) 
                {
                    b = (Books) books;

                    if (books.getName().equalsIgnoreCase(name) && books.getPrice() == price && 
                    b.getAuthor().equalsIgnoreCase(author)
                    && b.getGenre().equalsIgnoreCase(genre) /**&& b.getPages() == pages **/ )
                    {
                        bookFound =true;
                    }
                }
            }

            if (bookFound == true)
            {
                System.out.println("This item is in stock!");

                System.out.println("Enter the quantity of the Music you wish to purchase");
                quantity = scan.nextInt();
                scan.nextLine(); // clear scanner

                System.out.println("You have successfully purchased this item");
                total = quantity * price;
                System.out.println("your total is:" + "\n" + total + "£ " );

            }else
            {
                System.out.println("This item does not exist!");
                System.out.println("your purchase was unsuccessful");
            }             

        }

        delayClear();
    }

    /** customer menu option 4 **/
    public void purchaseMusic()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");
        String name;
        double price;
        int quantity;
        String type;
        String artist;
        int year;

        double total;
        boolean musicFound =false;
        System.out.println("Purchase music");
        System.out.println("==============");

        if (products.isEmpty() )
        {
            System.out.println("we're sorry there are no items in stock");
            System.out.println("Sorry for the inconvenience");

        }else
        {
            System.out.println("Enter the name of the Music you wish to purchase");
            name = scan.nextLine();

            System.out.println("Enter the price of the Music you wish to purchase");
            price = scan.nextDouble();
            scan.nextLine(); // clear scanner

            do{
                System.out.println("enter type of the music   (CD/VINYL)");
                type = scan.nextLine();

                if (!type.equalsIgnoreCase("CD") && !type.equalsIgnoreCase("VINYL") )
                {

                    System.out.println("Error, we only sell CD or vinyl!!");
                    System.out.println("enter type of the music   (CD/VINYL)");
                    type = scan.nextLine();
                }
            }while (!type.equalsIgnoreCase ("CD") && !type.equalsIgnoreCase("VINYL") ) ;

            System.out.println("Enter the artist of the music");
            artist = scan.nextLine();

            System.out.print("Enter the year this music was released");
            year = scan.nextInt();
            scan.nextLine(); // clear scanner 
            Music m = null;

            for (GoldenDiscs music: products)  /** iterator **/
            {
                if (music instanceof Music) {

                    m = (Music) music; 
                    if (music.getName().equalsIgnoreCase(name) && music.getPrice() == price && 
                    m.getType().equalsIgnoreCase(type)
                    && m.getArtist().equalsIgnoreCase(artist) && m.getYear() == year) 
                    {
                        musicFound =true;
                    }
                }
            }

            if (musicFound == true)
            {

                System.out.println("This item is in stock!");

                System.out.println("Enter the quantity of the Music you wish to purchase");
                quantity = scan.nextInt();
                scan.nextLine(); // clear scanner

                System.out.println("Your purchase was succesfull!!");
                total = quantity * price;
                System.out.println("your total is:" + "\n" + total + "£ " );

            }else
            {
                System.out.println("This item does not exist!");
                System.out.println("your purchase was unsuccessful");

            }

        }

        delayClear();
    }

    /** customer menu (option 5 ) **/
    public void discount()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        String product;

        String name;
        double price;
        int quantity;

        String type;
        String artist;
        int year;

        String author;
        String genre;
        int pages;

        double total;
        double discountAmount = 0.2;
        double discountTotal;

        System.out.println("Welcome to the discount option");
        System.out.println("Enter your order details and check ifyou qualify for a 20% discount");
        System.out.println("===================================================================");

        do{
            System.out.print("Enter the product you purchased (Music/ Book)");
            product = scan.nextLine();

            if (!product.equalsIgnoreCase("music") && !product.equalsIgnoreCase("book") )
            {

                System.out.println("Error, we only sell music or books!!");
                System.out.print("Enter the product you purchased (Music/ Book)");
                product = scan.nextLine();
            }
        }while (!product.equalsIgnoreCase("music") && !product.equalsIgnoreCase("book") ) ;

        if (product.equalsIgnoreCase ("music") )
        {

            System.out.println("Enter the name of the music");
            name = scan.nextLine();

            System.out.println("Enter the price of the music");
            price = scan.nextDouble();
            scan.nextLine();

            System.out.println("enter type of the music   (CD/VINYL)");
            type = scan.nextLine();

            System.out.println("enter the Artist");
            artist = scan.nextLine();

            System.out.println("enter the year it was released");
            year = scan.nextInt();
            scan.nextLine();

            Music m = null;
            for (GoldenDiscs music: products)  /** iterator **/
            {
                if (music instanceof Music) {

                    m = (Music) music; 
                    if (music.getName().equalsIgnoreCase(name) && music.getPrice() == price && 
                    m.getType().equalsIgnoreCase(type)
                    && m.getArtist().equalsIgnoreCase(artist) && m.getYear() == year) 
                    {
                        System.out.println("your purchase checks out!");
                        System.out.println("Enter the quantity you purchased");
                        quantity = scan.nextInt();
                        scan.nextLine();
                        if (quantity > 3)
                        {

                            total = price * quantity * discountAmount;
                            discountTotal = price * quantity - total;
                            System.out.println("congratulations you qualify for a 20% discount");
                            System.out.println("your new total is:" + "" + discountTotal + "£" );
                        }
                        else
                        {
                            System.out.print("We are sorry , you dont qualify for the discount.");
                        }
                    }
                    else
                    {
                        System.out.println("Error ! , we cant find your purchase.");
                    }
                }

            }
        }
        else
        {
            System.out.println("error!, product doesnt exist");
        }

        if (product.equalsIgnoreCase ("Book"))
        {

            System.out.println("Enter the name of the book you wish to purchase");
            name = scan.nextLine();

            System.out.println("Enter the price of the book you wish to purchase");
            price = scan.nextDouble();
            scan.nextLine(); // clear scanner

            System.out.println("Enter the author of the book");
            author = scan.nextLine();

            System.out.println("Enter the genre of the books");
            genre = scan.nextLine();

            System.out.println("Enter the amount of pages in the book");
            pages = scan.nextInt();
            scan.nextLine(); // clear scanner 

            Books b =null;
            for (GoldenDiscs books: products)  /** iterator **/
            {
                if (books instanceof Books) 
                {
                    b = (Books) books;

                    if (books.getName().equalsIgnoreCase(name) && books.getPrice() == price && 
                    b.getAuthor().equalsIgnoreCase(author)
                    && b.getGenre().equalsIgnoreCase(genre) /** && b.getPages() == pages **/ )
                    {
                        System.out.println("your purchase checks out!");
                        System.out.println("Enter the quantity you purchased");
                        quantity = scan.nextInt();
                        scan.nextLine();
                        if (quantity > 3)
                        {

                            total = price * quantity * discountAmount;
                            discountTotal = price * quantity - total;
                            System.out.println("congratulations you qualify for a 20% discount");
                            System.out.println("your new total is:" + "" + discountTotal + "£" );
                        }
                        else
                        {
                            System.out.print("We are sorry , you dont qualify for the discount.");
                        }
                    }
                    else
                    {
                        System.out.println("Error ! , we cant find your purchase.");
                    }
                }
            }

        }

        delayClear();
    }

    public int staffMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        System.out.println("============================");
        System.out.println("Golden Discs - Staff Menu");
        System.out.println("============================");
        System.out.println("1.   Add new Book to stock list  ");
        System.out.println("2.   Add new music to stock list  ");
        System.out.println("3.   Update stock level for existing item");
        System.out.println("4.   Return to stock control menu  ");
        System.out.println("=============================");

        System.out.println("enter a menu option!");
        menuOption = scan.nextInt();
        scan.nextLine(); // clear scanner 

        return menuOption;
    }

    /** staff menu option 1 **/
    public void newBooks()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");
        GoldenDiscs books;

        /** product variables **/
        String name;
        double price;
        int quantity;
        String author;
        String genre;
        int pages;

        System.out.println("Add new Book to stock list.");
        System.out.println("===========================");

        System.out.println("Enter the name of the book");
        name = scan.nextLine();

        System.out.println("Enter the price of the book");
        price = scan.nextDouble();
        scan.nextLine();

        do{
            System.out.println("Enter the quantity of the book");
            quantity = scan.nextInt();
            scan.nextLine();
            if (quantity <= 0 )
            {
                System.out.println("Error! , you must have at least 1 quantity to add to stock list.");
            }

        }while (quantity <= 0 );

        System.out.println("Enter the author of the book");
        author = scan.nextLine();

        System.out.println("Enter the Genre of the book");
        genre = scan.nextLine();

        System.out.println("Enter the amount pages in the book");
        pages = scan.nextInt();

        books = new Books(author,genre, pages, price, quantity, name);
        products.add(books);

        System.out.println("You have added this item to the stock list!");

        delayClear();
    }

    /** staff menu option 2 **/
    public void newMusic()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        GoldenDiscs music;

        /** product variables **/
        String name;
        double price;
        int quantity;
        String type;
        String artist;
        int year;

        System.out.println("Add new Music to stock list.");
        System.out.println("===========================");

        System.out.println("Enter the name of the music");
        name = scan.nextLine();

        System.out.println("Enter the price of the music");
        price = scan.nextDouble();
        scan.nextLine();
        do{
            System.out.println("Enter the quantity of the music");
            quantity = scan.nextInt();
            scan.nextLine();
            if (quantity <= 0 )
            {
                System.out.println("Error! , you must have at least 1 quantity to add to stock list.");
            }

        }while (quantity <= 0 );
        do{
            System.out.println("enter type of the music   (CD/VINYL)");
            type = scan.nextLine();

            if (!type.equalsIgnoreCase ("CD") && !type.equalsIgnoreCase("VINYL") )
            {

                System.out.println("Error, we only sell CD or vinyl!!");
                System.out.println("enter type of the music   (CD/VINYL)");
                type = scan.nextLine();
            }
        }while (!type.equalsIgnoreCase ("CD") && !type.equalsIgnoreCase("VINYL") ) ;

        System.out.println("enter the Artist");
        artist = scan.nextLine();

        System.out.println("enter the year it was released");
        year = scan.nextInt();
        scan.nextLine();

        music = new Music(type, artist, year, price, quantity, name);
        products.add(music);

        System.out.println("You have added this item to the stock list!");

        delayClear();
    }

    /** staff menu option 3 **/
    public void updateStock()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        /** music variables **/
        String name;
        double price;
        int quantity;
        String type;
        String artist;
        int year;

        /** book variables **/

        String author;
        String genre;
        int pages;

        String updateStock;
        String newStock;
        int stockAmount;

        System.out.println("A new delivery of stock has arrived!");
        System.out.println("Do you wish to update the stock  (YES/NO)");
        updateStock = scan.nextLine();

        if (updateStock.equalsIgnoreCase ("YES") )
        {
            do
            {
                System.out.print("Enter the new stock that has arrived  (music/book)");
                newStock = scan.nextLine();
                if (!newStock.equalsIgnoreCase("music")  &&   !newStock.equalsIgnoreCase("book")  ) 
                {
                    System.out.println("Error!! , the product must be music or book");
                    System.out.println("Enter the new stock that has arrived  (music/book");
                    newStock = scan.nextLine();
                }
            }while (!newStock.equalsIgnoreCase("music")  &&   !newStock.equalsIgnoreCase("book")  ) ;

            if ( newStock.equalsIgnoreCase ("music") )
            {

                System.out.println("Enter the name of the music");
                name = scan.nextLine();

                System.out.println("Enter the price of the music");
                price = scan.nextDouble();
                scan.nextLine();

                do{
                    System.out.println("Enter the quantity of the music");
                    quantity = scan.nextInt();
                    scan.nextLine();
                    if (quantity <= 0 )
                    {
                        System.out.println("Error! , you must have at least 1 quantity to update stock list.");
                    }

                }while (quantity <= 0 );

                System.out.println("enter type of the music   (CD/VINYL)");
                type = scan.nextLine();

                System.out.println("enter the Artist");
                artist = scan.nextLine();

                System.out.println("enter the year it was released");
                year = scan.nextInt();
                scan.nextLine();

                Music m = null;
                for (GoldenDiscs music: products)  /** iterator **/
                {
                    if (music instanceof Music) {

                        m = (Music) music; 
                        if (music.getName().equalsIgnoreCase(name) && music.getPrice() == price && 
                        music.getQuantity() == quantity && m.getType().equalsIgnoreCase(type)
                        && m.getArtist().equalsIgnoreCase(artist) && m.getYear() == year) 
                        {
                            System.out.println("How many items have been delivered");
                            stockAmount = scan.nextInt();
                            scan.nextLine(); // clear scanner
                            quantity = quantity + stockAmount;
                            System.out.println("The stock has been delivered!");
                            System.out.println("the new stock is" + "\n" + quantity);
                        }

                        else
                        {
                            System.out.println("Error! , we dont sell this item");
                            System.out.println("We cannot accept this delivery.");
                        }
                    }
                }
            }

            if (newStock.equalsIgnoreCase("book") )
            {

                System.out.println("Enter the name of the book");
                name = scan.nextLine();

                System.out.println("Enter the price of the book");
                price = scan.nextDouble();
                scan.nextLine();

                do{
                    System.out.println("Enter the quantity of the book");
                    quantity = scan.nextInt();
                    scan.nextLine();
                    if (quantity <= 0 )
                    {
                        System.out.println("Error! , you must have at least 1 quantity to update stock list.");
                    }

                }while (quantity <= 0 );
                System.out.println("Enter the author of the book");
                author = scan.nextLine();

                System.out.println("Enter the Genre of the book");
                genre = scan.nextLine();

                System.out.println("Enter the amount pages in the book");
                pages = scan.nextInt();

                Books b =null;
                for (GoldenDiscs books: products)  /** iterator **/
                {
                    if (books instanceof Books) 
                    {
                        b = (Books) books;

                        if (books.getName().equalsIgnoreCase(name) && books.getPrice() == price && 
                        books.getQuantity() == quantity && b.getAuthor().equalsIgnoreCase(author)
                        && b.getGenre().equalsIgnoreCase(genre) /**&& b.getPages() == pages **/ )
                        {
                            System.out.println("How many items have been delivered");
                            stockAmount = scan.nextInt();
                            scan.nextLine(); // clear scanner
                            quantity = quantity + stockAmount;
                            System.out.println("the new stock is" + "\n" + quantity);

                        }
                        else
                        {
                            System.out.println("Error! , we dont sell this item");
                            System.out.println("We cannot accept this delivery.");
                        }
                    }
                }

            }
        }

        else
        {
            System.out.println("The stock will not be delivered!");
        }

        delayClear();
    }

    public void delayClear()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\npress enter to continue");
        scan.nextLine();
        System.out.print("\f");

    }

    public static void main(String[] args)
    {
        new Driver();
    }

}
