package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IRepository;
import domain.model.Account;
import domain.model.Profile;

/**
 * Created by Mela on 2016-12-05.
 */
public class AccountMapper implements IMapResultIntoEntity<Account> {

    IRepository<Profile> profileRepo;

    public IRepository<Profile> getProfileRepo() {
        return profileRepo;
    }

    public void setProfileRepo(IRepository<Profile> profileRepo) {
        this.profileRepo = profileRepo;
    }

    public Account map(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setProfileId(rs.getInt("profileId"));
        account.setUserName(rs.getString("userName"));
        account.setUserPassword(rs.getString("userPassword"));
        account.setUserEmail(rs.getString("userEmail"));
        if(profileRepo!=null)
            account.setProfile(this.profileRepo.get(account.getProfileId()));

        return account;
    }

}
