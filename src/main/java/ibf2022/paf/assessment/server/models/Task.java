package ibf2022.paf.assessment.server.models;

import java.sql.Date;

// TODO: Task 4

public class Task {

    private Integer taskId;
    private String description;
    private String priority;
    private Date dueDate;
    private String userId;
    
    public Task() {
    }
    
    public Task(Integer taskId, String description, String priority, Date dueDate, String userId) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
