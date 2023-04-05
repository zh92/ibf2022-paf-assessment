package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 6
@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_TASK_SQL = """
        insert into task (description, priority, due_date, user_id) 
        values ('?', '?', '?'', '?');
            """;
    
    public Boolean insertTask(Task task) {

        Integer result = 0;
        result = jdbcTemplate.update(INSERT_TASK_SQL, 
            task.getDescription(), task.getPriority(), task.getDueDate(), task.getUserId());

        return result > 0 ? true : false;
    }

}
