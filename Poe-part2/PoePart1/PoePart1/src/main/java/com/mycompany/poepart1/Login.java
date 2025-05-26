/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private String cellNumber;
    
    // Constructor
    public Login(String firstName, String lastName, String userName, String passWord, String cellNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.cellNumber = cellNumber;
    }
    
    // Getter methods
    public String getFirstName() {
        return firstName;     
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return passWord;
    }
    
    public String getCellNumber() {
        return cellNumber;
    }
    
    // Setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassword(String passWord) {
        this.passWord = passWord;
    }
    
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    
    // Method to check username validity
    public boolean checkUserName() {
        return userName != null && userName.contains("_") && userName.length() <= 5;
    }
    
    // Method to return username validation message
    public String getUsernameMessage() {
        return checkUserName() ? "Username successfully captured." 
                              : "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
    }
    
    // Method to check password complexity
    public boolean checkPasswordComplexity() {
        if (passWord == null || passWord.length() < 8) return false;
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (char c : passWord.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        
        return hasCapital && hasNumber && hasSpecial;
    }
    
    // Method to return password validation message
    public String getPasswordMessage() {
        return checkPasswordComplexity() ? "Password successfully captured." 
                                        : "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }
    
    // Method to check cellphone number validity
    public boolean checkCellPhoneNumber() {
        return cellNumber != null && cellNumber.matches("^\\+27\\d{9}$");
    }
    
    // Method to return cellphone validation message
    public String getCellphoneMessage() {
        return checkCellPhoneNumber() ? "Cell phone number successfully added." 
                                     : "Cell phone number incorrectly formatted or does not contain international code.";
    }
    
    // Method to register user with validation
    public String registerUser() {
        String usernameMsg = getUsernameMessage();
        if (!usernameMsg.equals("Username successfully captured.")) {
            return usernameMsg;
        }
        
        String passwordMsg = getPasswordMessage();
        if (!passwordMsg.equals("Password successfully captured.")) {
            return passwordMsg;
        }
        
        String cellphoneMsg = getCellphoneMessage();
        if (!cellphoneMsg.equals("Cell phone number successfully added.")) {
            return cellphoneMsg;
        }
        
        return "User registered successfully!";
    }
    
    // Method to verify login credentials
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.userName.equals(enteredUsername) && this.passWord.equals(enteredPassword);
    }
    
    // Method to return login status message
    public String returnLoginStatus(boolean loginSuccess) {
        return loginSuccess ? "Welcome " + firstName + " " + lastName + ", it is great to see you again."
                           : "Username or password incorrect, please try again.";
    }
    
    // Additional method to handle complete login process
    public String performLogin(String enteredUsername, String enteredPassword) {
        boolean loginResult = loginUser(enteredUsername, enteredPassword);
        return returnLoginStatus(loginResult);
    }
}