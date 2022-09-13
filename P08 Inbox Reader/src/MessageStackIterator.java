//////////////// P08 Inbox Reader //////////////////////////
//
// Title: MessageStackIterator
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

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class implements Iterator and acts as an iterator for the MessageStack class
 *
 */
public class MessageStackIterator implements Iterator<Message> {
  private LinkedNode<Message> next;// A LinkedNode containing the current message
  /**
   * Creates a new MessageStackIterator and initializes its private instance field
   * 
   * @param head the start of the Stack
   */
  public MessageStackIterator(LinkedNode<Message> head) {
    this.next = head;
  }
  /**
   * An overridden public instance method that checks if the current LinkedNode is null or not
   * 
   * @return true if this.next is not null and false otherwise
   */
  @Override
  public boolean hasNext() {
    if (this.next != null) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * An overriden public instnace method that returns the message at the current iteration and moves
   *  onto to the next message in the stack
   * 
   * @throws NoSuchElementException if the stack is either empty or exhausted
   */
  @Override
  public Message next() {
    // Checks if the current LinkedNode exists
    if (!(hasNext())) {
      throw new NoSuchElementException("Stack is either empty or exhausted");
    } 
    // Returns the data of the current node and sets next to the next node in the list
    else {
      Message temp = this.next.getData();
      this.next = this.next.getNext();
      return temp;
    }
  }
}
