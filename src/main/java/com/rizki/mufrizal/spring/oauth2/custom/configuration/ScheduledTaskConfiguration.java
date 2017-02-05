package com.rizki.mufrizal.spring.oauth2.custom.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 9:54:17 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.configuration
 *
 */
@EnableScheduling
@Component
public class ScheduledTaskConfiguration {

    @Autowired
    private DataSource dataSource;

    private Connection connection;

    private PreparedStatement preparedStatementSelectUser;
    private PreparedStatement preparedStatementSelectUserRole;
    private PreparedStatement preparedStatementSelectOAuthClientDetails;

    private PreparedStatement preparedStatementInsertUser;
    private PreparedStatement preparedStatementInsertUserRole;
    private PreparedStatement preparedStatementInsertOAuthClientDetails;

    private final String selectTableUserSQL = "SELECT * FROM tb_user WHERE username = ?";
    private final String selectTableUserRoleSQL = "SELECT * FROM tb_user_role WHERE username = ?";
    private final String selectTableOAuthClientDetailSQL = "SELECT * FROM oauth_client_details WHERE client_id = ?";

    private final String insertTableUserSQL = "INSERT INTO tb_user(username, password, is_active) values(?, ?, ?)";
    private final String insertTableUserRoleSQL = "INSERT INTO tb_user_role(user_role_id, role, username) values(?, ?, ?)";
    private final String insertTableOAuthClientDetailsSQL = "INSERT INTO oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Scheduled(fixedRate = 3600000)
    public void insertDefaultUserAdministrator() throws SQLException {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        connection = dataSource.getConnection();

        preparedStatementSelectUser = connection.prepareStatement(selectTableUserSQL);
        preparedStatementSelectUser.setString(1, "admin");
        ResultSet resultSetUser = preparedStatementSelectUser.executeQuery();

        preparedStatementSelectUserRole = connection.prepareStatement(selectTableUserRoleSQL);
        preparedStatementSelectUserRole.setString(1, "admin");
        ResultSet resultSetUserRole = preparedStatementSelectUserRole.executeQuery();

        preparedStatementSelectOAuthClientDetails = connection.prepareStatement(selectTableOAuthClientDetailSQL);
        preparedStatementSelectOAuthClientDetails.setString(1, "clientid");
        ResultSet resultOAuthClientDetails = preparedStatementSelectOAuthClientDetails.executeQuery();

        if (!resultOAuthClientDetails.next()) {
            preparedStatementInsertOAuthClientDetails = connection.prepareStatement(insertTableOAuthClientDetailsSQL);
            preparedStatementInsertOAuthClientDetails.setString(1, "clientid");
            preparedStatementInsertOAuthClientDetails.setString(2, "customoauth2");
            preparedStatementInsertOAuthClientDetails.setString(3, "secret");
            preparedStatementInsertOAuthClientDetails.setString(4, "read,write");
            preparedStatementInsertOAuthClientDetails.setString(5, "password,client_credentials,refresh_token");
            preparedStatementInsertOAuthClientDetails.setString(6, " ");
            preparedStatementInsertOAuthClientDetails.setString(7, " ");
            preparedStatementInsertOAuthClientDetails.setInt(8, 3600);
            preparedStatementInsertOAuthClientDetails.setInt(9, 3600);
            preparedStatementInsertOAuthClientDetails.setString(10, " ");
            preparedStatementInsertOAuthClientDetails.setBoolean(11, Boolean.TRUE);
            preparedStatementInsertOAuthClientDetails.executeUpdate();
            
            preparedStatementInsertOAuthClientDetails.close();
        }

        if (!resultSetUser.next() && !resultSetUserRole.next()) {
            preparedStatementInsertUser = connection.prepareStatement(insertTableUserSQL);
            preparedStatementInsertUser.setString(1, "admin");
            preparedStatementInsertUser.setString(2, bCryptPasswordEncoder.encode("admin"));
            preparedStatementInsertUser.setBoolean(3, Boolean.TRUE);
            preparedStatementInsertUser.executeUpdate();

            preparedStatementInsertUserRole = connection.prepareStatement(insertTableUserRoleSQL);
            preparedStatementInsertUserRole.setString(1, UUID.randomUUID().toString());
            preparedStatementInsertUserRole.setString(2, "ROLE_ADMIN");
            preparedStatementInsertUserRole.setString(3, "admin");
            preparedStatementInsertUserRole.executeUpdate();

            preparedStatementInsertUser.close();
            preparedStatementInsertUserRole.close();
        }

        preparedStatementSelectUser.close();
        preparedStatementSelectUserRole.close();
        connection.close();

    }

}
