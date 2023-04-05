package ibf2022.paf.assessment.server.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.Utils;
import ibf2022.paf.assessment.server.models.User;

// TODO: Task 3
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_USERNAME_SQL 
        = "select * from user where username = ?";

    private static final String INSERT_NEW_USER_SQL
        = "insert into user (user_id, username, name) values (?, ?, ?)";

    public Optional<User> findUserByUsername(String username) {

        SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_USER_BY_USERNAME_SQL, username);
        if (!rs.next()) {
            return Optional.empty();
        } else {
            return Optional.of(Utils.toUser(rs));
        }
    }
    
    public String insertUser(User user) {

        Integer result = 0;

        if (result == 0){
            // Generate UUID String of 8 characters length
            String userId = UUID.randomUUID()
            .toString().substring(0, 8);

            result = jdbcTemplate.update(INSERT_NEW_USER_SQL, 
                        userId, user.getUsername(), user.getName());

            return userId;
        } else {
            return "Error inserting user";
        }
    }
}
