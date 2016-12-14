package dao;

import domain.model.Profile;
import domain.model.Like;

import java.util.List;

/**
 * Created by Mela on 2016-12-06.
 */
public interface ILikeRepository extends IRepository<Like> {
    public List<Like> byProfile(Integer likeTo);
}
