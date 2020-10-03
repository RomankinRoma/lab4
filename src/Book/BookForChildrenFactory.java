package Book;

public class BookForChildrenFactory implements BookAF {
    private String title;
    private double price;
    private BookGenre genre;
    private String author;

    public BookForChildrenFactory(String title, double price, BookGenre genre, String author) {
        this.title = title;
        this.price = price;
        this.genre = genre;
        this.author = author;
    }

    @Override
    public Book createBook( BookGenre genre) {
        Book book=null;
        switch (genre){
            case STUDY:
                book=new Childrens(title,price,BookGenre.STUDY,author);
                return book;
            case COMEDY:
                book=new Childrens(title,price,BookGenre.COMEDY,author);
                return book;
            case HORROR:
                book=new Childrens(title,price,BookGenre.HORROR,author);
                return book;
        }
        return book;
    }
}
