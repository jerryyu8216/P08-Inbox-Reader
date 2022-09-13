//////////////// P08 Inbox Reader //////////////////////////
//
// Title: InboxReaderTester
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

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of the implementation of the
 * MessageStack, Inbox, and MessageStackIterator classes defined in the CS300 Fall 2020 - P08 LIFO
 * Inbox Reader programming assignment.
 *
 */
public class InboxReaderTester {

  /**
   * Calls runInboxReaderTestSuite() method and prints out return value
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("runInboxReaderTestSuite(): " + runInboxReaderTestSuite());
  }

  /**
   * Calls all testMethods
   * 
   * @return true if all test methods return true and false otherwise
   */
  public static boolean runInboxReaderTestSuite() {
    if (testStackConstructorIsEmptyPushPeek() && testStackPop() && testInboxReadMessage()
        && testInboxReceiveMessage() && testInboxMarkAllMessagesAsRead()
        && testMessageStackIterator()) {
      return true;
    } else {
      return false;
    }
  }
  // add the runInboxReaderTestSuite() method and your additional tester methods

  /**
   * Checks for the correctness of the constructor of the MessageStack, MessageStack.push(),
   * MessageStack.peek(), MessageStack.isEmpty(), and MessageStack.size() methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testStackConstructorIsEmptyPushPeek() {
    Message.resetIdGenerator();
    try {
      // Scenario 1: Create a new MessageStack object
      MessageStack myMessages = new MessageStack();
      if (!(myMessages.isEmpty()) && myMessages.size() != 0) {
        return false;
      }
      // Scenario 2: Calling peek method on empty stack
      try {
        myMessages.peek();
        System.out.println("Exception was not thrown when peek was called on empty stack");
        return false;
      } catch (EmptyStackException ee) {
        // Expected exception to be thrown
      }
      // Scenario 3: Push a message into an empty stack
      Message myMessage1 = new Message("Food", "Hamburger");
      myMessages.push(myMessage1);
      if (myMessages.peek() != myMessage1 || myMessages.size() != 1
          || myMessages.isEmpty() != false) {
        return false;
      }
      // Scenario 4: Push a message into a non-empty stack
      Message myMessage2 = new Message("Sports", "Basketball");
      myMessages.push(myMessage2);
      if (myMessages.peek() != myMessage2 || myMessages.size() != 2
          || myMessages.isEmpty() != false) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown Exception was thrown");
      return false;
    }
    return true;
  } //


  /**
   * Checks for the correctness of MessageStack.pop() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testStackPop() {
    Message.resetIdGenerator();
    try {
      MessageStack myMessages = new MessageStack();
      // Scenario 1: Calling pop() on an empty stack
      try {
        myMessages.pop();
        System.out.println("Exception was not thrown when pop was called on empty stack");
        return false;
      } catch (EmptyStackException ee) {
        // Expected exception to be thrown
      }
      // Scenario 2: Calling pop() on a stack with only one element
      Message myMessage1 = new Message("Food", "Hamburger");
      myMessages.push(myMessage1);
      Message expected1 = myMessages.pop();
      if (expected1 != myMessage1 || myMessages.isEmpty() != true || myMessages.size() != 0) {
        return false;
      }
      // Scenario 3: Calling pop() on a stack with at least three elements
      Message myMessage2 = new Message("Sports", "Basketball");
      Message myMessage3 = new Message("Country", "China");
      myMessages.push(myMessage1);
      myMessages.push(myMessage2);
      myMessages.push(myMessage3);
      Message expected2 = myMessages.pop();
      if (expected2 != myMessage3 || myMessages.isEmpty() != false || myMessages.size() != 2
          || myMessages.peek() != myMessage2) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown Exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of the Inbox.ReadMessage() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testInboxReadMessage() {
    Message.resetIdGenerator();
    try {
      Inbox i = new Inbox();
      // Scenario 1: Calling readMessage() when Inbox.unreadMessageBox is empty
      String expected1 = new String("Nothing in Unread");
      if (!(i.readMessage().equals(expected1))) {
        return false;
      }
      // Scenario 2: Calling readMessage() when Inbox.unreadMessageBox is not empty
      Message myMessage = new Message("Food", "Hamburger");
      String expected2 = myMessage.toString();
      i.receiveMessage(myMessage);
      if (!(i.readMessage().equals(expected2)) || !(i.peekReadMessage().equals(expected2))) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown Exception was thrown");
      return false;
    }
    return true;
  }


  /**
   * Checks for the correctness of the Inbox.ReceiveMessage() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testInboxReceiveMessage() {
    Message.resetIdGenerator();
    try {
      Inbox i = new Inbox();
      // Scenario 1: Adding a message to an empty unreadMessageBox
      Message myMessage1 = new Message("Food", "Hamburger");
      i.receiveMessage(myMessage1);
      if (!(i.readMessage().equals(myMessage1.toString()))) {
        return false;
      }
      // Scenario 2: Adding a message to a non-empty unreadMessageBox
      Message myMessage2 = new Message("Sports", "Basketball");
      i.receiveMessage(myMessage1);
      i.receiveMessage(myMessage2);
      if (!(i.readMessage().equals(myMessage2.toString()))) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown Exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of the Inbox.markAllMessagesAsRead() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testInboxMarkAllMessagesAsRead() {
    Message.resetIdGenerator();
    // Define your own test scenarios to check the correctness of Inbox.markAllMessagesAsRead()
    // Your test method must return false if it detects at least one defect
    try {
      Inbox i = new Inbox();
      // Scenario 1: Call markAllMessagesAsRead() for an empty inbox
      if (i.markAllMessagesAsRead() != 0) {
        return false;
      }
      // Scenario 2: Call markAllMessagesAsRead() for an unreadMessageBox with one message
      Message myMessage1 = new Message("Food", "Hamburger");
      i.receiveMessage(myMessage1);
      if (i.markAllMessagesAsRead() != 1 || !(i.peekReadMessage().equals(myMessage1.toString()))) {
        return false;
      }
      // Scenario 3: Call markAllMessagesAsRead() for an unreadMessageBox with more than one message
      Message myMessage2 = new Message("Sports", "Basketball");
      i.receiveMessage(myMessage1);
      i.receiveMessage(myMessage2);
      int size1 = 0;
      int size2 = 3;
      String expected = new String("Unread " + size1 + "\n" + "Read " + size2);
      if (i.markAllMessagesAsRead() != 2 || !(i.getStatistics().equals(expected))) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown Exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MessageStackIterator.hasNext() and MessageStackIterator.next()
   * methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testMessageStackIterator() {
    Message.resetIdGenerator();
    try {
      // Creating a MessageStack to be tested
      Message myMessage1 = new Message("Food", "Hamburger");
      Message myMessage2 = new Message("Sports", "Basketball");
      Message myMessage3 = new Message("Country", "China");
      LinkedNode<Message> node3 = new LinkedNode<Message>(myMessage3);
      LinkedNode<Message> node2 = new LinkedNode<Message>(myMessage2, node3);
      LinkedNode<Message> node1 = new LinkedNode<Message>(myMessage1, node2);
      MessageStackIterator i = new MessageStackIterator(node1);
      // Scenario 1: First call of next()
      if (i.next() != myMessage1) {
        return false;
      }
      // Scenario 2: Call hasNext() on iterator
      if (i.hasNext() != true) {
        return false;
      }
      // Scenario 3: Call next() for linked node at index 1
      if (i.next() != myMessage2) {
        return false;
      }
      // Scenario 4: Call next() for linked node at index 2
      if (i.next() != myMessage3) {
        return false;
      }
      // Scenario 5: Call hasNext() for the last linked node
      if (i.hasNext() != false) {
        return false;
      }
      try {
        i.next();
        System.out.println("Exception was not thrown when next() was called for last linked node");
        return false;
      } catch (NoSuchElementException ne) {
        // Expected exception to be thrown
      }
    } catch (Exception e) {
      System.out.println("Unknown Exception was thrown");
      return false;
    }
    return true;
  }
}
