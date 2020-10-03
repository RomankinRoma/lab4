package Book;

public class Childrens implements Book {
    private String title;
    private double price;
    private BookGenre genre;
    private String author;

    public Childrens(String title, double price, BookGenre genre, String author) {
        this.title = title;
        this.price = price;
        this.genre = genre;
        this.author = author;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public BookGenre getGenre() {
        return this.genre;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String showInfo(){
        return " Title:"+getTitle()+" Genre:"+getGenre()+" Price:"+price+" Author:"+getAuthor();
    }
}
