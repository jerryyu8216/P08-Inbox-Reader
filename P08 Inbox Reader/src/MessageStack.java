//////////////// P08 Inbox Reader //////////////////////////
//
// Title: MessageStack
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
import java.util.Iterator;

public class MessageStack implements StackADT<Message>, Iterable<Message> {
  private LinkedNode<Message> top; // A LinkedNode representing the top of the stack
  private int size; // An integer containing the number of messages in the stack

  /**
   * An overridden public instance method that adds a new message to the top of the stack
   * 
   */
  @Override
  public void push(Message element) {
    // Create new LinkedNode that contains the new message
    LinkedNode<Message> add = new LinkedNode<Message>(element);
    // Adds the new LinkedNode to the top of the stack
    add.setNext(top);
    top = add;
    // Increment size
    size++;
  }
 /**
  * An Overridden public instance method that removes the message at the top of the stack and
  * returns the removed message
  * 
  * @throws EmptyStackException if the stack is empty
  * @return the removed message
  */
  @Override
  public Message pop() {
    // Checks if the stack is empty
    if (size == 0) {
      throw new EmptyStackException();
    } 
    else {
      // Removes the top message
      LinkedNode<Message> temp = top;
      top = top.getNext();
      // Decrement size
      size--;
      return temp.getData();
    }
  }
 /**
  * An Overridden public instance method that returns the message at the top of the stack
  * 
  * @throws EmptyStackException if the stack is empty
  * @return the message at the top of the stack
  */
  @Override
  public Message peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return top.getData();
  }
 /** 
  * An Overridden public instance method that checks if the stack is empty
  * 
  * @return true if the stack is empty and false otherwise
  */
  @Override
  public boolean isEmpty() {
    if (size > 0) {
      return false;
    }
    return true;
  }
 /**
  * An Overridden public instance method that gets the size of the stack
  * 
  * @return the number of messages in the stack
  */
  @Override
  public int size() {
    return size;
  }
 /**
  * An Overridden public instance method that creates a new MessageStackIterator and returns it
  * 
  * @return the MessageStackIterator created
  */
  @Override
  public Iterator<Message> iterator() {
    MessageStackIterator i = new MessageStackIterator(top);
    return i;
  }

}
