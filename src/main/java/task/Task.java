package task;

public class Task {

    public int taskId;
    final String taskName;
    String taskDescription;
    String taskDeadline;
    Boolean taskStatus;

    public Task(int taskId, String taskName, String taskDescription, String taskDeadline, boolean taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDeadline = taskDeadline;
        this.taskStatus = taskStatus;
    }

    public Task(String taskName, String taskDescription, String taskDeadline) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDeadline = taskDeadline;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(String taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public boolean isTaskStatus(){
        return statusMessage();
    }

    boolean statusMessage() {
        System.out.println(taskStatus ? "Completed" : "Pending");
        return statusMessage();
    }

    public Boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId +
                " | Name: " + taskName +
                " | Description: " + taskDescription +
                " | Deadline: " + taskDeadline +
                " | Status: " + taskStatus + " |";
    }
}
