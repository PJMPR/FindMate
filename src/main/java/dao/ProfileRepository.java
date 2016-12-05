package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.mappers.IMapResultIntoEntity;
import domain.model.Profile;

public class ProfileRepository extends RepositoryBase<Profile>{

    public ProfileRepository(Connection connection, IMapResultIntoEntity<Profile> mapper){
        super(connection,mapper);
    }

    @Override
    protected String tableName() {
        return "profile";
    }

    protected String createTableSql() {
        return "CREATE TABLE profile("
            + "id BIGINT GENERATED BY DEFAULT AS IDENTITY,"
            + "age INT, "
            + "firstName VARCHAR(20), "
            + "lastName VARCHAR(20), "
            + "city VARCHAR(20), "
            + "country VARCHAR(20), "
            + ")";}

    protected String insertSql() {
        return "INSERT INTO profile(age,firstName,lastName,city,country) VALUES (?,?,?,?,?)";}

    protected String deleteSql() {
        return "DELETE FROM profile WHERE id=?";}

    protected String updateSql() {
        return "UPDATE profile SET age=?, firstName=?, lastName=?, city=?, country=? WHERE id=?";}

    protected String selectByIdSql() {
        return "SELECT * FROM profile WHERE id=?";}

    protected String selectAllSql() {
        return "SELECT * FROM profile";}


    protected void setupInsert(Profile entity) throws SQLException{
            insert.setInt(1, entity.getAge());
            insert.setString(2, entity.getFirstName());
            insert.setString(3, entity.getLastName());
            insert.setString(4, entity.getCity());
            insert.setString(5, entity.getCountry());
    }

    protected void setupUpdate(Profile entity) throws SQLException{
            update.setInt(1, entity.getAge());
            update.setString(2, entity.getFirstName());
            update.setString(3, entity.getLastName());
            update.setString(4, entity.getCity());
            update.setString(5, entity.getCountry());
            update.setInt(6, entity.getId());
    }

}
