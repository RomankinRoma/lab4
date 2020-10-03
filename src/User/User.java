package User;

import Book.Book;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer id;
    private String username;
    private List<Book> borrowedBooks=new ArrayList<>();
    private Boolean membership;

    public User(UserBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.membership = builder.membership;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBorrowedBooks() {
        String bookinfo = "";
        for(Book book: this.borrowedBooks){
            bookinfo=bookinfo+"\n"+book.showInfo();
        }
        if (bookinfo.isEmpty()){
            return "Nothing";
        }
        return bookinfo;
    }
    public List<Book> allBooks(){
        return borrowedBooks;
    }
    public Boolean getMembership() {
        return membership;
    }

    public void setMembership(Boolean membership) {
        this.membership = membership;
    }

    public void borrow(Book book){
        borrowedBooks.add(book);
    }

    public void deleteBook(Book book){borrowedBooks.remove(book);}
    public String showInfo() {
        if (membership!=null)
            return "ID:"+getId()+"  Username:"+getUsername()+"  Membership:"+getMembership()+"  Books:"+getBorrowedBooks();
        return "ID:"+getId()+"  Username:"+getUsername()+"  Books:"+getBorrowedBooks();

    }

    public static class UserBuilder {
        private Integer id;
        private String username;

        private Boolean membership;

        public UserBuilder(Integer id, String username) {
            this.id = id;
            this.username = username;
        }

        public UserBuilder withMembership(Boolean membership){
            this.membership=membership;
            return this;
        }

        public User createUser(){
            return new User(this);
        }

    }
}
