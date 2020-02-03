
package mechachrome.registration.app;

import static  mechachrome.registration.app.Methods.data;
import static  mechachrome.registration.app.Methods.currentDate;

/**
 * Application for Armstrong GP.
 * 
 * This application is used to register new Patients to the clinic, manage their 
 * appointments and payments. It has fours classes:
 * 
 * + Methods
 * + Menu
 * + Person
 * + Patient
 * + Doctor
 * + Appointment
 * 
 * This classes interact with each other. Making booking, deleting, editing and 
 * searching for appointment possible.
 * 
 * @author Mateusz Utracki-Janeta
 */
public class ArmstrongGP 
{ 
    static public String joindate;
  
    
    /**
     *  Main method of the Armstrong GP Registration App.
     * 
     * It used to show the menu and create 5 Patient and Doctor instances.
     * 
     * @param args Arguments
     */
    public static void main(String[] args) 
    {  
        
        joindate = data.format(currentDate.getTime()); 

        /* 5 Patient object defined for testing */
        Methods.patientList.add(new Patient("Mateusz", "Utracki-Janeta", "01/01/0001", "54 Gap Year", "CV5 5GP", "7568493923", joindate));
        Methods.patientList.add(new Patient("Johnattan", "Salesman", "02/12/1954", "532 Old Man Rd", "BG3 32P", "123456789012", joindate));
        Methods.patientList.add(new Patient("Maria", "Harrietson", "13/02/1987", "512 Growl House", "CV3 8AF", "98765432109", joindate));
        Methods.patientList.add(new Patient("Dennise", "Natgood", "30/06/1994", "150 Freeman Street", "CV1 1WT", "321532665", joindate));
        Methods.patientList.add(new Patient("John", "Doe", "03/08/1975", "534 Ground Floor", "CV3 6VP", "4326254586", joindate));
        
        /* 5 Doctor objects defined for testing */
        Methods.doctorList.add(new Doctor("Gregory", "House", "25/04/1975", "46 Alex Jones Rd", "CV9 3DA", "7893762132", joindate, "AM"));
        Methods.doctorList.add(new Doctor("Jasmine", "Queen", "09/07/1987", "76 Marc Jacobs Ave", "CV6 2DF", "7432109352", joindate, "AM"));
        Methods.doctorList.add(new Doctor("Joseph", "Lister", "05/04/1987", "12 The Doctor Road", "CV1 1FN", "09812376232", joindate, "AM"));
        Methods.doctorList.add(new Doctor("Armania", "Bayer", "14/09/1975", "123 High Street", "CV9 9FU", "43925254324", joindate, "PM"));
        Methods.doctorList.add(new Doctor("Hannibal", "Lecter", "12/12/1965", "321 Silence of Lambs st", "CV6 666", "3210543532", joindate, "PM"));
        
        Menu.showMenu(); // Calling the showMenu() method
    }
   
 }