package ua.ievleva.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ievleva.dao.parser.UserResultSetParser;
import ua.ievleva.entity.User;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private DataSource dataSource;

    public List<User> findAllUsers() {
        LOGGER.info("DAO: Selecting users has started");

        List<User> users = null;

        try (Connection connection = dataSource.getConnection()){

            LOGGER.info("DAO: prepareCall selectUsers PC");
            CallableStatement userCallableStatement = connection.prepareCall("{call selectUsers}");
            ResultSet resultSet = userCallableStatement.executeQuery();

            users = UserResultSetParser.parseUsers(resultSet);
            LOGGER.info("DAO: Selecting is finished");

        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        }

        return users;
    }

    public List<User> findByLogin(String login) {
        LOGGER.info("DAO: Finding user(s) by login" + login);

        List<User> users = null;

        try (Connection connection = dataSource.getConnection()){
            LOGGER.info("DAO: prepareCall findByLogin PC");
            CallableStatement userCallableStatement = connection.prepareCall("{call findByLogin(?)}");
            userCallableStatement.setString("login", login);

            ResultSet resultSet = userCallableStatement.executeQuery();

            users = UserResultSetParser.parseUsers(resultSet);
            LOGGER.info("DAO: Searching is finished");

        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        }

        return users;
    }

    public List<User> findByPhone(String phone) {
        LOGGER.info("DAO: Finding user(s) by phone" + phone);

        List<User> users = null;

        try (Connection connection = dataSource.getConnection()){
            LOGGER.info("DAO: prepareCall findByPhone PC");
            CallableStatement userCallableStatement = connection.prepareCall("{call findByPhone(?)}");
            userCallableStatement.setString("phone", phone);
            ResultSet resultSet = userCallableStatement.executeQuery();

            users = UserResultSetParser.parseUsers(resultSet);
            LOGGER.info("DAO: Searching is finished");

        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        }

        return users;
    }

    public void add(List<String> userData) {
        LOGGER.info("DAO: Adding user pc has been started");

        try (Connection connection = dataSource.getConnection()){
            LOGGER.info("DAO: prepareCall addUser PC");
            CallableStatement userCallableStatement = connection.prepareCall("{call addUser(?,?,?,?,?,?,?,?)}");
            userCallableStatement.setString(1, userData.get(0));
            userCallableStatement.setString(2, userData.get(1));
            userCallableStatement.setString(3, userData.get(2));
            userCallableStatement.setString(4, userData.get(3));
            userCallableStatement.setString(5, userData.get(4));
            userCallableStatement.setString(6, userData.get(5));
            userCallableStatement.setString(7, userData.get(6));
            userCallableStatement.setString(8, userData.get(7));

            userCallableStatement.executeUpdate();
            LOGGER.info("DAO: User is added");


        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        }

    }

    public void delete(String login) {
        LOGGER.info("DAO: Deleting pc has been started");

        try (Connection connection = dataSource.getConnection()){
            LOGGER.info("DAO: prepareCall deleteUser PC");
            CallableStatement userCallableStatement = connection.prepareCall("{call deleteUser(?)}");
            userCallableStatement.setString(1, login);
            userCallableStatement.executeUpdate();

            LOGGER.info("DAO: User is deleted");

        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        }

    }

    public void edit(List<String> userData) {
        LOGGER.info("DAO: Editing pc has been started");

        try (Connection connection = dataSource.getConnection()){
            LOGGER.info("DAO: prepareCall editUser PC");
            CallableStatement userCallableStatement = connection.prepareCall("{call editUser(?,?,?,?,?,?,?,?)}");
            userCallableStatement.setString(1, userData.get(0));
            userCallableStatement.setString(2, userData.get(1));
            userCallableStatement.setString(3, userData.get(2));
            userCallableStatement.setString(4, userData.get(3));
            userCallableStatement.setString(5, userData.get(4));
            userCallableStatement.setString(6, userData.get(5));
            userCallableStatement.setString(7, userData.get(6));
            userCallableStatement.setString(8, userData.get(7));

            userCallableStatement.executeUpdate();

            LOGGER.info("DAO: User is edited");

        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        }

    }

}
