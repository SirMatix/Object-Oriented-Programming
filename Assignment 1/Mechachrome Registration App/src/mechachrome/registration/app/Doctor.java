
package mechachrome.registration.app;

import java.util.ArrayList;
import java.util.List;
/**
 * Doctor class.
 * 
 * Doctor class extends Person class it has additional
 * attributes like shift, work name. It is used to 
 * create doctor object.
 * 
 * @author Mateusz Utracki-Janeta
 */
public class Doctor extends Person {
    
    private final String workname;
    private String shift;
    private List<String> timeList;
    private final List<String> checkTimeList;

    /**
     * Doctor class object constructor.
     * @param name Doctor name as a String
     * @param surname Doctor surname as a String
     * @param dob Doctor date of birth as a String
     * @param address Doctor address as a String 
     * @param postcode Doctor post code as a String
     * @param phone Doctor phone number as a String
     * @param joindate Doctor join date as a String
     * @param shift Doctor shift as a String
     */
    public Doctor(String name, String surname, String dob, String address, String postcode, String phone, String joindate, String shift)
    {
        super(name,surname,dob,address,postcode,phone,joindate);
        this.workname = "Dr. " + getSurname();
        this.shift = shift;
        timeList = setTimeSlot();
        checkTimeList = setTimeSlot();
    }
    /**
     * Get work name method.
     * @return Doctor work name as a String
     */
    public String getWorkName()
    {
        return workname;
    }
    /**
     * Set time slot method.
     * 
     * Used to set Doctor time slot list based on Doctors shift.
     * Each doctor has to be able to have 6 appointments of maximum
     * 1 hour time.
     * 
     * @return List of available time slots
     */
    public List<String> setTimeSlot()
    {
        /*
            Armstrong Clinic is opened for 24 hours so doctors have two shifts AM
            and PM. Based on that shifts the doctor timeslots are defined.        
        */
        List<String> timeSlotList = new ArrayList();  //array list of available timeslots
        switch (shift) {
            case "AM":
                timeSlotList.add("8-9");
                timeSlotList.add("9-10");
                timeSlotList.add("11-12");
                timeSlotList.add("12-13");
                timeSlotList.add("14-15");
                timeSlotList.add("15-16");
                break;
            case "PM":
                timeSlotList.add("14-15");
                timeSlotList.add("15-16");
                timeSlotList.add("16-17");
                timeSlotList.add("17-18");
                timeSlotList.add("18-19");
                timeSlotList.add("19-20");
                break;
        }
        
        return timeSlotList;
    }
    
    /**
     * Get time slot method.
     * 
     * Used for getting the first available time slot and
     * removing it from the time slot list.
     * @return time slot as a String
     */
    public String getTimeslot()
    {
        String timeslot;
        timeslot = timeList.get(0);
        timeList.remove(0);     
        return timeslot;
    }
    
    /**
     * Get time slot index method.
     * 
     * Used to get index of time slot in the parameter
     * @param tslot time slot of which index we search for
     * @return time slot index as a integer
     */
    public int getTimeSlotIndex(String tslot)
    {
        // variable declaration start
        int timeslot_index; String check_timeslot;
        // variable declaration stop
        
        timeslot_index = 0;
        for(int i=0;i<checkTimeList.size();i++) // iterates through checkTimeList 
        {
            check_timeslot = checkTimeList.get(i); // get elemnt on i-th index from the list
            if(check_timeslot.equals(tslot))  // checks if element from the list is the same as method attribute
            {
                timeslot_index = i; // sets timeslot_index to i
            }
        }
        
        return timeslot_index; // returns timeslot index
    }
    
    /**
     * Get time slot back method.
     * 
     * Used to get back to the Doctor object time slot in the parameter
     * @param tslot time slot which we are giving back to the Doctor
     */
    public void getTimeslotBack(String tslot) 
    {
        List<String> timeSlotList = new ArrayList(); // temporary timeslot list 
        int timeslot_index; // timeslot index
        
        timeslot_index = getTimeSlotIndex(tslot);
        
        for(int i=0;i<timeList.size();i++) // iterates through timeList
        {
             timeSlotList.add(timeList.get(i)); // adds elements from timeList to timeSlotList
        }
        timeSlotList.add(timeslot_index,tslot); // gets the timeslot back to its initial position
        timeList = timeSlotList; // makes timeList equal to timeSlotList
    }
    /**
     * Print time list method.
     * Used to print available time slots for Doctor object
     */
    public void printTimeList()
    {
        System.out.println(workname + " available appointments: ");
        for(int i=0;i<timeList.size();i++)
        {
            System.out.println(timeList.get(i));
        }
    }
    /**
     * Get different time slot method.
     * 
     * Used to get a different time slot for Doctor object.
     * @param timeslot time slot we want to replace
     * @return first available different time slot as a String
     */
    public String getDiffTimeSlot(String timeslot)
    {
        // Variable declaration start
        String second_timeslot; String check_timeslot;
        List<String> timeSlotList = new ArrayList(); 
        // Variable declaration stop
        
        for(int i=0;i<timeList.size();i++) // iterating through time list with i as iterator
        {
            timeSlotList.add(timeList.get(i));   // getting i-th index object from time list and adding it to new time slot list
        }
        for(int i=0;i<timeSlotList.size();i++) // iterating through time slot list with i as iterator
        {
            check_timeslot = timeSlotList.get(i); // check time slot variable gets i-th index object from time slot list
            if(check_timeslot.equals(timeslot)) // checks if check time slot variable is the same as time slot parameter if it is
            {
                timeSlotList.remove(i); // it removes the element on the appropriate index
            }
        }
        second_timeslot = timeSlotList.get(0); // gets the first available time slot
        return second_timeslot; // returns new timeslot
    }

}



