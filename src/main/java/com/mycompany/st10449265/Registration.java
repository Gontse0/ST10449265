/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10449265;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Registration {
    //Declaring variables
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    
    
   
    
    public void registration()  {
        
        Scanner scanner = new Scanner(System.in); {
        JOptionPane.showMessageDialog(null, "Welcome! Create your account.");
    } 
        // Prompting the user to enter their first and last name
           String firstName = JOptionPane.showInputDialog(null, "Enter first name:");
        
        String lastName = JOptionPane.showInputDialog(null, "Enter last name:");
        
        String username = JOptionPane.showInputDialog(null,"Please create a username:");
        if (username!= null&& username.length() <= 5 || !username.contains("_")){
            JOptionPane.showMessageDialog(null,"Username successfully captured.");
        } else{
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
        }
       //Prompting the user to enter their password
        String password = JOptionPane.showInputDialog(null,"Please create a password:");
        
        if (password != null && password.length() <= 8 || 
                
                password.matches(".*[A-Z].*") ||
                password.matches(".*\\d.*") || 
                password.matches(".*[!@#$%^&*()].*")){
            JOptionPane.showMessageDialog(null,"Password successfully captured.");
            
        }else{
            JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        } 
        
    }
}
        


    

