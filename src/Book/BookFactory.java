package Book;

public class BookFactory {
    public static Book createBook(BookAF bookAF,BookGenre bookGenre){
        return bookAF.createBook(bookGenre);
    }
}
