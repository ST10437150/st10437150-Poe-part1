/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    @Test
    public void testCheckUserNameCorrectFormat() {
        // Create a login object with valid username format
        Login login = new Login("Kyle", "Smith", "kyl_1", "Password1!", "+27831234567");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserNameIncorrectFormat() {
        // Create a login object with invalid username format
        Login login = new Login("Kyle", "Smith", "kyle!!!!!!!", "Password1!", "+27831234567");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityCorrectFormat() {
        // Create a login object with valid password format
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&ssec@ke99!", "+27831234567");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityIncorrectFormat() {
        // Create a login object with invalid password format
        Login login = new Login("Kyle", "Smith", "kyl_1", "weak", "+27831234567");
        assertFalse(login.checkPasswordComplexity());
    }
}