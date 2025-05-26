/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

public class MessageTest {

    @Test
public void testMessageConstructorAndGetters() {
    Message message = new Message("+1234567890", "Hello World");
    
    assertTrue(message.getMessageId() >= 10 && message.getMessageId() <= 99);
    assertEquals("+1234567890", message.getRecipient());
    assertEquals("Hello World", message.getContent());
    assertNotNull(message.getMessageHash());
}

    @Test
    public void testGenerateMessageId() {
        Message message = new Message("+1234567890", "Test");
        int messageId = message.getMessageId();
        
        assertTrue(messageId >= 10 && messageId <= 99);
        assertTrue(message.checkMessageId());
    }

    @Test
public void testCheckRecipient() {
    // Test valid recipients
    assertTrue(Message.checkRecipient("+1234567890"));
    assertTrue(Message.checkRecipient("+1"));
    
    // Test invalid recipients
    assertFalse(Message.checkRecipient("1234567890")); // missing +
    assertFalse(Message.checkRecipient("+12345678901")); // too long
    assertFalse(Message.checkRecipient("+abcdefghij")); // non-digits
    
    // Test edge cases
    assertFalse(Message.checkRecipient("")); // empty string
    assertFalse(Message.checkRecipient(null)); // null value
}

    @Test
    public void testCreateMessageHash() {
        Message message = new Message("+1234567890", "This is a test message");
        String hash = message.getMessageHash();
        
        // Hash format: %02d:%s:%d:%s_%s
        String[] parts = hash.split(":");
        assertEquals(4, parts.length);
        
        // Check message ID part
        assertEquals(2, parts[0].length());
        assertEquals(message.getMessageId(), Integer.parseInt(parts[0]));
        
        // Check color part
        assertTrue(parts[1].matches("RED|BLU|GRN|YLW"));
        
        // Check length part
        assertEquals(message.getContent().length(), Integer.parseInt(parts[2]));
        
        // Check first and last words
        String[] wordsParts = parts[3].split("_");
        assertEquals(2, wordsParts.length);
        assertEquals("THIS", wordsParts[0]);
        assertEquals("MESSAGE", wordsParts[1]);
    }

    @Test
    public void testCreateMessageHashWithEmptyContent() {
        Message message = new Message("+1234567890", "");
        String hash = message.getMessageHash();
        
        String[] parts = hash.split(":");
        assertEquals(4, parts.length);
        assertEquals("0", parts[2]); // length should be 0
        assertTrue(parts[3].equals("_") || parts[3].equals("__")); // empty first and last words
    }

    @Test
    public void testSendMessage() {
        Message message = new Message("+1234567890", "Test");
        assertEquals("Message sent successfully!", message.sendMessage());
    }

    @Test
    public void testPrintMessage() {
        Message message = new Message("+1234567890", "Test message");
        String printed = message.printMessage();
        
        assertTrue(printed.contains("Message Details:"));
        assertTrue(printed.contains("ID: " + message.getMessageId()));
        assertTrue(printed.contains("Recipient: +1234567890"));
        assertTrue(printed.contains("Content: Test message"));
        assertTrue(printed.contains("Hash: " + message.getMessageHash()));
    }

    @Test
    public void testMessagesSentCounter() {
        int initialCount = Message.getTotalMessagesSent();
        
        Message m1 = new Message("+1", "First");
        assertEquals(initialCount + 1, Message.getTotalMessagesSent());
        
        Message m2 = new Message("+12", "Second");
        assertEquals(initialCount + 2, Message.getTotalMessagesSent());
        
        Message m3 = new Message("+123", "Third");
        assertEquals(initialCount + 3, Message.getTotalMessagesSent());
    }

    @Test
    public void testCheckMessageId() {
        Message message = new Message("+123", "Test");
        assertTrue(message.checkMessageId());
    }
}