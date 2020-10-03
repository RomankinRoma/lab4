package User;

import Book.Book;
import User.User;

import java.util.List;

public class UserFactory {

    private static UserFactory userFactory;

    public UserFactory(){
    }

    public static User createStudent(Integer id, String username, Boolean membership){

        User student = new User.UserBuilder(id,username).withMembership(membership).createUser() ;

        return student;
    }

    public static User createPupil(Integer id, String username){

        User pupil = new User.UserBuilder(id,username).createUser() ;

        return pupil;
    }
}
