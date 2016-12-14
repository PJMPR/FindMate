package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dao.*;
import dao.uow.UnitOfWork;
import domain.model.Account;
import domain.model.Like;
import domain.model.Profile;

public class App
{
    public static void main( String[] args )
    {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        try {
            Connection connection = DriverManager.getConnection(url);
            IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);

            ///////////////////////////////////////////////////

            Profile profile = new Profile();
            profile.setFirstName("Jan");
            profile.setLastName("Kowalski");
            profile.setAge(23);
            profile.setCity("Warszawa");
            profile.setCountry("Polska");

            System.out.println( "Profile added!" );
            catalog.profiles().add(profile);

            Profile profile2 = new Profile();
            profile2.setFirstName("Amelia");
            profile2.setLastName("Asmus");
            profile2.setAge(20);
            profile2.setCity("Puck");
            profile2.setCountry("Polska");

            System.out.println( "Profile added!" );
            catalog.profiles().add(profile2);

            Profile profile3 = new Profile();
            profile3.setFirstName("John");
            profile3.setLastName("Smith");
            profile3.setAge(38);
            profile3.setCity("New York");
            profile3.setCountry("USA");

            System.out.println( "Profile added!" );
            catalog.profiles().add(profile3);

            catalog.save();

        ////////////////////////////////////////////////////////

            Account user= new Account();
            user.setUserName("SuperJanek");
            user.setUserPassword("qwerty");
            user.setUserEmail("janus@gmail.com");
            user.setProfileId(catalog.profiles().get(0).getId());

            System.out.println( "User added!" );
            catalog.users().add(user);

            catalog.save();

        //////////////////////////////////////////////////////////

            Like like = new Like();
            like.setLikeFrom(catalog.profiles().get(0).getId());
            like.setLikeTo(catalog.profiles().get(2).getId());

            System.out.println( "Like added!" );
            catalog.likes().add(like);

            catalog.saveAndClose();

        /////////////////////////////////////////////////////////////


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println( "Koniec" );

    }
}
