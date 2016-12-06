package dao;

import domain.model.Profile;

import java.util.List;

/**
 * Created by Mela on 2016-12-06.
 */
public interface IProfileRepository extends IRepository<Profile> {
    public List<Profile> withCity(String city);
}
