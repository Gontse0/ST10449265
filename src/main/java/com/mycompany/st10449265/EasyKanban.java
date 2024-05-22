/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10449265;

import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author RC_Student_lab
 */
public class EasyKanban {
    static Login l = new Login();
    static Tasks t = new Tasks ();
    static boolean tasksAdded = false;
    static int numOfTasks;
    static String[] taskName, description, developer, taskID, status;
    static int[] taskNumber, duration;
    
    
  
    public void easykanban(){
        Scanner scanner = new Scanner (System.in);
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban");
        
        while (true){
            String choice = JOptionPane.showInputDialog("Option 1) Add Task" + "\nOption 2) Report" + "\nOption 3) Quit");
            
            if (choice.equals("1")){
                l.returnLoginStatus();
                JOptionPane.showMessageDialog(null, l.loginmessage);
                
                if (l.loginValid) {
                    break;
                }
            }
           
                    if(choice.equals("2")){
                        l.registerUser();
                        JOptionPane.showMessageDialog(null, l.registerMessage);
                        
                    }
            
              if (choice.equals("3")){
                  System.exit(0);
              }      
        }
        while (l.loginValid){
        String choice = JOptionPane.showInputDialog("""
                                                    Option 1) Add tasks
                                                    Option 2) Show report
                                                    Option 3) View all done tasks
                                                    Option 4) Longest task
                                                    Option 5) Search for task by task name
                                                    Option 6) Search for task by developer name
                                                    Option 7) Delete a task
                                                    Option 8) Quit""");
        if (choice.equals ("8")){
            System.exit(0);
            
        }
        if (!choice.equals("1")&& tasksAdded){
            choices(choice);
        }
        if (choice.equals("1")&& tasksAdded){
            String choice2 = JOptionPane.showInputDialog("You have already added tasks!\n" + "Do you want add different ones?\nOption 1)Yes\nOption 2) No");
            if (choice2.equals("1")){
                addTasks();
            }
        }else if(choice.equals("1")){
            addTasks();
        }else if(!tasksAdded && !choice.equals("1")){
            
        }
    }
    }
public static void choices(String choice){
    switch (choice) {
        case "2":
            t.report(numOfTasks, taskNumber, status, developer, taskName, description, taskID, duration);
            break;
        case "3":
            t.doneTasks(numOfTasks, status, developer, taskNumber, duration);
            break;
        case "4":
            t.longest(numOfTasks, duration,developer);
            break;
         case "5":
             t.searchTask(numOfTasks, taskName, developer, status);
             break;
        case "6":
            t.searchDev(numOfTasks, taskName, developer, status);
            break;
        case "7": 
           delete();
           break;
     
        case "8":
           System.exit(0);
            break;
 }
 }
  //This method is used for adding Tasks
  public void addTasks() {
 //numOfTasks is used to store number of tasks the user wants to enter(used to set arrays length)
  numOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks you wish to enter"));
 //arrays used to store tasks info
 taskName = new String[numOfTasks];
 description = new String[numOfTasks];
 developer = new String[numOfTasks];
 taskID = new String[numOfTasks];
 status = new String[numOfTasks];
 taskNumber = new int[numOfTasks];
 duration = new int[numOfTasks];

 //loop runs as many times as numOfTasks
 for (int i = 0; i < numOfTasks; i++) {
 taskName[i] = JOptionPane.showInputDialog("Enter the name of the " + (i + 1) + " task");
 taskNumber[i] = i;
 
 String temp;
 //Prompting the user to enter description, until the description matches the requirements
 do {
 temp = JOptionPane.showInputDialog("Enter task description");
 } while (!t.checkTaskDescription(temp));
 description[i] = temp;
 developer[i] = JOptionPane.showInputDialog("Enter developer name");
 duration[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter duration of task in hours"));
 //Generates a taskID using the taskNumber, taskName and the developer name
 taskID[i] = t.createTaskID(i, taskName[i], developer[i]);
 //Options that the user chooses, the status is set
 temp = JOptionPane.showInputDialog("Option 1) " + t.status1 + "\n" +
 "Option 2) " + t.status2 + "\n" +
 "Option 3) " + t.status3 + "\n");
 switch (temp) {
 case "1":
 status[i] = t.status1;
 break;
 case "2":
 status[i] = t.status2;
 break;
 case "3":
 status[i] = t.status3;
 break;
 }
//Displaying the details of the captured task
 JOptionPane.showMessageDialog(null, t.printTaskDetails(taskNumber[i],
 status[i], developer[i], taskName[i], description[i], taskID[i],
 duration[i]));
 }
 //Adds up all the hours of each task's duration
 JOptionPane.showMessageDialog(null, "The total number of hours " +
 "across all tasks is: " + t.returnTotalHours(duration) + "hrs");
 tasksAdded = true;
 }
 public static void delete(){
 String search = JOptionPane.showInputDialog("Enter the name of the task you want to delete");
 boolean flag = false;
 for (int i = 0; i < numOfTasks; i++){
 if(search.equals(taskName[i])){
 taskName[i] = null;
 description[i] = null;
 developer[i] = null;
 taskID[i] = null;
 status[i] = null;
 taskNumber[i] = 0;
 duration[i] = 0;
 flag = true;
 }
 }
 if (!flag){
 JOptionPane.showMessageDialog(null, "The task you entered cant be found!");
 }else{
 JOptionPane.showMessageDialog(null,"Done!");

}
}
}         
    
           
      

    

