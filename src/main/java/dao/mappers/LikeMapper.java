package dao.mappers;

import domain.model.Like;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mela on 2016-12-05.
 */
public class LikeMapper implements IMapResultIntoEntity<Like> {

    public Like map(ResultSet rs) throws SQLException{
        Like result = new Like();
        result.setId(rs.getInt("id"));
        result.setSendDate(rs.getDate("sendDate"));
        result.setLikeFrom(rs.getInt("likeFrom"));
        result.setLikeTo(rs.getInt("likeTo"));
        return result;
    }
}
