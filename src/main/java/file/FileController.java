package file;

import org.apache.commons.lang3.StringUtils;
import task.Task;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileController{

    private ArrayList<Task> tasks = new ArrayList<>();
    String fileName = "ToDoList.txt";
    File myFile = new File(fileName);

    public void createNewFile() {
        try {
            if (myFile.createNewFile()) {
        System.out.println("File created: " + myFile.getName());
            }
        }catch (IOException exception){
            System.out.println("An error occurred");
            exception.printStackTrace();
        }
    }

    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter(fileName);
            for (Task task : tasks){
                writer.write(String.valueOf(task));
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully saved to file");
        }catch (IOException exception){
            JOptionPane.showMessageDialog(null,"Problem occurred. Couldn't save to file.");
            exception.printStackTrace();
        }
    }

//    public void readFromFile() { //need some configuration, update after file lessons
//
//        try {
//            Scanner scanner = new Scanner(myFile);
//            while (scanner.hasNextLine()) {
//                String data = scanner.nextLine();
//                System.out.println(data);
//            }
//            scanner.close();
//        } catch (FileNotFoundException exception) {
//            JOptionPane.showMessageDialog(null,"An error occurred. Couldn't read file.");
//            exception.printStackTrace();
//        }
//    }

    public void deleteFile() {

        if (myFile.delete()) {
            JOptionPane.showMessageDialog(null,"File " + myFile.getName() + " deleted successfully!");
        }else {
            JOptionPane.showMessageDialog(null,"Failed to delete the file " + myFile.getName());
        }
    }

//        public void transferDataFromFile(){ //need some configuration, update after file lessons
//        createNewFile();
//        try {
//            Scanner scanner = new Scanner(fileName);
//            int i=0;
//            while (scanner.hasNextLine()) {
//
//                String line = scanner.nextLine();
//                if(line.equals(null)){
//                    break;
//                }else{
//                    i++;
//                    String id = String.valueOf(StringUtils.substringBetween(line, "ID: ", " |"));
//                    Integer taskId = Integer.parseInt(id);
//                    String taskName = String.valueOf(StringUtils.substringBetween(line, "Name: ", " |"));
//                    String taskDescription = String.valueOf(StringUtils.substringBetween(line, "Description: ", " |"));
//                    String taskDeadline = String.valueOf(StringUtils.substringBetween(line, "Deadline: ", " |"));
//                    String status = String.valueOf(StringUtils.substringBetween(line, "Status: ", " |"));
//                    Boolean taskStatus = Boolean.parseBoolean(status);
//
//                    Task task = new Task(taskId, taskName, taskDescription, taskDeadline, taskStatus);
//                    tasks.add(task);
//
//                }
//            }
//            System.out.println(i + " Task was added from file!");
//            scanner.close();
//        } catch (Exception exception) {
//            JOptionPane.showMessageDialog(null, "An error occurred.");
//            exception.printStackTrace();
//        }
//    }

}