package ibf2022.paf.assessment.server.controllers;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8
@Controller
@RequestMapping
public class TasksController {

    @Autowired
    private TodoService todoSvc;

    @PostMapping(path="/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                                produces = "text/plain")
    
    public ModelAndView postTask(@RequestParam String username, 
                @RequestParam MultiValueMap<String, String> form) {
        
        ModelAndView mav = new ModelAndView();

        List<Task> tasks = new LinkedList<Task>();
        Integer i = 0;
        while (form.getFirst("description-" + i) != null){
            Task task = new Task();
            task.setDescription(form.getFirst("description-" + i));
            task.setPriority(form.getFirst("priority-" + i));
            task.setDueDate(Date.valueOf(form.getFirst("dueDate-" + i)));
            tasks.add(task);
            i++;
            Boolean added = todoSvc.upsertTask(form.getFirst("username"), task);
            if (added) {
                mav.setViewName("result");
                mav.setStatus(HttpStatusCode.valueOf(200));
                return mav;
            }
        }
        mav.setViewName("error");
        mav.setStatus(HttpStatusCode.valueOf(500));
        return mav;
       }
}
