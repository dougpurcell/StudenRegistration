package studentregistration;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


//Database Class
public class Database {
    
//Declaration of variables    
// String filePath = "jdbc:ucanaccess:///Users/doug/Google Drive/College/IST411/hw4/StudentRegistration/StudentRegistration.accdb"; // macOS
String filePath = "jdbc:ucanaccess://E:\\griff\\College\\IST411\\hw4\\StudentRegistration\\StudentRegistration.accdb"; // PC
//createTable() drops the current table and creates a new one
    public void create() {
       try {
             // load database driver class
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
         // connect to database
         Connection con = DriverManager.getConnection(filePath);
         Statement stmt = con.createStatement();
         
         //this code may need to be commented out because an exception will be thrown
         //if this table doesn't exist in the database
         stmt.execute("DROP TABLE Students");
         
         stmt.execute("CREATE TABLE Students" + 
                         "(FirstName varchar(255)," +
                         " LastName varchar(255), " + 
                         "DegreeStatus varchar(255), Major varchar(255))");
        
         System.out.println("Created Students table");
         
         stmt.close();
         con.close();
        }
       // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null, 
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 );
      }//end catch block
      
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( null, 
            classNotFound.getMessage(), "Driver Not Found",
            JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }//end catch block
        
   }//end create()

    
//this method accepts the student data as input and stores it to the database 
    public void addStudent(StudentRecord student){
        try {
             // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
            // connect to database
            Connection con = DriverManager.getConnection(filePath);
         
            Statement stmt = con.createStatement();
            
            
            String fName = student.getFirstName();
            String lName = student.getLastName();
            String degree = student.getDegreeStatus();
            String major = student.getMajor();
            
            stmt.execute("INSERT INTO students VALUES('" + fName + "','" + lName + "','" + degree + "','" + major + "')");

            stmt.close();
            con.close();
        }//end try
        catch(Exception e){
                e.printStackTrace();
        }//end catch

    }//end addStudent()
    
    public void deleteStudent(StudentRecord student){
        try {
             // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

           
            // connect to database
            Connection con = DriverManager.getConnection(filePath);
         
            Statement stmt = con.createStatement();
            
            
            String fName = student.getFirstName();
            String lName = student.getLastName();
            String degree = student.getDegreeStatus();
            String major = student.getMajor();
            
            stmt.execute("DELETE * FROM students WHERE FirstName = '" + fName + "' and LastName = '" + lName + "' and DegreeStatus = '" + degree + "' and Major = '" + major + "'");

            stmt.close();
            con.close();
        }//end try
        catch ( SQLException sqlException ) {
            JOptionPane.showMessageDialog( null, 
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
            System.exit( 1 );
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end deleteStudent()
      
}// end Database class
    

