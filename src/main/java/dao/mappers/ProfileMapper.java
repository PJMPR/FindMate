package dao.mappers;

import domain.model.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mela on 2016-12-05.
 */
public class ProfileMapper implements IMapResultIntoEntity<Profile> {

    public Profile map(ResultSet rs) throws SQLException{
        Profile p = new Profile();
        p.setId(rs.getInt("id"));
        p.setAge(rs.getInt("age"));
        p.setFirstName(rs.getString("firstName"));
        p.setLastName(rs.getString("lastName"));
        p.setCity(rs.getString("city"));
        p.setCountry(rs.getString("country"));
        return p;
    }
}


