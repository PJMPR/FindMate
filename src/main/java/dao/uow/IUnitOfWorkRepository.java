package dao.uow;

/**
 * Created by Mela on 2016-12-06.
 */
public interface IUnitOfWorkRepository {
    public void persistAdd(Entity entity);
    public void persistDelete(Entity entity);
    public void persistUpdate(Entity entity);
}
