package ibf2022.paf.assessment.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7
@Service
public class TodoService {

    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private UserRepository userRepo;

    @Transactional
    public void upsertTask(User user, Task task) {

        Boolean userExists = false;
        // Check if user exists
        userExists = userRepo.findUserByUsername(user.getUsername()).isPresent();
        // Create user if user does not exist
        if (!userExists) {
            userRepo.insertUser(user);
        }
        // Insert task
        taskRepo.insertTask(task);
    }

}
