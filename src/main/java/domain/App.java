package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.AccountRepository;
import dao.ProfileRepository;
import domain.model.Account;


public class App
{
    public static void main( String[] args )
    {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        try {
            Connection connection = DriverManager.getConnection(url);
            ProfileRepository profileRepo = new ProfileRepository(connection);
            AccountRepository accountRepo = new AccountRepository(connection);

            Account user1 = new Account();
            user1.setUserName("Amelia");
            user1.setUserPassword("Asmus");
            user1.setUserEmail("s13929@pjwstk.edu.pl");

            System.out.println( "Dodanie użytkownika" );
            accountRepo.add(user1);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}