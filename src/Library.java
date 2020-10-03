import Book.Book;
import Book.EnterpriceBookFactory;
import Book.BookGenre;
import Book.BookFactory;
import Book.BookForChildrenFactory;
import User.User;
import User.UserFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    Scanner in=new Scanner(System.in);
    BookFactory bookFactory= new BookFactory();
    UserFactory userFactory= new UserFactory();
    List<User> users;
    List<Book> allBooks;
    User user = null;

    public Library(List<User> users, List<Book> allBooks) {
        this.users = users;
        this.allBooks = allBooks;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public void addBook() {
        Book book = null;
        System.out.print("Input title:");
        String title = in.next();
        System.out.println("Input price:");
        Double price = in.nextDouble();
        System.out.println("Choose genre:");
        System.out.println("1." + BookGenre.COMEDY);
        System.out.println("2." + BookGenre.HORROR);
        System.out.println("3." + BookGenre.STUDY);
        Integer chose = in.nextInt();
        BookGenre genre = null;
        if (chose == 1) {
            genre = BookGenre.COMEDY;
        }
        if (chose == 2) {
            genre = BookGenre.HORROR;
        }
        if (chose == 3) {
            genre = BookGenre.STUDY;
        }
        System.out.print("Input author:");
        String author = in.next();
        System.out.println("Choose type:");
        System.out.println("1.For children's");
        System.out.println("2.Enterprise");
        chose = in.nextInt();
        if (chose == 1) {
            book = bookFactory.createBook(new BookForChildrenFactory(title, price, genre, author), genre);
            book.showInfo();
        }
        if (chose == 2) {
            book = bookFactory.createBook(new EnterpriceBookFactory(title, price, genre, author), genre);
        }
        allBooks.add(book);
        System.out.println("Book added to database");
    }
    public void addBookToUser() {
        System.out.println("Input users ID:");
        Integer id = in.nextInt();
        System.out.print("Input books title:");
        String title = in.next();
        user = findById(users, id);
        user.borrow(findBookByTitle(allBooks, title));
        System.out.println("Book added to user");
    }
    public void deleteBook() {
        System.out.print("Input title:");
        String title = in.next();
        if (allBooks.contains(findBookByTitle(allBooks, title))){
            allBooks.remove(findBookByTitle(allBooks, title));
            deleteFromAll(title);
            System.out.println("Book deleted");}
        else {
            System.out.println("Cant find book.");
        }
    }
    public void deleteBookFromUser() {
        System.out.println("Input users ID:");
        Integer id = in.nextInt();
        System.out.print("Input books title:");
        String title = in.next();
        user = findById(users, id);
        user.deleteBook(findBookByTitle(allBooks, title));
    }
    public void createUser() {
        System.out.println("Input ID:");
        Integer id = in.nextInt();
        System.out.print("Input username:");
        String username = in.next();
        System.out.println("Choose user type:");
        System.out.println("1.Pupil");
        System.out.println("2.Student");
        Integer chose = in.nextInt();
        if (chose == 1) {
            user = userFactory.createPupil(id, username);
            users.add(user);
        }
        if (chose == 2) {
            System.out.println("Membership true or false:");
            Boolean membership = in.nextBoolean();
            user = userFactory.createStudent(id, username, membership);
            users.add(user);
        }
    }
    public void allBooks() {
        for (Book bk : allBooks) {
            System.out.println(bk.showInfo());
        }
    }
    public void allUsers() {
        for (User usr : users) {
            System.out.println(usr.showInfo());
        }
    }
    public void userBooks() {
        System.out.println("Input users ID:");
        Integer id = in.nextInt();
        user = findById(users, id);
        System.out.println(user.getBorrowedBooks());
    }

    public User findById(List<User> users,Integer id){
        for (User usr:users){
            if (usr.getId()==id)
                return usr;
        }
        return null;
    }
    public Book findBookByTitle(List<Book> books,String title){
        for (Book book: books){
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }
    public void deleteFromAll(String title){
        for (User user:users){
            user.deleteBook(findBookByTitle(user.allBooks(),title));
        }
    }

}

