/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import javax.swing.JOptionPane;

/**
 *
 * @author griff
 */
public class StudentManager {
    StudentRecord head = null;
    StudentRegistration myApp;
    
    public StudentManager(StudentRegistration a) {
        myApp = a;
    }
    
    public boolean isEmpty()  {
        return head == null;
    }
    
    public void insert(StudentRecord newNode) { 
        if (isEmpty()) 
            head = newNode; // Insert at head of list
        else {
            StudentRecord current = head;   // Start traversal at head
            while (current.getNext() != null) // While not at the last node
            {
                current = current.getNext();
            }  //   go to the next node
            current.setNext( newNode ); // Do the insertion
        }      
    } // insert()
    public void addItem(String firstName, String lastName, String studentDegree, String studentMajor) {  // When adding a node, you will need to ask the user to enter all required information for that node.
        try {
            String fName = firstName;
            String lName = lastName;
            String degree = studentDegree;
            String major = studentMajor;
           
            StudentRecord addNode = new StudentRecord(fName, lName, degree, major); 
            insert(addNode);
        }
        catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "NOT FOUND - Information did not match", "NOT FOUND", JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    public void removeItem(String firstName, String lastName, String studentDegree, String studentMajor) {
        String fName = firstName;
        String lName = lastName;
        String degree = studentDegree;
        String major = studentMajor;

        StudentRecord removeNode = new StudentRecord(fName, lName, degree, major); 
        StudentRecord current = head;
        
            if( (removeNode.getFirstName().compareTo(current.getFirstName()) == 0) &&
                (removeNode.getLastName().compareTo(current.getLastName()) == 0) &&
                (removeNode.getDegreeStatus().equals(current.getDegreeStatus())) &&
                (removeNode.getMajor().equals(current.getMajor()))
                ){
                head = head.getNext();
                
                System.out.println("IF");
            }
            
            else {
                StudentRecord prevNode = head; // set pre to head of the list.
                StudentRecord nextNode = head.getNext(); // set next to node after head.
                
                while ((nextNode.getFirstName() != null) && !((removeNode.getFirstName().compareTo(nextNode.getFirstName()) == 0) &&
                (removeNode.getLastName().compareTo(nextNode.getLastName()) == 0) &&
                (removeNode.getDegreeStatus().equals(nextNode.getDegreeStatus())) &&
                (removeNode.getMajor().equals(nextNode.getMajor())))  ){
                    prevNode = nextNode;
                    nextNode = nextNode.getNext();
                    System.out.println("ELSE - WHILE");
                }
                
                if ( (removeNode.getFirstName().compareTo(nextNode.getFirstName()) == 0) &&
                (removeNode.getLastName().compareTo(nextNode.getLastName()) == 0) &&
                (removeNode.getDegreeStatus().equals(nextNode.getDegreeStatus())) &&
                (removeNode.getMajor().equals(nextNode.getMajor())) )
                {
                    prevNode.setNext(nextNode.getNext());
                    System.out.println("ELSE - IF");
                }
                else {
                    JOptionPane.showMessageDialog(null, "NOT FOUND - Information did not match", "NOT FOUND", JOptionPane.INFORMATION_MESSAGE);
                }
            } // end else   
        }
}
