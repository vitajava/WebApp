package ua.ievleva.dao.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.ievleva.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultSetParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResultSetParser.class);

    public static User parseUser(ResultSet resultSet) {
        User user = new User();

        try {
            user.setLogin(resultSet.getString("login"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setPhone(resultSet.getString("phone"));
            user.setEmail(resultSet.getString("email"));

        } catch (SQLException e) {
            LOGGER.error("SQL exception", e);
        }

        return user;
    }

    public static List<User> parseUsers(ResultSet resultSet) {

        List<User> list = new ArrayList<>();

        if (resultSet != null) {
            LOGGER.info("Parsing users started");
            try {
                while (resultSet.next()) {
                    list.add(parseUser(resultSet));
                }
            } catch (SQLException e) {
                LOGGER.error("SQL exception", e);
            }
            LOGGER.info("Parsing users is finished");
        }

        return list;
    }
}
