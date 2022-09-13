//////////////// P08 Inbox Reader //////////////////////////
//
// Title: Inbox
// Course: CS 300 Fall 2020
//
// Author: Jerry Yu
// Email: jcyu4@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class acts as an inbox and carries read messages and unread messages. These messageboxes can
 * then be manipulated with the methods defined within this class
 *
 */
public class Inbox {
  private MessageStack readMessageBox; // A messageStack containing all read messages
  private MessageStack unreadMessageBox; // A messageStack containing all unread messages
  /**
   * A no parameter constructor that creates a new Inbox and initializes its private instance fields
   * 
   */
  public Inbox() {
    readMessageBox = new MessageStack();
    unreadMessageBox = new MessageStack();
  }
  /**
   * A public instance method that reads the message at the top of the unreadMessageBox and puts the 
   * message into the readMessageBox
   * 
   * @return the string representation of the message at the top of the unreadMessageBox or "Nothing
   * in Unread" if the unreadMessageBox of this inbox is empty
   */
  public String readMessage() {
    // Checks if the unreadMessageBox is empty
    if (unreadMessageBox.isEmpty()) {
      return "Nothing in Unread";
    }
    else {
      // Creates temporary message to store message at the top of unreadMessageBox
      Message temp = unreadMessageBox.pop();
      // Adds the message to the top of readMessageBox
      readMessageBox.push(temp);
      return temp.toString();
    }
  }
 /**
  * A public instance method that returns the string representation of the message at the top of the
  * readMessageBox
  *  
  * @return the string representation of the message at the top of readMessageBox or "Nothing in
  * Read" if the readMessageBox is empty
  */
  public String peekReadMessage() {
    // Checks if readMessageBox is empty
    if (readMessageBox.isEmpty()) {
      return "Nothing in Read";
    } 
    else {
      return readMessageBox.peek().toString();
    }
  }
 /**
  * A public instance method that marks all messages in the unread message box as read
  * 
  * @return the total number of messages marked as read
  */
  public int markAllMessagesAsRead() {
    int i = 0;
    int numMessages = unreadMessageBox.size();
    // Moves all messages in unreadMessageBox into the readMessageBox
    while (i < numMessages) {
      Message temp = unreadMessageBox.pop();
      readMessageBox.push(temp);
      i++;
    }
    return numMessages;
  }
 /**
  * A public instance method that pushes a new message into the unreadMessageBox
  * 
  * @param newMessage the new message that has just been received
  */
  public void receiveMessage(Message newMessage) {
    unreadMessageBox.push(newMessage);
  }
 /**
  * A public instance method that removes all messages in the readMessageBox
  * 
  * @return the number of messages removed
  */
  public int emptyReadMessageBox() {
    int i = 0;
    int numMessages = readMessageBox.size();
    // removes all messages in the readMessageBox
    while (i < numMessages) {
      readMessageBox.pop();
      i++;
    }
    return numMessages;
  }
 /** 
  * A public instance method that creates a new string that contains the number of messages in both
  * the unreadMessageBox and readMessageBox
  * 
  * @return the string containing the statistics of the inbox
  */
  public String getStatistics() {
    int size1 = unreadMessageBox.size();
    int size2 = readMessageBox.size();
    return "Unread " + size1 + "\n" + "Read " + size2;
  }
 /**
  * A public instance method that traverses the unreadMessageBox and returns a string containing the
  * contents of the unreadMessagebox
  * 
  * @return a string representation of the contents of the unread message box
  */
  public String traverseUnreadMessages() {
    String allMessages = "";
    for (Message m : unreadMessageBox) {
      allMessages = allMessages + "(" + m.getID() + " " + m.getSUBJECT() + ")\n";
    }
    return "Unread(" + unreadMessageBox.size() + ")\n" + allMessages;
  }
  /**
   * A public instance method that traverses the readMessageBox and returns a string containing the
   * contents of the readMessagebox
   * 
   * @return a string representation of the contents of the read message box
   */
  public String traverseReadMessages() {
    String allMessages = "";
    for (Message m : readMessageBox) {
      allMessages = allMessages + "(" + m.getID() + " " + m.getSUBJECT() + ")\n";
    }
    return "Read(" + readMessageBox.size() + ")\n" + allMessages;
  }
}
