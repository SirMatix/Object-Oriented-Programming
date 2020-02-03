/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechachrome.registration.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Mateusz Utracki-Janeta
 */
public class Methods {
    
    
    static public Calendar currentDate = Calendar.getInstance(); 
    static public SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static private SimpleDateFormat data2 = new SimpleDateFormat("dd/MM/yyyy");
    static public ArrayList<Patient> patientList = new ArrayList<>();
    static public ArrayList<Doctor> doctorList = new ArrayList<>();
    static public ArrayList<Appointment> appointmentList = new ArrayList<>();  
    static public final String stars = "******************************************" ;
    static public Scanner input = new Scanner(System.in); 
    static public String joindate;
    static private String day = data2.format(currentDate.getTime());
    static private final int normalFee = 100;
    static private final int yearFee = 1000;
    static private final double discount = 0.1;
    static private final double afterDiscount = yearFee - (yearFee * discount);
    
    
     /**
     * Method used to count user subscriptions
     * @return a number of subscriptions
     */
    public static int subsCounter()
    {
        int subs = 0; // integer number of subscribers
        boolean checkSub; // boolean for checking subscription
        for(Patient pat: patientList) // iterating through patients list
        {
            checkSub = pat.getFeeCheck(); // getting information about subscription
            if(checkSub == true)
            {
                subs += 1;
            }
        } 
        return subs;
    }
    
    /**
     * Method checks if Patient object has an appointment
     * @param pat  Patient for who we are checking the appointments
     * @return String time slot
     */
    public static String patHasApp(Patient pat)
    {
        String timeslot; Patient pat2; 
        timeslot = " ";
        for(Appointment app: appointmentList)
        {
            pat2 = app.getPatient();
            if(pat2.equals(pat)) // comparing user Patient object to Appointment Patient object
            {
                timeslot = app.getTimeSlotApp(); // getting time slot
            }
        }  
        return timeslot;
    }
    
    /**
     * Method reprints the Doctor object list without the given Doctor
     * @param doc the doctor excluded from the new list.
     */
    public static void reprintDocList(Doctor doc)
    {
        ArrayList<Doctor> tempList = new ArrayList<>();
        int num;
        for(Doctor d: doctorList)
        {
            tempList.add(d); // adding Doctor objects to temporary List
        }
        tempList.remove(doc); // removing parameter Doctor object from temporary List
        num = 0;
        for(Doctor d: tempList) // iterating through temporary list
        {
            num += 1;
            System.out.println(num + ". " + d.getWorkName()); // Printing the doctor workname
        }
    }
    
    /**
     * Returns ArrayList of Doctor objects without the object in parameter
     * 
     * @param doc the Doctor object to be excluded from the list
     * @return ArrayList of Doctor objects without object in parameter
     * 
     */
    public static ArrayList<Doctor> getNewDocList(Doctor doc)
    {
        ArrayList<Doctor> tempList = new ArrayList<>();
        for(Doctor d: doctorList)
        {
            tempList.add(d);
        }
        tempList.remove(doc);
        return tempList;
    }
    
    /**
     * Prints list of doctors working for the Armstrong GP Surgery
     */
    public static void printDocList()
    {
        System.out.println(stars);
        System.out.println("Printing doctor's list: ");
        for(int i =0; i<doctorList.size(); i++) // going through from 0 to doctorList size
        {
            int num = i + 1; // making a positive number out of index
            Doctor doc = doctorList.get(i); // getting doctor with "i" index
            System.out.println("\t" + num + " " + doc.getWorkName()); // printing out doctor with appropriate positive number
        }
        System.out.println(stars);
    }
    
    /**
     * Gets patient name and surname from the user
     * @return an Array of 2 Strings patient name and surname
     */
    public static String[] getPatientData()
    {
        String name; String surname; 
        String[] patientData = new String[2]; // Creating new array consiting of 2 Strings
        System.out.println("Please enter patient's details!");
        System.out.println("Name: ");
        input.nextLine();
        name = input.nextLine(); // inputting patient name
        System.out.println("Surname: ");
        surname = input.nextLine(); // inputting patient surname
        
        patientData[0] = name; // adding patient name on 0 index of patientData array
        patientData[1] = surname; // adding patient surname on 0 index of patientData array
        
        return patientData; // returnig patientData
    }
    
    /**
     * Searches for patient with given name and surname in ArrayList called patientList
     * @param check_name name by which method search the patient
     * @param check_surname surname by which method search the patient
     * @return Patient object from the patientList
     */
    public static Patient searchPatient(String check_name, String check_surname)
    {   
        // variable declaration start
        String name; String surname; Patient pt;
        // variable declaration stop

        pt = null;
        // asking receptioninst to input patient name and surname 
        for(Patient pat: patientList) // interating through patients list
        {
            name = pat.getName(); // getting patient name for patient pat on patient list
            surname = pat.getSurname(); // getting patient surname for patient pat on patient list
            if(check_name.equals(name) && check_surname.equals(surname)) 
                /* checks if name and surname inputted by receptionist is
                the same as name and surname of patient object on patient list */
            {
                pt = pat;
            }
        }
        return pt;
    }

    /**
     * Searches for doctor with the given surname in ArrayList called doctorList
     * @param check_name the surname of the doctor method is looking for
     * @return the doctor Object from doctorList
     */
    public static Doctor searchDoctor(String check_name)
    {   
        // variable declaration start
        String name; Doctor dr = null;
        // variable declaration stop
        
        check_name = "Dr. " + check_name;

        for(Doctor doc: doctorList) // interating through patients list
        {
            name = doc.getWorkName(); // getting patient name for patient pat on patient list
            if(check_name.equals(name)) 
                /* checks if name and surname inputted by receptionist is
                the same as name and surname of patient object on patient list */
            {
                dr = doc;
            }
        }
        return dr;
    }
    
    
    
    /**
     * Method used for registering new Patients.
     * 
     * The System prompts for data and user inputs it. After capturing data
     * Patient constructor is used to create a Patient object. At the end 
     * system ask for subscription and prints out the message of successful 
     * registration of a patient.
     * 
     * @return a patient Object
     */
    public static Patient registerNewPat()
    {
        String nam; String sur; String dob; String add; String post; String pho;
        String payment; String check;
        
        System.out.println("Please enter patients details!");
        
        System.out.println("Name: ");
        input.nextLine();
        nam = input.nextLine();
        System.out.println("Surname: ");
        sur = input.nextLine();
        System.out.println("Date of birth: ");
        dob = input.nextLine();
        System.out.println("Address: ");
        add = input.nextLine();
        System.out.println("Post code: ");
        post = input.nextLine();
        System.out.println("Phone number: ");
        pho = input.nextLine();
                            
        Patient temp = new Patient(nam,sur,dob,add,post,pho,joindate); // constructing a Patient object
        patientList.add(temp);  // adding constructed patient to patient list
        
        System.out.println(stars);
        System.out.println("Do you want to subscribe? (fee £1000) Y/N");
        System.out.print("Please chose your option: ");
        payment = input.nextLine();
        check = payment.toLowerCase();
        System.out.println(stars);
        
        if(check.equals("y")) // Checks if user option is Y
        {
            System.out.println(stars);
            System.out.println("Congratulations you qualified for a 10% discount!");
            System.out.println("\tThat will be £" + afterDiscount);
            System.out.println(stars);
            temp.setSubscription(); // changes patient subsrciption to true
        }
        
        // Printing out message about successful registration of a patient and patients ID
        
        System.out.println(stars);
        System.out.println("\tPatient has been registered!");
        System.out.println("\tPatient ID is " + temp.getId());
        System.out.println(stars);
        
        return temp; // returning Patient object
    }
    
    /**
     * Method used for booking appointment. 
     * 
     * The user inputs patient name and surname, method uses searchPatient()
     * then prints doctors list. User chooses doctor and then the Appointment
     * constructor is used to create an Appointment object with specified 
     * patient and doctor. At the end there is a message about payments
     * where user gets to choose how much he wants to pay.
     * 
     */
    public static void bookAppoint() 
    {
        // variable declaration start
        int docOption; String timeslot; Appointment app; boolean checkFee; Doctor dr;
        int payOption; String[] patientData;
        // variable declaration stop
        
        // data capture
        System.out.println(stars);
        patientData = getPatientData();
        System.out.println(stars);
        
        //getting patient object
        Patient pat = searchPatient(patientData[0], patientData[1]);
        
        //if there is no patient registers a new one
        if(pat == null)
        {
            System.out.println("Patient not in the system! Please register new patient!");
            pat = registerNewPat();
        }
        
        //prints doctor list
        printDocList();
        //ask to choose a doctor
        System.out.println(stars);
        System.out.print("Please choose a doctor:");
        docOption = input.nextInt();
        System.out.println(stars);

        
        if(patHasApp(pat).equals(" ")) // if patient has no appointment
        {
            switch(docOption) // switch statement to switch between doctors to book correct appointment.
            {
                /* every case is the same just different in variables so I described only one */
                case 1:
                    dr = doctorList.get(0);
                    timeslot = dr.getTimeslot();     // gets timeslot from doctor
                    app = new Appointment(pat, dr, timeslot);// create appointment object
                    appointmentList.add(app);  // adds appointment object to appointment list
                    System.out.println(stars);
                    System.out.println(app.message()); // prints out message of succesful registration of appointment
                    System.out.println(stars);
                    break;
                case 2:
                    dr = doctorList.get(1);
                    timeslot = dr.getTimeslot();     
                    app = new Appointment(pat, dr, timeslot);
                    appointmentList.add(app);
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;
                case 3:
                    dr = doctorList.get(2);
                    timeslot = dr.getTimeslot();   
                    app = new Appointment(pat, dr, timeslot);
                    appointmentList.add(app);
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;    
                case 4:
                    dr = doctorList.get(3);
                    timeslot = dr.getTimeslot();    
                    app = new Appointment(pat, dr, timeslot);
                    appointmentList.add(app);
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;    
                case 5:
                    dr = doctorList.get(4);
                    timeslot = dr.getTimeslot(); 
                    app = new Appointment(pat, dr, timeslot);
                    appointmentList.add(app);
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;    
            }
        }
        else // if patient has appointment
        {
            switch(docOption) // switch statement to switch between doctors to book correct appointment.
            {
                case 1:
                    dr = doctorList.get(0);
                    timeslot = dr.getDiffTimeSlot(patHasApp(pat));     // gets different timeslot from doctor
                    app = new Appointment(pat, dr, timeslot);// create appointment object
                    appointmentList.add(app);  // adds appointment object to appointment list
                    System.out.println(stars);
                    System.out.println(app.message()); // prints appointment message
                    System.out.println(stars);
                    break;
                case 2:
                    dr = doctorList.get(1);
                    timeslot = dr.getDiffTimeSlot(patHasApp(pat));     // gets different timeslot from doctor
                    app = new Appointment(pat, dr, timeslot);// create appointment object
                    appointmentList.add(app);  // adds appointment object to appointment list
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;
                case 3:
                    dr = doctorList.get(2);
                    timeslot = dr.getDiffTimeSlot(patHasApp(pat));     // gets different timeslot from doctor
                    app = new Appointment(pat, dr, timeslot);// create appointment object
                    appointmentList.add(app);  // adds appointment object to appointment list
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;
                case 4:
                    dr = doctorList.get(3);
                    timeslot = dr.getDiffTimeSlot(patHasApp(pat));     // gets different timeslot from doctor
                    app = new Appointment(pat, dr, timeslot);// create appointment object
                    appointmentList.add(app);  // adds appointment object to appointment list
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;
                case 5:
                    dr = doctorList.get(4);
                    timeslot = dr.getDiffTimeSlot(patHasApp(pat));     // gets timeslot from doctor
                    app = new Appointment(pat, dr, timeslot);// create appointment object
                    appointmentList.add(app);  // adds appointment object to appointment list
                    System.out.println(stars);
                    System.out.println(app.message());
                    System.out.println(stars);
                    break;    
            }
        }
        
        checkFee = pat.getFeeCheck(); // checks if patient has subscription
        if(checkFee == false) // no subscription
        {
            System.out.println(stars);
            System.out.println("Now, please choose payment option:");
            System.out.println("\t1. Fee for this appointment: £" + normalFee);
            System.out.println("\t2. Full year fee of: £" + yearFee);
            System.out.print("Please choose option:");
            payOption = input.nextInt();
            System.out.println(stars);
            switch(payOption)
            {
                case 1:
                    System.out.println("That will be £" + normalFee + " Thank You!");
                    break;
                case 2:
                    System.out.println("That will be £" + yearFee +  " Thank You");
                    pat.setSubscription(); // sets patient subsription
                    break;
            }
        }
        else // patient is a subscriber
        {
            System.out.println(stars);
            System.out.println("Patient is a subscriber!");
            System.out.println("\tThank You!");
            System.out.println(stars);     
        }
    }
    
    /**
     * Method used for cancelling booked appointments.
     * 
     * Uses getPatientData() for data capture then searchPatient()
     * for getting Patient object. Asks user for doctor surname
     * and uses searchDoctor() to get Doctor object. Iterates
     * through appointmentList get a patient and doctor from appointment
     * and compares them with the one inputted from user. If they match it
     * removes the appointment by its index from appointmentList.
     * 
     */
    public static void cancelAppoint() 
    {
        //Variable declaration start
        String[] patientData; Patient pat; Patient pat2; 
        Doctor doc; Doctor doc2; String check_docname; String tslot;
        //Variable declaration stop

        //Data capture
        patientData = getPatientData();

        //Doctor surname capture
        System.out.println("Please enter doctor's surname");
        check_docname = input.nextLine();

        
        doc = searchDoctor(check_docname); // getting doctor object
        pat = searchPatient(patientData[0],patientData[1]); // getting patient object
        
        for(int iter=0;iter<appointmentList.size();iter++) // iterates from 0 to appointmentList size
        {
            Appointment app = appointmentList.get(iter);// gets appointment object
            pat2 = app.getPatient(); // gets appointment Patient object
            doc2 = app.getDoctor(); // gets appointment Doctor object
            if(pat2.equals(pat) && doc2.equals(doc)) // compares user patient and doctor to appointments patient and doctor
            {
                tslot = app.getTimeSlotApp(); // gets appointment time slot
                doc2.getTimeslotBack(tslot); // gives time slot back to the doctor
                appointmentList.remove(iter); // removes appointment
                System.out.println(stars);
                System.out.println("Appointment has been cancelled!");
                System.out.println(stars);
            }
        }   
    }   
    
    /**
     * Method used for editing existing appointments.
     * 
     * Uses getPatientData() for data capture then searchPatient()
     * for getting Patient object. Asks user for doctor surname
     * and uses searchDoctor() to get Doctor object. Iterates
     * through appointmentList get a patient and doctor from appointment
     * and compares them with the one inputted from user. If they match it
     * asks user to change doctor or time of appointment.
     * 
     * Changing the doctor:
     * If this option is chosen program gets appointment time slot
     * rePrintDocList() is used to get new list without the current doctor then 
     * user chooses the new doctor and gives back the time slot to the previous 
     * doctor and picks first available time slot for new doctor
     * 
     * Changing the time:
     * If this option is chosen program prints appointment details, prints out 
     * available time slots. Gets old time slot gives it back to the doctor, 
     * changes the time slot and prints back changed details of appointment.
     * 
     * 
     */
    public static void editAppoint() 
    {
        // Variable declaration start
        String[] patientData; Patient pat; int i; Patient pat2; 
        Doctor doc; Doctor doc2; String check_docname; int choice; int choice2;
        Doctor temp; String tslot; String old_tslot;
        // Variable declaration stop
        
        
        // Data capture
        patientData = getPatientData();
        
        // Doctor surname capture
        System.out.println("Please enter docotor's surname:");
        check_docname = input.nextLine();

        // Getting user patient object
        pat = searchPatient(patientData[0],patientData[1]);
        // Getting user doctor object
        doc = searchDoctor(check_docname);
        
        for(Appointment app: appointmentList) // iterates through appointment list
        {
            pat2 = app.getPatient(); // gets appointment patient object
            doc2 = app.getDoctor(); // gets appointment doctor object
            if(pat2.equals(pat) && doc2.equals(doc)) // compares user patient and doctor to appointments patient and doctor if they equal
            {
                System.out.println(stars);
                System.out.println("Would you like to change:");
                System.out.println("\t1. Doctor");
                System.out.println("\t2. Time");
                System.out.println(stars);
                System.out.print("Plese enter choice: ");
                choice = input.nextInt(); // choice for switch option
                switch(choice)
                {
                    case 1: // case for changing the doctor
                        old_tslot = app.getTimeSlotApp(); // gets old timeslot
                        reprintDocList(doc); // reprints doctor list without the doctor
                        System.out.print("Please chose a doctor: ");
                        choice2 = input.nextInt(); // another choice for switch
                        switch(choice2)
                        {
                            /*
                                    Each case is basically the same in working 
                                    just the index from doctor list changes so not to
                                    generate too much comments I described fully just first case
                            */
                            case 1:
                                temp = getNewDocList(doc).get(0); // doctor object from 0 index on new doc list the new doctor
                                tslot = temp.getTimeslot(); // get timeslot from doctor temp
                                app.changeTimeSlot(tslot); // changes timeslot of appointment
                                app.changeDoc(temp); // chagnes doc of appointment
                                doc.getTimeslotBack(old_tslot); // gets the old time slot back to the previous doctor
                                System.out.println(stars);
                                System.out.println("Your appointment is now:");
                                app.details(); // prints out appointment details
                                System.out.println(stars);
                                break;
                            case 2:
                                temp = getNewDocList(doc).get(1);
                                tslot = temp.getTimeslot();
                                app.changeTimeSlot(tslot);
                                app.changeDoc(temp);
                                doc.getTimeslotBack(old_tslot);
                                System.out.println(stars);
                                System.out.println("Your appointment is now:");
                                app.details();
                                System.out.println(stars);
                                break;
                            case 3:
                                temp = getNewDocList(doc).get(2);
                                tslot = temp.getTimeslot();
                                app.changeTimeSlot(tslot);
                                app.changeDoc(temp);
                                doc.getTimeslotBack(old_tslot);
                                System.out.println(stars);
                                System.out.println("Your appointment is now:");
                                app.details();
                                System.out.println(stars);
                                break;
                            case 4:
                                temp = getNewDocList(doc).get(3);
                                tslot = temp.getTimeslot();
                                app.changeTimeSlot(tslot);
                                app.changeDoc(temp);
                                doc.getTimeslotBack(old_tslot);
                                System.out.println(stars);
                                System.out.println("Your appointment is now:");
                                app.details();
                                System.out.println(stars);
                                break;
                        }
                        break;
                    case 2: // case for changing appointment time slot
                        app.details(); // prints out appointment details
                        System.out.println(stars);
                        
                        doc.printTimeList(); // prints out doctors available timeslots
                        System.out.print("Please enter new time slot for appointment:");
                        input.nextLine();
                        tslot = input.nextLine(); // new time slot entered as a String from the user
                        old_tslot = app.getTimeSlotApp(); // old time slot from the appointment object
                        doc.getTimeslotBack(old_tslot); // gives old time slot back to the doctor
                        app.changeTimeSlot(tslot);       // changes time slot of appointment to new tslot give by user
                        System.out.println(stars);
                        System.out.println("Your appointment is now:");
                        app.details(); // prints out appointment details
                        System.out.println(stars);
                        break;
                }
            }
        }   
    }    
    
    /**
     * Method used for removing patient from Patients list.
     * 
     * Uses getPatientData() for data capture and searchPatient() to get patient
     * object. Iterates through patient list and gets each list index object. Compares
     * two Patient objects if the are equal it removes the patient object with appropriate
     * index from the patientList.
     * 
     */
    public static void removePatient() 
    {
        // Variable declaration start
        String[] patientData; Patient pat; Patient pat2;
        // Variable declaration stop

        // Patient data capture
        patientData = getPatientData();
        // Getting the user Patient object with patientData
        pat = searchPatient(patientData[0],patientData[1]);
        
        for (int i=0;i<patientList.size();i++) // iterating through patients list
        {
            pat2 = patientList.get(i); // getting Patient object from patient list
            if(pat2.equals(pat)) // comparing user patient object to patient on the list if they equal
            {
                patientList.remove(i); // removes element on i-th index
                System.out.println(stars);
                System.out.println("\tPatient: " + patientData[0] + " " + patientData[1]); // prints out patient name and surname
                System.out.println("\thas been succesfully removed from the system"); // removing message
                System.out.println(stars);
            }
            
        }
    }
    
    /**
     * Method used for printing patient details.
     * 
     * Iterates through patientList and prints patient details.
     */
    public static void showAllPatients() 
    {
        System.out.println(stars);
        System.out.println("Total number of patients " + patientList.size());
        System.out.println(stars);
        System.out.println("Patients details: ");
        for(Patient pat : patientList )
        {
            System.out.println(stars);
            System.out.println("Name:         " + pat.getName()); // prints patient name 
            System.out.println("Surname:      " + pat.getSurname()); // prints patient surname 
            System.out.println("Dob:          " + pat.getDob()); // prints patient date of birth 
            System.out.println("Address:      " + pat.getAddress()); // prints patient address 
            System.out.println("Post Code:    " + pat.getPost()); // prints patient post code 
            System.out.println("Phone:        " + pat.getPhone()); // prints patient phone number
            System.out.println("ID:           " + pat.getId()); // prints patient ID
            System.out.println("Join Date:    " + joindate); // prints patient joindate
            System.out.println("Subscription: " + pat.getFeeCheck()); // prints if patient is a subscriber
        }
        System.out.println(stars);
    }
    
    /**
     * Method used to search for appointment.
     * 
     * Method asks if user wants to search by patient or doctor.
     * 
     * Searching by patient:
     * Uses getPatientData() for data capture and searchPatient() to get patient
     * object. Iterates through appointmentList and gets appointment patient. Compares
     * user Patient object and appointment Patient object if they are equal prints out 
     * Patient appointment details.
     * 
     * Searching by doctor:
     * User inputs doctor's surname and method uses searchDoctor() to get doctor
     * object. Iterates through appointment list and gets appointment doctor. Compares
     * user Doctor and appointment Doctor if they are equal prints out all doctor's
     * appointments.
     * 
     */
    public static void searchAppoint() 
    {
        // variable declarataion start
        String[] patientData; int choice; String check_name;
        Patient pat; Doctor doc; Patient pat2; Doctor doc2; int num;
        // variable declaration end
       
        System.out.println(stars);
        System.out.println("Would you like to search for appointment");
        System.out.println("\t1. by Patient?");
        System.out.println("\t2. by Doctor?");
        System.out.print("Please enter option: ");
        choice = input.nextInt(); // switch statement choice variable
        System.out.println(stars);
        
        switch(choice) // switch statement to search appointment by doctor or patient
        {
            case 1:
                patientData = getPatientData(); // patient data capture
                pat = searchPatient(patientData[0],patientData[1]); // getting patient object
                num = 0; 
                System.out.println(" Appointments on " + day + ":"); //printing appointment date
                System.out.println("for " + patientData[0] + " " + patientData[1]); // printing patient name and surname
                for(Appointment app: appointmentList) // iterating through appointment list 
                {
                    pat2 = app.getPatient(); // getting appointment patient object
                    if(pat2.equals(pat)) // compares user patient object to appointment patient object if they equal
                    {
                        num += 1; // increments number by one by every iteration
                        System.out.println("\t" + num + ". " + app.showPatAppointment()); // prints number plus patient appointment information
                    }
                }
                break;
            case 2:
                System.out.println("Please enter doctor's surname");
                input.nextLine(); 
                check_name = input.nextLine();  // doctor's surname capture
                doc = searchDoctor(check_name); // getting user's doctor object
                num = 0;
                System.out.println(doc.getWorkName() + " appointments on " + day + ":");
                for(Appointment app: appointmentList) // iterating through appointments list
                {
                    doc2 = app.getDoctor(); // getting appointment doctor object
                    if(doc2.equals(doc)) // compares user doctor object and patient doctor object if they equal
                    {
                        num += 1; // increments number by one every iteration
                        System.out.println("\t" + num + ". " + app.showDocAppointment()); // prints out number and doctor appointment details
                    }
                }
                break;
        }
    }
    
    /**
     * Method used to view patients profile.
     * 
     * method uses getPatientData() for data capture and searchPatient()
     * for getting Patient object. Then it displays all Patients info
     * using Patient class get methods.
     */
    public static void viewPatient() 
    {
        //variable declaration start
        String[] patientData; Patient pat; int num; Patient pat2;
        //variable declaration stop
       
        //patient data capture
        System.out.println(stars);
        patientData = getPatientData();
        System.out.println(stars);
        
        //getting patient object
        pat = searchPatient(patientData[0],patientData[1]);
        
        num = 0; // number
        System.out.println(stars);
        System.out.println("Name:         " + pat.getName());
        System.out.println("Surname:      " + pat.getSurname());
        System.out.println("Dob:          " + pat.getDob());
        System.out.println("Address:      " + pat.getAddress());
        System.out.println("Post Code:    " + pat.getPost());
        System.out.println("Phone:        " + pat.getPhone());
        System.out.println("ID:           " + pat.getId()); 
        System.out.println("Join Date:    " + joindate);
        System.out.println("Subscription: " + pat.getFeeCheck());
        System.out.println(stars);
        System.out.println("\t" + day + " Appointments:");
        for(Appointment app: appointmentList) // iterating through appointment list 
        {
            pat2 = app.getPatient(); // getting appointment patient object
            if(pat2.equals(pat)) // compares user patient object to appointment patient object if they equal
            {
                num += 1; // increments number by one every loop
                System.out.println("\t" + num + ". " + app.showPatAppointment()); // shows number and patient appointment details
            }
        }
    }
    
    /**
     * Method for management reports.
     * 
     * Asks user to pick an option:
     * 1. List all the patients seen by a specific doctor.
     * 2. List all the doctors seen by a specific patient.
     * 3. Number of: Patients, Doctors, Appointment and subscribers
     * 

     */
    public static void mgmtReport() 
    {
        // Variable declaration start
        Doctor doc; Patient pat; int option; String surname;
        String[] patientData; Doctor check_doc; Patient check_pat;
        int subs;
        // Variable declaration stop
        
        // Getting number of subscribers
        subs = subsCounter();
        
        //submenu for the management report
        System.out.println(stars);
        System.out.println("\t 1. List all the patients seen by a specific doctor ");
        System.out.println("\t 2. List all the doctors seen by a specific patient ");
        System.out.println("\t 3. Number of: Patients, Doctors, Appointment and subscribers ");
        System.out.print("Please choose your option: ");
        input.nextLine();
        option = input.nextInt(); // option for switch method
        System.out.println(stars);
        
        switch(option)
        {
            case 1:
                System.out.println("Please enter doctor surname: ");
                input.nextLine();
                surname = input.nextLine(); // doctor surname capture
                doc = searchDoctor(surname); // getting doctor object
                System.out.println(doc.getWorkName() + " Appointments:");
                System.out.println(stars);
                for(Appointment app: appointmentList) // iterating through appointment list
                {
                    check_doc = app.getDoctor(); // getting appointment doctor object
                    if(check_doc.equals(doc)) // compares user doctor object with appointment doctor object if they equal
                    {
                        System.out.println(app.showDocAppointment());  // prints out doctor appointment details                      
                    }
                }
                System.out.println(stars);
                break;
                
            case 2:
                patientData = getPatientData(); // patient data capture
                pat = searchPatient(patientData[0],patientData[1]); // getting user patient object

                System.out.println(pat.getName() + " " + pat.getSurname() + " Appointments:"); // prints out patient name and surname and word appointents
                System.out.println(stars);
                for(Appointment app: appointmentList) // iterates through appointments list 
                {
                    check_pat = app.getPatient(); // gets appointment patient object
                    if(check_pat.equals(pat)) // compares appointment patient object with user patient object if they equals
                    {
                        System.out.println(app.showPatAppointment());      // prints out patient appointment details                  
                    }
                }
                System.out.println(stars);
                break;
                
            case 3:
                System.out.println("Data for Armstrong GP on " + joindate + ":");
                System.out.println("Overall number of registered patients: " + patientList.size());
                System.out.println("Overall number of registered doctors:  " + doctorList.size());
                System.out.println("Appointments booked:                   " + appointmentList.size());
                System.out.println("Number of subscribers:                 " + subs);
                break;
        }
    }      
}
