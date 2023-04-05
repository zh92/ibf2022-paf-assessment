package ibf2022.paf.assessment.server.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 4, Task 8
@Controller
@RequestMapping
public class TasksController {

    // @PostMapping(path="/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
    //                             produces = MediaType.APPLICATION_JSON_VALUE)
    // @ResponseBody
	// public ResponseEntity<String> postTransfer(@RequestBody String payload) {

	// 	System.out.printf(">>> payload: %s\n", payload);
    //     return ResponseEntity.ok(resp.toString());
    // }

    @PostMapping("/task")
    public String saveTask(@ModelAttribute("taskForm") Task taskForm, BindingResult result) {
        
        if (result.hasErrors()) {
            return "error";
        }

        Task newTask = new Task();
        
        newTask.setDescription(taskForm.getDescription());
        newTask.setPriority(taskForm.getPriority());
        newTask.setDueDate(taskForm.getDueDate());
        newTask.setUserId(taskForm.getUserId());
        
        empSvc.save(newEmployee);

    //     return "redirect:/employees";
    // }
}
