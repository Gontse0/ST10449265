/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10449265;
import javax.swing.JOptionPane;
import java.util.Scanner;


/**
 *
 * @author RC_Student_lab
 */
public class Login {
   
    public void login() {
        Scanner scanner = new Scanner(System.in); {
        JOptionPane.showMessageDialog(null, "Welcome back! Please login with your details.");
    }
   //Prompting the user to enter their log in details
    String UserName = JOptionPane.showInputDialog(null, "Please enter username");
    String Password = JOptionPane.showInputDialog(null, "Please enter your Password");
    String FirstName;
    String LastName;
    }
  //Declaring the variables
    private String UserName;
    private String Password;
    private String FirstName;
    private String LastName;
    
    //Ensures username contains an underscore and is no more than 5 characters
    public boolean checkUserName(String UserName){
        return UserName.length() <= 5 || !UserName.contains("_");
    }
    
    //Ensures the password meets the password complexity rules
    
    public boolean checkPasswordComplexity(String Paasword) {
        boolean lengthRequirement = Password.length()>=8;
        boolean containsCapital = Password.equals(Password.toLowerCase());
        boolean containsNumber = Password.matches(".*\\d.*");
        boolean containsSpecialCharacter = Password.matches("[A-Za-z0-9]*");
        
        return lengthRequirement && containsCapital && containsNumber && containsSpecialCharacter;
    }
    
    //Returns the necessary registration message
    public String registerUser (String UserName,String Password, String FirstName,String LastName) {
        if (!checkUserName(UserName)){
            return "UserName is not correctly formatted, please ensure that your Username contains an underscore and is no more than 5 Charecters in length.";
        }else if (!checkPasswordComplexity(Password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }else {
            this.UserName = UserName;
            this.Password = Password;
            this.FirstName = FirstName;
            this.LastName = LastName;
            return "Login Successful";
            
        }
    }  

    void returnLoginStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

       
  
    

