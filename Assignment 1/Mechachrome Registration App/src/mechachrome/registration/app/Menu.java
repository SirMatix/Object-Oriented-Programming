/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechachrome.registration.app;

/**
 *
 * @author Person1
 */
public class Menu extends Methods {
    
    /**
     * System menu
     */
    public static void menu()
    {
        System.out.println(stars);
        System.out.println("\t Armstrong GP Surgery");
        System.out.println(stars);
        System.out.println("\t1. Register a new Patient");
        System.out.println("\t2. Book appointment");
        System.out.println("\t3. Cancel appointment");
        System.out.println("\t4. Edit Appointment");
        System.out.println("\t5. Remove patient from GP list");
        System.out.println("\t6. Search for appointments");
        System.out.println("\t7. View all patients");
        System.out.println("\t8. View Patient Profile");
        System.out.println("\t9. Mgmt Reporting.");
        System.out.println("\t10. Exit");
        System.out.print("Please choose option number: ");
    }
    
    /**
     * Shows system menu to the user. 
     */
    public static void showMenu()
    {        
        int option; // switch statement option
        boolean on = true;
        try{
            
        while(on)
        {
            menu();
            option = input.nextInt();
            switch(option)
            {
                case 1:
                    registerNewPat();
                    break;
                case 2:
                    bookAppoint();
                    break;
                case 3:
                    cancelAppoint();
                    break;
                case 4:
                    editAppoint();
                    break;
                case 5:
                    removePatient();
                    break;
                case 6:
                    searchAppoint();
                    break;
                case 7:
                    showAllPatients();
                    break;
                case 8:
                    viewPatient();
                    break;
                case 9:
                    mgmtReport();
                    break;
                case 10:
                    on = false;
                    break;
                default:
                    System.out.println("Enter valid option 1-10.");
            }
        }
        }
        catch(Exception e)
        {
               System.out.println("Error occured " + e);
               System.out.println("Please enter correct option type");
               System.out.println("Please start again!");
        }
    }

}
