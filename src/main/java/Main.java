import file.FileController;
import task.TaskController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        FileController fileController = new FileController();
        fileController.createNewFile();

        TaskController taskController = new TaskController();

        JOptionPane.showMessageDialog(null,"TO DO LIST APPLICATION");

        String menu = "";

        while (!menu.equals("0")){

            menu = JOptionPane.showInputDialog(
            "Please choose from menu options below:\n" +
            "1. Add new task\n" +
            "2. Remove task\n" +
            "3. Change task status\n" +
            "4. Find task by Name\n"+
            "5. See all tasks\n" +
            "6. Delete To Do List file\n" +
            "0. QUIT"
            );

            switch (menu){
                case "1":
                    taskController.newTask();
                    fileController.saveToFile();
                    break;
                case "2":
                    taskController.removeTask();
                    break;
                case "3":
                    taskController.changeTaskStatus();
                    fileController.saveToFile();
                    break;
                case "4":
                    taskController.viewTaskByName();
                    break;
                case "5":
                    taskController.viewAllTasks();
                    fileController.readFromFile();
                    break;
                case "6":
                    fileController.deleteFile();
                case "0":
                    System.exit(1);
                default:
                    JOptionPane.showMessageDialog(null,"Please choose valid option from menu!");
            }
        }

    }
}
