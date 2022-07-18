package file;

import task.Task;
import task.TaskController;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileController{

    public ArrayList<Task> tasks = new ArrayList<>();

    String fileName = "ToDoList.csv";
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
            writer.write("Task ID  |" + " Name             |" + " Description                     |"
                    + " Deadline | " + " Status      |\n");
            for (Task task : tasks){
                writer.write(String.valueOf(task));
//                writer.write("\n");
            }
//            writer.flush();
            writer.close();
            System.out.println("Successfully saved to file");
        }catch (IOException exception){
            JOptionPane.showMessageDialog(null,"Problem occurred. Couldn't save to file.");
            exception.printStackTrace();
        }
    }
    public void readFromFile() {
        try {
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null,"An error occurred. Couldn't read file.");
            exception.printStackTrace();
        }
    }

    public void deleteFile() {
        if (myFile.delete()) {
            System.out.println("File " + myFile.getName() + " deleted successfully!");
        }else {
            System.out.println("Failed to delete the file " + myFile.getName());
        }
    }
}