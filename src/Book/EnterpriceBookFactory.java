package Book;

public class EnterpriceBookFactory implements BookAF {
    private String title;
    private double price;
    private BookGenre genre;
    private String author;

    public EnterpriceBookFactory(String title, double price, BookGenre genre, String author) {
        this.title = title;
        this.price = price;
        this.genre = genre;
        this.author = author;
    }

    @Override
    public Book createBook(BookGenre genre) {
        Book book=null;
        switch (genre){
            case COMEDY:
                book=new Enterprice(title,price,BookGenre.COMEDY,author);
                return book;
            case HORROR:
                book=new Enterprice(title,price,BookGenre.HORROR,author);
                return book;
            case STUDY:
                book=new Enterprice(title,price,BookGenre.HORROR,author);
                return book;
            }
        return book;
    }
}
