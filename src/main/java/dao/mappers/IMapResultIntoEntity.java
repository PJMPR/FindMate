package dao.mappers;

import domain.model.IHaveId;

import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Created by Mela on 2016-12-05.
 */
public interface IMapResultIntoEntity <TEntity extends IHaveId> {

    public TEntity map(ResultSet rs) throws SQLException;
}
