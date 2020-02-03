
package mechachrome.registration.app;

/**
 * Appointment Class.
 * 
 * Appointment Class is used to create an Appointment object
 * which has a Patient class object, Doctor class object and 
 * time slot String inside. 
 * 
 * @author Mateusz Utracki-Janeta
 */

public class Appointment {
    private Patient pat; // Patient Class object
    private Doctor doc; // Doctor Class object
    private String timeslot; // String time slot
    
    /**
     * Appointment Constructor.
     * 
     * Creates instance of Appointment class. 
     * 
     * @param pat Patient class object 
     * @param doc Doctor class object
     * @param timeslot String
     */
    Appointment(Patient pat, Doctor doc, String timeslot)
    {
        this.pat = pat;
        this.doc = doc;
        this.timeslot = timeslot;
    }
    
    /**
     * Prints out appointment message.
     * 
     * Message contains information about appointment.
     * 
     * @return String message with appointment details
     */
    public String message()
    {
        String message; String pname; String docname;
        pname = pat.getName() + " " + pat.getSurname();
        docname = doc.getWorkName();
 
        message = pname + " will see " + docname + " at " + timeslot;
        
        return message;
    }
    
    /**
     * Getter for time slot attribute.
     * 
     * Gets time slot from appointment object.
     * @return String time slot
     */
    public String getTimeSlotApp()
    {
        return timeslot;
    }
    
    /**
     * Getter for Patient object attribute
     * 
     * Gets Patient object from appointment object.
     * @return Patient object
     */
    public Patient getPatient()
    {
        return pat;
    }
    
    /**
     * Getter for Doctor object attribute.
     * 
     * Gets Doctor object from appointment.
     * @return Doctor object
     */
    public Doctor getDoctor()
    {
        return doc;
    }
    
    /**
     * Prints out details of appointment.
     * 
     * Prints out Doctor object work name and time slot 
     */
    public void details()
    {
        System.out.println(doc.getWorkName());
        System.out.println(timeslot);
    }
    
    /**
     * Shows appointment from Doctors perspective.
     * 
     * @return a String with Patient object name attribute and surname attribute and time slot.
     */
    public String showDocAppointment()
    {
        String pname; String app;
        
        pname = pat.getName() + " " + pat.getSurname();
        app = timeslot + " with " + pname;   
        return app;
    }
    
    /**
     * Shows appointment from Patients perspective.
     * 
     * @return a String with time slot and Doctor object name attribute and surname attribute.
     */
    public String showPatAppointment()
    {
        String docname; String app;
        
        docname = doc.getName() + " " + doc.getSurname();
        app = timeslot + " to " + docname;   
        return app;
    }
    
    /**
     * Method used to change appointment Doctor object.
     * 
     * @param dr the new Doctor object for appointment.
     */
    public void changeDoc(Doctor dr)
    {
        doc = dr;
    }
    
    /**
     * Method used to change time slot String.
     * 
     * @param tslot new time slot String for appointment.
     */
    public void changeTimeSlot(String tslot)
    {
        timeslot = tslot;
    }
}