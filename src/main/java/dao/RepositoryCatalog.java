package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.mappers.AccountMapper;
import dao.mappers.LikeMapper;
import dao.mappers.ProfileMapper;
import dao.uow.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog{

    IUnitOfWork uow;
    Connection connection;


    public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
        super();
        this.uow = uow;
        this.connection = connection;
    }


    public IProfileRepository profiles() {
        return new ProfileRepository(connection, new ProfileMapper(), uow);
    }

    public IAccountRepository users() {
        return new AccountRepository(connection, new AccountMapper(), uow);
    }

    public ILikeRepository likes() {
        return new LikeRepository(connection, new LikeMapper(), uow);
    }


    public void saveAndClose() {
        try{
            uow.commit();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

}
