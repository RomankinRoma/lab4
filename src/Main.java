import Book.Book;
import Book.BookGenre;
import Book.BookForChildrenFactory;
import Book.BookFactory;
import Book.Childrens;
import User.UserFactory;
import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BookFactory bookFactory=new BookFactory();
        List<User> users = new ArrayList<User>();
        List<Book> allBooks = new ArrayList<Book>();
        UserFactory userFactory= new UserFactory();
        Library library= new Library(users,allBooks);
        User student=userFactory.createStudent(6,"sadasd",true);
        User pupil=userFactory.createPupil(5,"sadasd");
        Book book = bookFactory.createBook(new BookForChildrenFactory("ada", 312, BookGenre.STUDY, "asdsdsa"), BookGenre.COMEDY);
        System.out.println(book.showInfo());
        student.borrow(book);
        Singleton singleton=Singleton.getInstance(library);

        library.getAllBooks().add(book);
        library.getUsers().add(student);
        library.getUsers().add(pupil);

        Integer chose=-1;

        while (chose!=0){
            System.out.println("1.Add book");
            System.out.println("2.Add book to user");
            System.out.println("3.Delete book");
            System.out.println("4.Delete book from user");
            System.out.println("5.Add user to database");
            System.out.println("6.Get all books");
            System.out.println("7.Get all users");
            System.out.println("8.Get books of users");
            System.out.println("0.Exit");
            chose = in.nextInt();

            switch (chose){
                case 1:
                    library.addBook();
                    break;
                case 2:
                    try {
                        library.addBookToUser();
                    }catch (Exception e){
                        System.out.println("Incorrect id or title!");;
                    }
                    break;
                case 3:
                    try {
                        library.deleteBook();
                    }catch (Exception e){
                        System.out.println("Incorrect title!");;
                    }
                    break;
                case 4:
                    try {
                        library.deleteBookFromUser();
                    }catch (Exception e){
                        System.out.println("Incorrect id or title!");;
                    }
                    break;
                case 5:
                    library.createUser();
                    break;
                case 6:
                    library.allBooks();
                    break;
                case 7:
                    library.allUsers();
                    break;
                case 8:
                    try {
                        library.userBooks();
                    }catch (Exception e){
                        System.out.println("Incorrect id!");;
                    }
                    break;
                case 0:
                    System.exit(-1);
                    break;
                default:
                    System.out.println("Incorrect chose!");
            }
        }
    }

}
