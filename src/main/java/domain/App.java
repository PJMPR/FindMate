package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.AccountRepository;
import dao.ProfileRepository;
import dao.LikeRepository;
import dao.mappers.AccountMapper;
import dao.mappers.LikeMapper;
import dao.mappers.IMapResultIntoEntity;
import dao.mappers.ProfileMapper;
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
            IMapResultIntoEntity<Profile> profileMapper = new ProfileMapper();
            IMapResultIntoEntity<Like> likeMapper = new LikeMapper();
            IMapResultIntoEntity<Account> accountMapper = new AccountMapper();

            ProfileRepository repo = new ProfileRepository(connection, profileMapper);
            LikeRepository repo1 = new LikeRepository(connection, likeMapper);
            AccountRepository repo2 = new AccountRepository(connection,accountMapper);

            Profile profile = new Profile();
            profile.setFirstName("Jan");
            profile.setLastName("Kowalski");
            profile.setAge(23);
            profile.setCity("Bydgoszcz");
            profile.setCountry("Polska");

            System.out.println( "Profile added!" );
            repo.add(profile);

            Account user= new Account();
            user.setUserName("SuperJanek");
            user.setUserPassword("qwerty");
            user.setUserEmail("janus@gmail.com");
            user.setProfileId(1);

            System.out.println( "User added!" );
            repo2.add(user);

            Like like = new Like();
            like.setLikeFrom(1);
            like.setLikeTo(2);

            System.out.println( "Like added!" );
            repo1.add(like);




        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println( "Koniec" );

    }
}
