
package mechachrome.registration.app;

import java.util.Random;

/**
 * Patient class.
 * 
 * Patient class extends Person class it has additional
 * attributes like fullyPaid and patientID . It is used to 
 * create patient object.
 * 
 * @author Mateusz Utracki-Janeta
 */
public class Patient extends Person
{    
    private final String patientID;
    private boolean fullyPaid;    
    private Random num = new Random();

    /**
     * Patient class object constructor.
     * 
     * Boolean fullPaid is used to no if a Patient is a subscriber, patientID is
     * being set by a setID() method, patientID is final.
     * 
     * @param name Patient name as a String
     * @param surname Patient surname as a String
     * @param dob Patient date of birth as a String
     * @param address Patient address as a String 
     * @param postcode Patient post code as a String
     * @param phone Patient phone number as a String
     * @param joindate Patient join date as a String
     *
     */
    Patient(String name, String surname, String dob, String address, String postcode, String phone, String joindate)
    {
        super(name,surname,dob,address,postcode,phone,joindate);
        this.patientID = setID();
        fullyPaid = false; // set false by default because not every patient is a subscriber
    }
    /**
     * Method to set patientID
     * 
     * This method takes first three letter of the Patient
     * surname and generates random number from 100 to 999
     * and adds it to an unique patientID which is final.
     * 
     * @return final String patientID
     */
    private final String setID()
    {
        String tempID = "";
        for(int i=0; i < 3; i++) // iterate from 0 to 3
        {
            tempID += super.getSurname().charAt(i);
            // gets character on the i-th position from Patients surname
        }

        tempID = tempID.toUpperCase(); // sets ID to uppercase
        tempID += 100 + num.nextInt(999); // adds random 3 digit number to patientID
        
        return tempID; // returns the ID
    }
    /**
     * Method for setting Patient subscription.
     * It changes the value of boolean fullyPaid to true.
     * 
     */
    public void setSubscription()
    {
        fullyPaid = true;
    }   
    /**
     * Getter for checking subscription
     * @return boolean fullyPaid
     */
    public boolean getFeeCheck()
    {
        return fullyPaid;
    }  
    /**
     * Getter for patientID variable
     * @return patientID variable
     */
    public String getId()
    {
        return patientID;
    }  
}