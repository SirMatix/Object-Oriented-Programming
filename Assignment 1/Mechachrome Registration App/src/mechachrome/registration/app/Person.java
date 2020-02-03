package mechachrome.registration.app;
/**
 * Person class.
 * 
 * Person class is a parent class for Patient and Doctor class.
 * It has all setters and getters methods.
 * 
 * @author Mateusz Utracki-Janeta
 */
public abstract class Person {
    private String name;
    private String surname;
    private String dob;
    private String address;
    private String postcode;
    private String phone;
    private String joindate;
    
    /**
     * Person class object constructor.
     * 
     * Creates and instance of Patient class.
     * 
     * @param name name as a String
     * @param surname surname as a String
     * @param dob date of birth as a String
     * @param address address as a String
     * @param postcode post code as a String
     * @param phone phone number as a String
     * @param joindate join date as a String
     */
    Person(String name, String surname, String dob, String address, String postcode, String phone, String joindate)
    {
        this.name = name;
        this.surname = surname;
        this.dob = dob;      
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.joindate = joindate;
    }
    
    /**
     * Get name method.
     * @return name as a String
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get surname method. 
     * @return surname as a String
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * Get date of birth method.
     * @return date of birth as a String
     */
    public String getDob()
    {
        return dob;
    }
    
    /**
     * Get address method.
     * @return address as a String
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * Get post code method.
     * @return post code as a String
     */
    public String getPost()
    {
        return postcode;
    }
    
    /**
     * Get phone number method,
     * @return phone number as a String
     */
    public String getPhone()
    {
        return phone;
    }
    /**
     * Method for printing patient full name.
     */
    public void printName()
    {
        System.out.println(getName() + " " + getSurname());
    }
    
    /**
     * Get join date method.
     * @return join date as a String
     */
    public String getJoindate()
    {
        return joindate;
    }
    
}
