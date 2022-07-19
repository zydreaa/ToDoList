package task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskController {
    protected JFrame frame;
    public ArrayList<Task> tasks = new ArrayList<>();

    public TaskController() {
        frame = new JFrame();
    }

    String[] taskName() {
        int totalTasks = tasks.size();
        String[] taskName = new String[totalTasks];
        for (int i = 0; i < totalTasks; i++) {
            taskName[i] = tasks.get(i).getTaskName();
        }
        return taskName;
    }

    public void existingTasks(){
        Task task1 = new Task(tasks.size(), "Bake", "Cake for birthday","Friday", false);
        tasks.add(task1);
        Task task2 = new Task(tasks.size(), "Clean", "Clean all flat windows","Weekend", false);
        tasks.add(task2);
        Task task3 = new Task(tasks.size(), "Exam", "Learn theory for exam","Monday", true);
        tasks.add(task3);
    }

    public void newTask(){
        try {
            int taskId = tasks.size();
            String taskName = JOptionPane.showInputDialog("Please enter task name");

            String taskDescription = (String) JOptionPane.showInputDialog("Please provide more details about task");

            String[] deadline = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Weekend"};
            String taskDeadline = (String) JOptionPane.showInputDialog(
                    frame,
                    "Choose deadline from task:",
                    "Task deadline:",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Arrays.stream(deadline).toArray(),
                    Arrays.stream(deadline).toArray()[0]
            );

            boolean taskStatus = JOptionPane.showConfirmDialog(
                    frame,
                    "Is this task is completed?") ==
                    JOptionPane.YES_NO_OPTION;

            Task task = new Task(taskId, taskName, taskDescription, taskDeadline, taskStatus);
            tasks.add(task);

            JOptionPane.showMessageDialog(frame, "Task successfully added!");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Problem occurred!");
            exception.printStackTrace();
        }
    }

    Task findTaskByName(String name){
        for (Task task : tasks){
            if (name.equals(task.getTaskName())){
                return task;
            }
        }
        return null;
    }

    public void removeTask(){
        try {
        String removeTask = (String) JOptionPane.showInputDialog(
                frame,
                "Select task you want to remove:",
                "Task to remove",
                JOptionPane.QUESTION_MESSAGE,
                null,
                taskName(),
                taskName()[0]
        );

        Task task = findTaskByName(removeTask);
        tasks.remove(task);

            JOptionPane.showMessageDialog(frame, "Task successfully removed!");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Problem occurred!");
            exception.printStackTrace();
        }
    }

    public void changeTaskStatus(){
        try {
        String selectedTask = (String) JOptionPane.showInputDialog(
                frame,
                "Please choose task, which you have completed: ",
                "Change status",
                JOptionPane.QUESTION_MESSAGE,
                null,
                taskName(),
                taskName()[0]
        );

        for (Task task: tasks){
            if (selectedTask.equals(task.getTaskName())){
                task.setTaskStatus(true);
            }
        }
            JOptionPane.showMessageDialog(frame, "Task status successfully changed");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Problem occurred!");
            exception.printStackTrace();
        }
    }

    public ArrayList<Task> getAllTasks(){
        return tasks;
    }

    public void viewTaskByName() {
        try {
            String selectedTaskName = (String) JOptionPane.showInputDialog(
                    frame,
                    "Select task you want to view:",
                    "Task to view",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    taskName(),
                    taskName()[0]
            );

            for (Task selectedTask : tasks) {
                if (selectedTask.getTaskName() == selectedTaskName)
            System.out.println("=== SELECTED TASK DETAILS ===\n" +
                    "______________________________________________");
            System.out.println(selectedTask);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Problem occurred! Task not found.");
            exception.printStackTrace();
        }
    }

    public void viewAllTasks(){
        String[] column = {"ID", "Task name", "Description", "Deadline", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);

        getAllTasks().forEach(task -> tableModel.addRow(
                new String[]{
                        String.valueOf(task.getTaskId()),
                        task.getTaskName(),
                        task.getTaskDescription(),
                        task.getTaskDeadline(),
                        task.getTaskStatus() ? "Completed" : "Pending",
                }
        ));

        displayTableLayout(tableModel);
    }

    public void displayTableLayout(DefaultTableModel tableModel){
        JTable table = new JTable(tableModel);

        frame.setTitle("To Do List App");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 600);

        frame.add(new JScrollPane(table), BorderLayout.WEST);

        frame.setVisible(true);
    }

//    public void convertedTaskFromFile(){
//        String[] column = {"ID", "Task name", "Description", "Deadline", "Status"};
//        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
//
//        for (Task task: getAllTasks()){
//            String[] convertedTask = {
//                    String.valueOf(task.getTaskId()),
//                    task.getTaskName(),
//                    task.getTaskDescription(),
//                    task.getTaskDeadline(),
//                    task.getTaskStatus() ? "Completed" : "Pending",
//            };
//            tableModel.addRow(convertedTask);
//        }
//    }
}
