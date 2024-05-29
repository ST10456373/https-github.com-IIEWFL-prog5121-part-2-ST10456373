/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.addloginfeature;
import javax.swing.JOptionPane;

class Tasks {//The first thing is to declare all the variables that are to be used .
    private String tasksName;
    private String developersFirstName;
    private String developersLastName;
    private double durationHours;
    private String tasksStatus;
//This will be use to refer to the variables declared. 
    public Tasks(String taskName, String developerFirstName, String developerLastName, double durationHours) {
        this.tasksName = taskName;
        this.developersFirstName = developersFirstName;
        this.developersLastName = developersLastName;
        this.durationHours = durationHours;
        this.tasksStatus = "To Do"; 
    }
// the boolean will ensure to calculate the length is not more than 50 characters.
    public boolean checkTaskDescription() {
        return tasksName.length() <= 50;
    }
// this method creates and returns the taskID.
    public String createTaskID() {
        String initials = tasksName.substring(0, 2).toUpperCase();
        String devInitials = developersLastName.substring(developersLastName.length() - 3).toUpperCase();
        return initials + ":" + devInitials;
    }
//This method returns the tasks full task details of each task. 
    public String printTaskDetails() {
        return "Tasks Status: " + tasksStatus +
                "\nDeveloper Details: " + developersFirstName + " " + developersLastName +
                "\nTask Number: " + createTaskID() +
                "\nTask Name: " + tasksName +
                "\nTask Description: " + tasksName +
                "\nTask ID: " + createTaskID() +
                "\nDuration: " + durationHours + " hours";
    }
// this method returns the total combined hours of all entered tasks.
    public double returnTotalHours() {
        return durationHours;
    }
// this methods sets out the status of each task.
    public void setTaskStatus(String status) {
        this.tasksStatus = status;
    }
}
//this will be our main class.
public class ADDLOGINFEATURE {
    public static void main(String[] args) {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you have :"));
        Tasks[] tasks = new Tasks[numTasks];
        double totalHours = 0;
//the for loop aids to check the umber of tasks and increment each time the user adds TASK.
        for (int i = 0; i < numTasks; i++) {
            String tasksName = JOptionPane.showInputDialog("Please enter the task name:");
            String developersFirstName = JOptionPane.showInputDialog("Please enter the  developer's first name:");
            String developersLastName = JOptionPane.showInputDialog("Please enter the  developer's last name:");
            double durationHours = Double.parseDouble(JOptionPane.showInputDialog("please input task duration (hours):"));
//the if statement is in the inner structure and works to open the GUI to allow user to enter task.
            Tasks task = new Tasks(tasksName, developersFirstName, developersLastName, durationHours);
            if (task.checkTaskDescription()) {
                tasks[i] = task;
                totalHours += durationHours;
                task.setTaskStatus(JOptionPane.showInputDialog("please choose task status in the following choices: (To Do/Done/Doing):"));
            } else {
// Retry entering the task again if it did not work,TRY AGAIN PLEASE. 
                JOptionPane.showMessageDialog(null, "Please input a task description of less than 50 characters");
                i--; 
            }
        }
//this will work too show (display) all the information provided by the user 
        StringBuilder allTaskDetails = new StringBuilder("All of the  Task Details:\n");
        for (Tasks task : tasks) {
            if (task != null) {
                allTaskDetails.append(task.printTaskDetails()).append("\n\n");
            }
        }
//this will work to display the total hours combined in the tasks.
        JOptionPane.showMessageDialog(null, allTaskDetails.toString() +
                "this is the Total combined hours: " + totalHours + " HOURS");
    }
}