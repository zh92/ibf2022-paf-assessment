package ibf2022.paf.assessment.server;

import java.io.Reader;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;

public class Utils {
    
    // Converting SqlRowSet to User object
    public static User toUser(SqlRowSet rs) {
		User user = new User();
        user.setUserId(rs.getString("user_id"));
		user.setUsername(rs.getString("username"));
		user.setName(rs.getString("name"));
		return user;
	}

    // public static Task toTask(String payload) {
	// 	Task task = new Task();

		// Reader reader = reader.createReader(new StringReader(jsonStr));
		// JsonObject json = reader.readObject();
		// transfer.setFromAccount(json.getString("srcAcct"));
		// transfer.setToAccount(json.getString("destAcct"));
		// transfer.setAmount((float)json.getJsonNumber("amount").doubleValue());
		// return transfer;
	}
}
