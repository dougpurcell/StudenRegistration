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
            insert (addNode);
        }
        catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "NOT FOUND - Information did not match", "NOT FOUND", JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    public void removeItem(String firstName, String lastName, String studentDegree, String studentMajor) {  // When adding a node, you will need to ask the user to enter all required information for that node.
        String fName = firstName;
        String lName = lastName;
        String degree = studentDegree;
        String major = studentMajor;

        StudentRecord removeNode = new StudentRecord(fName, lName, degree, major); 
        
        StudentRecord current = head; // point to current node (to be added)
        StudentRecord prevNode = current; // will be use in the new list ot keep track fo the node before next.
        StudentRecord nextNode = current.getNext(); // will be use in the new list ot keep track fo the node after previous.
            
            if( (removeNode.getFirstName().compareTo(current.getFirstName()) == 0) &&
                (removeNode.getLastName().compareTo(current.getLastName()) == 0) &&
                (removeNode.getDegreeStatus() == current.getDegreeStatus()) &&
                (removeNode.getMajor() == current.getMajor())
                ){
                head = head.getNext();   
            }
            
            else {
                prevNode = head; // set pre to head of the list.
                nextNode = head.getNext(); // set next to node after head.
                
                while ((nextNode.getFirstName() != null) && !((removeNode.getFirstName().compareTo(nextNode.getFirstName()) == 0) &&
                (removeNode.getLastName().compareTo(nextNode.getLastName()) == 0) &&
                (removeNode.getDegreeStatus() == nextNode.getDegreeStatus()) &&
                (removeNode.getMajor() == nextNode.getMajor()))  ){
                    prevNode = nextNode;
                    nextNode = nextNode.getNext();
                }
                
                if ((removeNode.getFirstName().compareTo(nextNode.getFirstName()) == 0) &&
                (removeNode.getLastName().compareTo(nextNode.getLastName()) == 0) &&
                (removeNode.getDegreeStatus() == nextNode.getDegreeStatus()) &&
                (removeNode.getMajor() == nextNode.getMajor()))
                {
                    prevNode.setNext(nextNode.getNext());
                    
                }
                else {
                    JOptionPane.showMessageDialog(null, "NOT FOUND - Information did not match", "NOT FOUND", JOptionPane.INFORMATION_MESSAGE);
                }
            } // end else   
        }
}
