package dao;

import domain.model.Account;
import dao.mappers.IMapResultIntoEntity;

import java.sql.Connection;
import java.sql.SQLException;


public class AccountRepository extends RepositoryBase<Account>{

    public AccountRepository(Connection connection, IMapResultIntoEntity<Account> mapper){
        super(connection, mapper);
    }

    protected String tableName(){
        return "account";
    }

    protected String createTableSql() {
        return "CREATE TABLE account("
            + "userId bigint GENERATED BY DEFAULT AS IDENTITY,"
            + "userName VARCHAR(10),"
            + "userPassword VARCHAR(10),"
            + "userEmail VARCHAR(20),"
            + "profileId INT,"
            + ")";}

    protected String insertSql() {
        return "INSERT INTO account(userName,userPassword,userEmail,profileId) VALUES(?,?,?,?)";}

    protected String deleteSql() {
        return "DELETE FROM account WHERE userId = ?";}

    protected String updateSql()  {
        return "UPDATE account set userName=?, userPassword=?, userEmail=?, profileId=? WHERE userId=?";}

    protected String selectByIdSql()  {
        return "SELECT * FROM account WHERE userId=?";}

    protected String selectAllSql()  {
        return "SELECT * FROM account";}

    protected void setupInsert(Account entity) throws SQLException{
        insert.setString(1, entity.getUserName());
        insert.setString(2, entity.getUserPassword());
        insert.setString(3, entity.getUserEmail());
        insert.setInt(4, entity.getProfileId());
    }

    protected void setupUpdate(Account entity) throws SQLException{
        update.setString(1, entity.getUserName());
        update.setString(2, entity.getUserPassword());
        update.setString(3, entity.getUserEmail());
        update.setInt(4, entity.getProfileId());
    }


}
