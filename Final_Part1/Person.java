package Final_Part1;
import Stack.LinkedDataStack;

import java.util.Iterator;


public class Person {
	
	private LinkedDataStack<Person> friends = new LinkedDataStack<Person>();
	private LinkedDataStack<String> messages = new LinkedDataStack<String>();
	private String name;
	
	// Create a new Person with this name.
    public Person(String name) {
        this.name = name;
    }

    // Make these two people become friends with each other.
    // Throw an exception if you try to meet yourself.
    // We are allowed to assume we didn't meet this person yet.
    public void meet(Person otherPerson) {
        friends.push(otherPerson);
        otherPerson.getFriends().push(this);
    }

    // Are these two people friends?
    // Throw an exception if you ask about knowing yourself.
    public boolean knows(Person otherPerson) {
    	Iterator<Person> it = friends.getIterator();
    	if(it.hasNext()){
	        while(it.hasNext()){
	        	if(it.next() == otherPerson){
	        		return true;
	        	}
	        }
    	}
        return false;
    }

    // Post a message to my list and the lists of all my friends
    public void post(String message) {
       Iterator<Person> it = friends.getIterator();
       if(it.hasNext()){
    	   it.next().messages.push(message);;
    	   while(it.hasNext()){
    		   it.next().messages.push(message);
    	   }
       }
    }

    // Print a header, then all messages this Person can read, newest first
    public void listMessages() {
       Iterator<String> it = getMessages().getIterator();
       System.out.println(name + "'s messages: ");
       while(it.hasNext()){
    	   System.out.println(it.next());
       }
    }
    
    public LinkedDataStack<Person> getFriends(){
    	return friends;
    }
    
    public LinkedDataStack<String> getMessages(){
    	return messages;
    }

}
