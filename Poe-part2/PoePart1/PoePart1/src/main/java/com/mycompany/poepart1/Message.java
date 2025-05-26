/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
 import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
public class Message {
    private static int messagesSent = 0;
    private int messageId;
    private String recipient;
    private String content;
    private String messageHash;
    
    public Message(String recipient, String content) {
        this.messageId = generateMessageId();
        this.recipient = recipient;
        this.content = content;
        this.messageHash = createMessageHash();
        messagesSent++;
    }
    public String validateMessageLength() {
        if (content.length() > 250) {
            int excess = content.length() - 250;
            return String.format("Message exceeds 250 characters by a further %d characters, please reduce size.", excess);
        }
        return "Message ready to send.";
    }
    
    public static String validateRecipientFormat(String recipient) {
        if (recipient == null || !Pattern.matches("^\\+\\d{1,10}$", recipient)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        return "Cell phone number successfully captured.";
    }
    
    public String requestMessage() {
        return "Press 0 to delete message.";
    }
    
    public String storeMessage() {
        return "Message successfully stored.";
    }
    
    private int generateMessageId() {
        return new Random().nextInt(90) + 10; // Generates random 2-digit number
    }
    
    public boolean checkMessageId() {
        return String.valueOf(messageId).length() <= 10;
    }
    
    public static boolean checkRecipient(String recipient) {
    if (recipient == null) {
        return false;
    }
    return Pattern.matches("^\\+\\d{1,10}$", recipient);
    }
    
    private String createMessageHash() {
        String[] words = content.split(" ");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 0 ? words[words.length - 1] : "";
        String[] colors = {"RED", "BLU", "GRN", "YLW"};
        String color = colors[new Random().nextInt(colors.length)];
        
        return String.format("%02d:%s:%d:%s_%s", 
            messageId, color, content.length(), firstWord.toUpperCase(), lastWord.toUpperCase());
    }
    
    public String sendMessage() {
        return "Message sent successfully!";
    }
    
    public String printMessage() {
        return String.format(
            "Message Details:\nID: %d\nRecipient: %s\nContent: %s\nHash: %s\n",
            messageId, recipient, content, messageHash
        );
    }
    
    public static int getTotalMessagesSent() {
        return messagesSent;
    }
    
    
    // Getters
    public int getMessageId() { return messageId; }
    public String getRecipient() { return recipient; }
    public String getContent() { return content; }
    public String getMessageHash() { return messageHash; }
}
    

