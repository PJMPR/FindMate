package dao;

import domain.model.IHaveId;
import java.util.List;

/**
 * Created by Mela on 2016-12-05.
 */
public interface IRepository<TEntity extends IHaveId> {

    public TEntity get(int personId);
    public List<TEntity> getAll();
    public void add(TEntity entity);
    public void update(TEntity entity);
    public void delete(TEntity entity);

}
