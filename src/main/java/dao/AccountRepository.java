package dao;

import domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private Connection connection;

    private String createTableSql = "CREATE TABLE account("
            + "userId bigint GENERATED BY DEFAULT AS IDENTITY,"
            + "userName VARCHAR(10),"
            + "userPassword VARCHAR(10),"
            + "userEmail VARCHAR(20)"
            + ")";

    private Statement createTable;


    private String insertSql = "INSERT INTO account(userName,userPassword,userEmail) VALUES(?,?,?)";
    private String deleteSql = "DELETE FROM account WHERE userId = ?";
    private String updateSql = "UPDATE account set userName=?, userPassword=?, userEmail=? WHERE userId=?";
    private String selectByIdSql = "SELECT * FROM account WHERE userId=?";
    private String selectAllSql = "SELECT * FROM account";

    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement selectById;
    private PreparedStatement selectAll;

    public AccountRepository(Connection connection) {
        this.connection = connection;

        try {
            createTable = connection.createStatement();

            boolean tableExists = false;
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            while(rs.next()){
                if(rs.getString("TABLE_NAME").equalsIgnoreCase("account")){
                    tableExists=true;
                    break;
                }
            }
            if(!tableExists)
                createTable.executeUpdate(createTableSql);
            insert = connection.prepareStatement(insertSql);
            delete = connection.prepareStatement(deleteSql);
            update = connection.prepareStatement(updateSql);
            selectById = connection.prepareStatement(selectByIdSql);
            selectAll = connection.prepareStatement(selectAllSql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account get(int userId){
        try{

            selectById.setInt(1, userId);
            ResultSet rs = selectById.executeQuery();
            while(rs.next()){
                Account result = new Account();
                result.setUserId(userId);
                result.setUserName(rs.getString("userName"));
                result.setUserPassword(rs.getString("userPassword"));
                result.setUserEmail(rs.getString("userEmail"));
                return result;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<Account> getAll(){
        try{
            List<Account> result = new ArrayList<Account>();
            ResultSet rs = selectAll.executeQuery();
            while(rs.next()){
                Account p = new Account();
                p.setUserId(rs.getInt("userId"));
                p.setUserName(rs.getString("userName"));
                p.setUserPassword(rs.getString("userPassword"));
                p.setUserEmail(rs.getString("userEmail"));
                result.add(p);
            }
            return result;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(Account a){
        try{
            delete.setInt(1, a.getUserId());
            delete.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void add(Account a){
        try{

            insert.setString(1, a.getUserName());
            insert.setString(2, a.getUserPassword());
            insert.setString(3, a.getUserEmail());
            insert.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void update(Account a){
        try{

            update.setString(1, a.getUserName());
            update.setString(2, a.getUserPassword());
            update.setString(3, a.getUserEmail());
            update.setInt(4, a.getUserId());
            update.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }




}
