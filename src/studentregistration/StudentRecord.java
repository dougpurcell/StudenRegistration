package studentregistration;
/*
 * StudentRecord.java
 *
 */

//The StudentRecord class contains information about each student. Instances of this class are created in the Applet. 
public class StudentRecord {

    private String firstName;       // first name of Student
    private String lastName;        // last name of Student
    private String degreeStatus;    // degree status of student
    private String major;           // student major
    private StudentRecord next;
    
    /** Creates a new instance of StudentRecord */
    public StudentRecord(String fName, String lName, String degStat, String maj) {
        firstName = fName;
        lastName = lName;
        degreeStatus = degStat;
        major = maj;
        next = null;
    }
    public void setNext(StudentRecord nextPtr) {
        next = nextPtr;
    } 
  
    public StudentRecord getNext() {
        return next;
    } 
    
//ACCESSORS
    //retrieves first name
    public String getFirstName(){
        return firstName;
    }//end getFirstName()
    
    //retrieves last name
    public String getLastName(){
        return lastName;
    }//end getLastName()
    
    //retrieves degree status
    public String getDegreeStatus(){
        return degreeStatus;
    }//end getDegreeStatus()
    
    //retrieves major
    public String getMajor(){
        return major;
    }//end getMajor()
 
//MUTATORS 
    //sets first name
    public void setFirstName(String fName){
        firstName = fName;
    }//end setFirstName()
    
    //sets last name
    public void setLastName(String lName){
        lastName = lName;
    }//end setLastName()
    
    //sets degree status
    public void setDegreeStatus(String degStat){
        degreeStatus = degStat;
    }//end setDegreeStatus()
    
    //sets major
    public void setMajor(String maj){
        major = maj;
    }//end setMajor()
   
    
    public String toString(){
        return firstName + " " + lastName + "       " + degreeStatus + "         " + major;
    }
  
   
}//end StudentRecord Class
