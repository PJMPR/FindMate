package dao.uow;

import java.sql.SQLException;

/**
 * Created by Mela on 2016-12-06.
 */
public interface IUnitOfWork {
        public void commit() throws SQLException;
        public void undo() throws SQLException;
        public void markAsNew(Entity entity, IUnitOfWorkRepository repository);
        public void markAsDeleted(Entity entity, IUnitOfWorkRepository repository);
        public void markAsChanged(Entity entity, IUnitOfWorkRepository repository);
}
