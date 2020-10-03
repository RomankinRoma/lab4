package Book;

public interface Book {
    public String getTitle();
    public double getPrice();
    public BookGenre getGenre();
    public String getAuthor();

    String showInfo();
}
